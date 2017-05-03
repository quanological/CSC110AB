/**
 * Programmer: Quan Truong
 * Class: CSC110AB MTWTh 12:00 - 12:50 PM
 * Professor: Dr. Zerangue
 * Assignment: Card.java
 * <p>
 * Card class allows the user to explicitly creates a specific card of their choosing, or
 * to generate a random card, and also allows you to compare two card's values.
 */

import java.util.Random;

public class Card {

    // Suit constants
    //You can make constants public, since no one can maliciously edit it
    public final static int HEARTS = 0, DIAMONDS = 1, CLUBS = 2, SPADES = 3;
    // Face constants
    public static final int ACE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;
    public static final int JACK = 11, QUEEN = 12, KING = 13;

    public static final int[] SUITS = {HEARTS, DIAMONDS, CLUBS, SPADES};

    public static final int[] FACES = {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};

    //FIELDS
    private static int face;
    private static int suit;

    public static void main(String[] args) throws IllegalArgumentException {

    }

    /**
     * Default constructor. Creates a random card of random suit and face
     */
    public Card() {
        Random rand = new Random();

        //Generate a random value between one and ten and assign it to face
        int lowFace = 1;
        int highFace = 11;
        int randomValueBetweenOneAndTen = rand.nextInt(highFace - lowFace) + lowFace;
        face = randomValueBetweenOneAndTen;

        //Generate a random value between 0 and 4 and assign it to suit
        int lowSuit = 0;
        int highSuit = 4;
        int randomValueBetweenZeroAndThree = rand.nextInt(highSuit - lowSuit) + lowSuit;
        suit = randomValueBetweenZeroAndThree;
    }

    /**
     * Construct a specific card in the deck
     *
     * @param suit Integer Suit of the card to be created
     * @param face Integer Face of the card to be created
     */
    public Card(int suit, int face) {

        setCard(suit, face);
    }

    /**
     * Sets the value of the card
     *
     * @param newSuit Integer Suit of the card
     * @param newFace Integer Face of the card
     */
    public void setCard(int newSuit, int newFace) {

        if (newSuit < 0 || newSuit > 3) {
            throw new IllegalArgumentException();
        }

        if (newFace < 1 || newFace > 13) {
            throw new IllegalArgumentException();
        }

        this.suit = newSuit;
        this.face = newFace;
    }


    /**
     * Compare the face values of two cards
     *
     * @param other Card Face of the card whose face will be compared
     * @return Integer Returns -1 if the other card's value is larged, 0 if other card's value
     * is equal and 1 if other card's value is smaller
     */
    public int compareTo(Card other) {
        int comparison = 0;
        if (this.face < other.face) {
            comparison = -1;
        } else if (this.face == other.face) {
            comparison = 0;
        } else if (this.face > other.face) {
            comparison = 1;
        }
        return comparison;
    }

    /**
     * Returns the face value of a given card
     *
     * @return Integer Face integer value of a card
     */
    public int getFace() {
        return face;
    }

    /**
     * Returns the suit value of a given card
     *
     * @return Integer Suit integer value of a card
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Returns the name of the suit as a string
     *
     * @return String Name of the suit of the card
     */
    public static String getSuitString() {
        // Return a String representing the card's suit.
        // (If the card's suit is invalid, "??" is returned.)
        switch (suit) {
            case SPADES:
                return "Spades";
            case HEARTS:
                return "Hearts";
            case DIAMONDS:
                return "Diamonds";
            case CLUBS:
                return "Clubs";
            default:
                return "??";
        }
    }

    /**
     * Returns the name of the face as a string
     *
     * @return String Name of the face of the card
     */
    public static String getFaceString() {

        switch (face) {

            case TWO:
                return "2";
            case THREE:
                return "3";
            case FOUR:
                return "4";
            case FIVE:
                return "5";
            case SIX:
                return "6";
            case SEVEN:
                return "7";
            case EIGHT:
                return "8";
            case NINE:
                return "9";
            case TEN:
                return "10";
            case ACE:
                return "Ace";
            case JACK:
                return "Jack";
            case QUEEN:
                return "Queen";
            case KING:
                return "King";
            default:
                return "??";
        }
    }

    /**
     * Returns a nicely formatted string that gives information about the card
     *
     * @return String Face and suit of the card as a string
     */
    public String toString() {
        // Return the string of the card, for instance "10 of Hearts"

        return getFaceString() + " of " + getSuitString();
    }
}

