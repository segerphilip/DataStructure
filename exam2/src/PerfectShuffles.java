/**
 * Created by philip on 4/6/16.
 * findInDeck plays poorly with args, however this program should otherwise work as expected.
 */
public class PerfectShuffles {
    public static void main(String[] args) {
        if (args.length < 2) {
//            count and report the number of perfect shuffles needed to restore a deck to original
            Deck dk1 = new Deck();

            int count = 1; // b/c we do an initial shuffle
//            initial shuffle to start, otherwise count would be 0
            dk1.perfectShuffle();

            while (!dk1.inOrder()) {
                dk1.perfectShuffle();
                count++;
            }

            System.out.println("It takes " + count + " perfect shuffles to return to original.");
        } else {
            /**
             * NOTE:
             * Ran out of time to completely test this bit below, but it does not work properly with keyboard args
             * and I am not sure why. It is probably in my findInDeck method, though I've rewritten it twice and still
             * can't figure out why it does not return the expected values. It works fine in testing with the main
             * method in Deck, but not in this method.
             */


//            trace that card and report its location after each shuffle
            Deck dk1 = new Deck();
            Card card = new Card(args[0], args[1]);

//            initial shuffle
            int count = 1;
            dk1.perfectShuffle();
            System.out.println("Your card is at position " + dk1.findInDeck(card));

            while (!dk1.inOrder()) {
                dk1.perfectShuffle();
                count++;
                System.out.println("Your card is at position " + dk1.findInDeck(card));
            }
        }
    }
}
