package game;

//Tworzymy klasę karty
//Wartość karty jest oznaczana liczbowo
//Joker = 0
//Jobek = 11
//Dama = 12
//Król = 13
//Ass = 14

public class Card implements Comparable<Card> {

    public enum Suit{
        HEART, SPADE, CLUB, DIAMOND
    }
    private Suit suit;
    private int value;


    public void assignment(Card otherCard){
        this.suit = otherCard.suit;
        this.value = otherCard.value;
    }

    @Override
    public int compareTo(Card otherCard){
        if(value < otherCard.value)
            return  -1;
        if(value > otherCard.value)
            return 1;
        else
            return suit.compareTo(otherCard.suit);
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(! (o instanceof Card))
            return false;

        Card otherCard = (Card) o;

        return otherCard.suit.equals(this.suit) && otherCard.value == this.value;



    }

    @Override
    public String toString(){
        String message;

        switch (getValue()){
            case 1:
                message = "joker";
                break;
            case 11:
                message = "jobek";
                break;
            case 12:
                message = "dama";
                break;
            case 13:
                message = "król";
                break;
            case 14:
                message = "ass";
                break;
            default:
                message = Integer.toString(getValue());
                break;
        }
        return message + " - " + getSuit();
    }

    Suit getSuit() {
        return suit;
    }

    void setSuit(Suit suit) {
        this.suit = suit;
    }

    int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }
    Card(){
        //do nothing
    }

    Card (Suit suit, int value){
        this.suit = suit;
        if(value >= 0 && value <= 14){
            this.value = value;
        }
    }
}
