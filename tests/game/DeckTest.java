package game;

import junit.framework.TestCase;

import java.util.Random;

public class DeckTest extends TestCase {
    int cardsSize = 24;

    public void testTakeCards() throws Exception {
        Deck deck1 = new Deck(cardsSize);
        assertNotNull( "Talia nie zostałą wypełniona kartami" ,deck1.showFirst());

        Deck deck2 = new Deck(4);
        assertNull("Talia zostala wypelniona jakimis kartami", deck2.showFirst());
    }

    public void testShuffleCards() throws Exception {
        Deck deck = new Deck(cardsSize);
        boolean sorted = true;
        Card previousOne = deck.showFirst();


        deck.shuffleCards();

        for(Card x: deck.getCards()){
            if(previousOne.compareTo(x) > 0){
                sorted = false;
                break;
            }

            previousOne = x;
        }

        assertFalse("Karty są posortowane", sorted);
    }

    public void testSwapCards() throws Exception {
        Deck deck = new Deck(cardsSize);
        Card []cards = deck.getCards();
        Random random = new Random();

        //Numers to swap
        int n1 = random.nextInt(cardsSize);
        int n2 = random.nextInt(cardsSize);

        Card temp1 = new Card(cards[n1].getSuit(), cards[n1].getValue());
        Card temp2 = new Card(cards[n2].getSuit(), cards[n2].getValue());

        deck.swapCards(cards[n1], cards[n2]);

        assertEquals("Obiekty nie zamieniły się poprawnie",temp1, cards[n2]);
        assertEquals("Obiekty nie zamieniły się poprawnie", temp2, cards[n1]);
    }

    public void testSortCards() throws Exception {
        Deck deck = new Deck(cardsSize);
        boolean sorted = true;
        Card previousOne = deck.showFirst();


        deck.sortCards();

        for(Card x: deck.getCards()){
            if(previousOne.compareTo(x) > 0){
                sorted = false;
                break;
            }

            previousOne = x;
        }

        assertTrue("Karty nie są posortowane", sorted);
    }

}