/**
 * Programmer: Quan Truong
 * Class: CSC110AB
 * Professor: Dr. Zerangue
 * Due Date: May 3, 2017
 * <p>
 * Performs actipns on a deck of cards. Actions that are able to be performed are: shuffling the deck,
 * dealing a card, and returning the amount of cards that have been used.
 */
public class Deck {


    //Array of 52 cards
    private static Card[] deck;

    /**
     * Keeps track of the number of cards that have been dealt from
     * the deck so far.
     */
    private int totalCardsUsed;


    /**
     * Creates a deck of 52 playing cards.
     */
    public Deck() {
        //Construct deck object with 52 empty card objects
        deck = new Card[52];

        int amtOfCards = 0;
        for (int suit = 0; suit <= Card.SPADES; suit++) {
            for (int face = Card.ACE; face <= Card.KING; face++) {
                deck[amtOfCards] = new Card(suit, face);
                amtOfCards++;
            }
        }
        totalCardsUsed = 0;
    }

    /**
     * Shuffles the deck of cards.
     */
    public void shuffle() {

        for (int i = deck.length - 1; i > 0; i--) {
            int random = (int) (Math.random() * (i + 1));
            Card temp = deck[i];
            deck[i] = deck[random];
            deck[random] = temp;
        }

        totalCardsUsed = 0;
    }

    /**
     * Deals the amount of cards left in the deck
     *
     * @return
     */
    public int cardsLeft() {
        return deck.length - totalCardsUsed;
    }

    /**
     * Deals a card from the deck
     *
     * @return The amount of cards left in the deck.
     */
    public Card dealCard() {
        if (totalCardsUsed == deck.length)
            System.out.println("No cards are left in the deck");
        totalCardsUsed++;
        return deck[totalCardsUsed - 1];
    }

} 
