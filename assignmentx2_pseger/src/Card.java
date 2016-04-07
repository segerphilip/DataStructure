/**
 * Created by philip on 4/6/16.
 * I'm working under the assumption that Spades are the highest suit and Aces are the highest face value.
 * This program should work correctly.
 */
public class Card implements Comparable<Card> {
    private String value;
    private String suit;
//    final variables to search through easily and create cards
    private final String[] FACECARDS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private final String[] SUITCARDS = {"Clubs", "Diamonds", "Hearts", "Spades"};

    /**
     * Constructor to make a new object with value and suit as arguments
     */
    public Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    /**
     * Constructor that creates a new object with the card at a specific index
     */
    public Card(int order) {
        if (order <= 13) {
            this.suit = "Clubs";
        } else if (order > 13 && order <= 26) {
            this.suit = "Diamonds";
        } else if (order > 26 && order <= 39) {
            this.suit = "Hearts";
        } else if (order > 39 && order <= 52) {
            this.suit = "Spades";
        } else {
            System.out.println("Not a valid input");
            return;
        }

        this.value = FACECARDS[(order) % 13];
    }

    /**
     * Getters and setters below
     */
    public String getValue() {
        return value;
    }

    public void setValue(String val) {
        value = val;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String st) {
        suit = st;
    }

    /**
     * Compare to an inputted Card object. 0 for same, -1 for input being better, 1 for main object being better
     */
    public int compareTo(Card cr1) {
//        if suits don't match, figure out who is highest suit
        if (suit != cr1.getSuit()) {
            int suitIndex = 0, cr1Index = 0;
            for (int i = 0; i < SUITCARDS.length; i++) {
                if (suit == SUITCARDS[i]) {
                    suitIndex = i;
                }
                if (cr1.suit == SUITCARDS[i]) {
                    cr1Index = i;
                }
            }
//            way I organized the array means lower index is worse
            if (suitIndex > cr1Index)
                return 1;
            else if (suitIndex < cr1Index)
                return -1;
            else
                return 0;
        }
//        if suits do match, figure out which card is higher
        else {
            int suitIndex = 0, cr1Index = 0;
            for (int j = 0; j < FACECARDS.length; j++) {
                if (value == FACECARDS[j]) {
                    suitIndex = j;
                }
                if (cr1.value == FACECARDS[j]) {
                    cr1Index = j;
                }
            }

            if (suitIndex > cr1Index)
                return 1;
            else if (suitIndex < cr1Index)
                return -1;
            else
                return 0;
        }
    }

    /**
     * Prints a card nicely
     */
    public String toString() {
        return "The " + value + " of " + suit;
    }

    /**
     * Main testing code
     */
    public static void main(String[] args) {
        Card cr1 = new Card("3", "Clubs");
        Card cr2 = new Card("2", "Clubs");
        Card cr3 = new Card("5", "Spades");
        Card cr4 = new Card("5", "Spades");
        System.out.println(cr1);
        System.out.println(cr2);
        System.out.println(cr3);
        System.out.println(cr4);

        System.out.println(cr1.compareTo(cr2)); // should be 1
        System.out.println(cr2.compareTo(cr3)); // should be -1
        System.out.println(cr3.compareTo(cr4)); // shouldn't be possible, but if so should be 0

        Card co1 = new Card(15);
        System.out.println(co1);
    }
}
