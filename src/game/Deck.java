package game;


import java.util.Arrays;
import java.util.Random;

public class Deck {

    private Card []cards;



    void takeCards(){

        int MaxNumber = 14;
        int length = cards.length;

        for (int i = 0; i < length; i++) {
            switch ((length - i - 1) % 4){
                case 0:
                    cards[length - i - 1] = new Card(Card.Suit.HEART, MaxNumber - (i / 4));
                    break;
                case 1:
                    cards[length - i - 1] = new Card(Card.Suit.SPADE, MaxNumber - (i / 4));
                    break;
                case 2:
                    cards[length - i - 1] = new Card(Card.Suit.DIAMOND, MaxNumber - (i / 4));
                    break;
                case 3:
                    cards[length - i - 1] = new Card(Card.Suit.CLUB, MaxNumber - (i / 4));
                    break;
                default:
                    cards[i] = new Card(Card.Suit.HEART, MaxNumber - (i / 4));
            }
        }


    }

    String showCards(){
        String message = new String();

        for(Card x: cards){
            message += x.toString();
            message += System.lineSeparator();
        }

        return message;
    }

    Card showFirst(){
        return cards[0];
    }


    void shuffleCards(){
        Random random = new Random();
        int length = cards.length;

        for(int i = 0; i < length; i++){
            swapCards(cards[i], cards[random.nextInt(length)]);
        }
    }

    void swapCards(Card cardOne, Card cardTwo){
        //System.out.println("Start: \ncard1 " + cardOne + "\ncard2 " + cardTwo);
        Card temp = new Card();
        temp.assignment(cardOne);
        cardOne.assignment(cardTwo);
        cardTwo.assignment(temp);
        //System.out.println("END: \ncard1 " + cardOne + "\ncard2 " + cardTwo);

    }


    void sortCards(){
        Arrays.sort(cards);
    }


    public Card[] getCards() {
        return cards;
    }

    Deck(int n){

        cards = new Card[n];
        if (n == 56 || n == 32 || n == 24)
            takeCards();

    }
}
