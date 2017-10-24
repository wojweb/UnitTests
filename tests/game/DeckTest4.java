package game;

import org.junit.*;

import java.util.Random;

import static org.junit.Assert.*;


public class DeckTest4 {

    int cardsSize = 24;
    Deck deck;

    @Before
    public void setUp() throws Exception {
        deck = new Deck(cardsSize);

    }

    @Test
    public void testTakeCards() throws Exception {
        assertNotNull( "Talia nie zostałą wypełniona kartami" , deck.showFirst());

        Deck deck2 = new Deck(4);
        assertNull("Talia zostala wypelniona jakimis kartami", deck2.showFirst());
    }

    @Test(timeout = 100)
    public void testShuffleCards() throws Exception {
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

    @Test(expected = NullPointerException.class)
    public void testSwapCardsException() throws Exception {
        int cardsSize1 = 10;
        Deck deck1 = new Deck(cardsSize1);
        Card[] cards = deck1.getCards();
        Random random = new Random();

        //Numers to swap
        int n1 = random.nextInt(cardsSize1);
        int n2 = random.nextInt(cardsSize1);


        deck.swapCards(cards[n1], cards[n2]);
    }
    @Ignore("Poniewaz musialo byc jakies zignorowane")
    @Test
    public void testSortCards() throws Exception {
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

    @After
    public void tearDown() throws Exception {
        deck = null;
    }
}
//I have wroten some comments
//Lalalala