import javafoundations.*;

/**
 * Created by philip on 4/6/16.
 * Besides the findInDeck function, this program should work correctly (and even still, findInDeck works for the no-args case)
 */
public class Deck {
    private LinkedQueue<Card> queue;
    //    for creating the card objects, use vals below in a loop
    private final String[] FACECARDS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private final String[] SUITCARDS = {"Clubs", "Diamonds", "Hearts", "Spades"};

    /**
     * No args constructor to make a full deck of cards
     */
    public Deck() {
//        create ordered deck of 52 cards
        queue = new LinkedQueue<Card>();
        for (int i = 0; i < SUITCARDS.length; i++) {
            for (int j = 0; j < FACECARDS.length; j++) {
                queue.enqueue(new Card(FACECARDS[j], SUITCARDS[i]));
            }
        }
    }

    /**
     * Constructor that makes up to N sorted deck of cards
     */
    public Deck(int N) {
//        create empty deck
        queue = new LinkedQueue<Card>();
        if (N != 0) {
//            create sorted to N deck
            for (int i = 0; i < N; i++) {
                queue.enqueue(new Card(i));
            }
        }
    }

    /**
     * Clones a LinkedQueue<Card> and returns it for easy manipulation
     * Quick note, need to run through the queues twice to return them back to proper order
     */
    public LinkedQueue<Card> clone() {
        LinkedQueue<Card> temp = new LinkedQueue<Card>();
        LinkedQueue<Card> cloned = new LinkedQueue<Card>();

        while (!queue.isEmpty()) {
            temp.enqueue(queue.dequeue());
        }
//        now have all values of queue in temp, but in the wrong order
        while (!temp.isEmpty()) {
            cloned.enqueue(temp.first());
            queue.enqueue(temp.dequeue());
        }

        return cloned;
    }

    /**
     * Private helped function that clones the last half of the queue, for use in shuffle
     */
    private LinkedQueue<Card> cloneLastHalf() {
        LinkedQueue<Card> temp = clone();
        int size = temp.size() / 2;
        while (temp.size() != size) {
            temp.dequeue();
        }
        return temp;
    }

    /**
     * Private helped function that clones the first half of the queue, for use in shuffle
     */
    private LinkedQueue<Card> cloneFirstHalf() {
        LinkedQueue<Card> temp = clone();
        LinkedQueue<Card> half = new LinkedQueue<Card>();
        int size = temp.size() / 2;
        while (temp.size() != size) {
            half.enqueue(temp.dequeue());
        }
        return half;
    }

    /**
     * Mixes the first half and second half queues alternating to form a new deck, which is then saved in queue
     */
    public void perfectShuffle() {
        LinkedQueue<Card> firstHalf = cloneFirstHalf();
        LinkedQueue<Card> lastHalf = cloneLastHalf();
        LinkedQueue<Card> temp = new LinkedQueue<Card>();

//        testing code, works
//        System.out.println(firstHalf);
//        System.out.println("-----------");
//        System.out.println(lastHalf);

        while (!lastHalf.isEmpty()) {
            temp.enqueue(firstHalf.dequeue());
            temp.enqueue(lastHalf.dequeue());
        }

        queue = temp;
    }

    /**
     * Checks the whole deck to verify it is correctly sorted and in order
     */
    public boolean inOrder() {
        LinkedQueue<Card> temp = clone();

        for (int i = 0; i < SUITCARDS.length; i++) {
            for (int j = 0; j < FACECARDS.length; j++) {
                Card check = new Card(FACECARDS[j], SUITCARDS[i]);
                if (temp.dequeue().compareTo(check) != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Looks through the deck and returns the index of the card that is inputted
     * Should work, but this might be where my bug is
     */
    public int findInDeck(Card cr1) {
        LinkedQueue<Card> temp = clone();
//        indexing at 1 because of the real deck of cards
        int count = 1;

        while (!temp.isEmpty()) {
            if (cr1.compareTo(temp.first()) == 0) {
                return count;
            } else {
                temp.dequeue();
                count++;
            }
        }

//        return -1 if can't find the card in the deck
        return -1;
    }

    /**
     * Return a printed output of our Deck
     */
    public String toString() {
        String res = "";
        res += "There are " + queue.size() + " cards in the deck. The order is as follows:\n";
        res += queue;
        return res;
    }

    /**
     * Main testing method
     */
    public static void main(String[] args) {
        Deck dk1 = new Deck();
        dk1.clone();
//        System.out.println(dk1);
//        System.out.println(dk1.findInDeck(new Card("7", "Diamonds")));
//        System.out.println(dk1.inOrder());
        dk1.perfectShuffle();
        System.out.println(dk1.findInDeck(new Card("5", "Clubs")));

        Deck do1 = new Deck(5);
        System.out.println(do1);
    }
}
