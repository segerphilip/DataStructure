import javafoundations.*;

/**
 * Created by philip on 3/11/16.
 */
public class Polynomial {
    private ArrayQueue<Term> queue;

    /**
     * No args constructor to assign queue to an empty Term queue
     */
    public Polynomial() {
        queue = new ArrayQueue<Term>();
    }

    /**
     * Constructor that takes q and sets it to the global queue var
     * @param q
     */
    public Polynomial(ArrayQueue<Term> q) {
        this.queue = q;
    }

    /**
     * Returns the queue (used to help compare two queues)
     * @return
     */
    public ArrayQueue<Term> getQueue() {
        return queue;
    }

    /**
     * Adds a Term t to the queue in sorted order
     * @param t
     */
    public void addTerm(Term t) {
        ArrayQueue<Term> tempQ = new ArrayQueue<Term>();

//        while queue isn't empty, compare the elements and add to tempQ
        while (!queue.isEmpty()) {
            if (queue.first().compareTo(t) == 1) {
                tempQ.enqueue(queue.dequeue());
            }
//            condition where they have the same exponenet, need to add together
            else if (queue.first().compareTo(t) == 0) {
                int one = queue.first().getCoefficient();
                int two = t.getCoefficient();
                int xpon = queue.dequeue().getExponent();
//                enqueue the new term (addition of t and queue)
                tempQ.enqueue(new Term(one + two, xpon));
                t = null;
            }
            else {
                tempQ.enqueue(t);
                t = null;
                tempQ.enqueue(queue.dequeue());
            }
        }

//        remember to enqueue the last value
        if (queue.isEmpty() && t != null) {
            tempQ.enqueue(t);
        }

        queue = tempQ;
    }

    /**
     * Taken the queue we are working with, and input polynomial p, add the two together
     * and return the result.
     * @param p
     * @return
     */
    public Polynomial addPolynomial(Polynomial p) {
//        blank conditions if one of the queues is empty (saves time)
        if (p.getQueue().isEmpty()) {
            return new Polynomial(queue);
        } else if (queue.isEmpty()) {
            return p;
        }

//        create a temp array to hold queue.dequeue
        ArrayQueue<Term> tempQ = new ArrayQueue<Term>();

//        while both queues aren't empty, compare and add values to tempQ
        while (p.getQueue().size() != 0 && queue.size() != 0) {
            if (queue.first().compareTo(p.getQueue().first()) == 1) {
                tempQ.enqueue(queue.dequeue());
            } else if (queue.first().compareTo(p.getQueue().first()) == -1) {
                tempQ.enqueue(p.getQueue().dequeue());
            }
//            if the coefficients are same, add by creating a new term with same exponenet
            else {
                int one = queue.first().getCoefficient();
                int two = p.getQueue().dequeue().getCoefficient();
                int xpon = queue.dequeue().getExponent();
                Term resultT = new Term(one + two, xpon);
                tempQ.enqueue(resultT);
            }
        }

//        if either queue is empty, add leftovers from other queue to tempQ
        if (p.getQueue().isEmpty()) {
            while (!queue.isEmpty()) {
                tempQ.enqueue(queue.dequeue());
            }
        } else if (queue.isEmpty()) {
            while (!p.getQueue().isEmpty()) {
                tempQ.enqueue(p.getQueue().dequeue());
            }
        }

//        return a new polynomial object consisting of tempQ values
        return new Polynomial(tempQ);
    }

    /**
     * Prints out the polynomial, using the Term print method for formatting
     * @return
     */
    public String toString() {
        String result = "";
//        use temp queue so that we don't lose contents of queue after printing
        ArrayQueue<Term> tempQ = new ArrayQueue<Term>();

        while (!queue.isEmpty()) {
//            initial condition, so we don't get an extra + at the start
            if (result.length() == 0) {
                result += queue.first().toString();
                tempQ.enqueue(queue.dequeue());
            }
//            formatting for a nice + or - at the start, depending on values
            else if (queue.first().getCoefficient() < 0) {
                result += queue.first().toString();
                tempQ.enqueue(queue.dequeue());
            }
            else {
                result += "+" + queue.first().toString();
                tempQ.enqueue(queue.dequeue());
            }
        }

        queue = tempQ;
        return result;
    }

    public static void main(String[] args) {
//        testing found in PolynomialDriver.java
    }
}
