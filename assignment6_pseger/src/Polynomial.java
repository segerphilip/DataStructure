import javafoundations.*;

/**
 * Created by philip on 3/11/16.
 */
public class Polynomial {
    private ArrayQueue<Term> queue;

    public Polynomial() {
        queue = new ArrayQueue<Term>();
    }

    public Polynomial(ArrayQueue<Term> q) {
        this.queue = q;
    }

    public ArrayQueue<Term> getQueue() {
        return queue;
    }

    public void addTerm(Term t) {
        ArrayQueue<Term> tempQ = new ArrayQueue<Term>();

        while (!queue.isEmpty()) {
            if (queue.first().compareTo(t) == 1) {
                tempQ.enqueue(queue.dequeue());
            }
            else {
                tempQ.enqueue(t);
                t = null;
                tempQ.enqueue(queue.dequeue());
            }
        }

        if (queue.isEmpty() && t != null) {
            tempQ.enqueue(t);
        }

        queue = tempQ;
    }

    public Polynomial addPolynomial(Polynomial p) {
//        blank condidtions
//        if (p.getQueue().isEmpty()) {
//            return new Polynomial(queue);
//        }
//        else if (queue.isEmpty()) {
//            System.out.println("TEST");
//            return p;
//        }

        ArrayQueue<Term> tempQ = new ArrayQueue<Term>();

        while (!p.getQueue().isEmpty() || !queue.isEmpty()) {
            if (queue.first().compareTo(p.getQueue().first()) == 1) {
                tempQ.enqueue(queue.dequeue());
            }
            else if (queue.first().compareTo(p.getQueue().first()) == -1) {
                tempQ.enqueue(p.getQueue().dequeue());
            }
            else {
                Term resultT = new Term(queue.dequeue().getCoefficient()
                        + p.getQueue().dequeue().getCoefficient(), queue.dequeue().getExponent());
                tempQ.enqueue(resultT);
            }
        }

        if (p.getQueue().isEmpty()) {
            while (!queue.isEmpty()) {
                tempQ.enqueue(queue.dequeue());
            }
        }
        else if (queue.isEmpty()) {
            while (!p.getQueue().isEmpty()) {
                tempQ.enqueue(p.getQueue().dequeue());
            }
        }

        return new Polynomial(tempQ);
    }

    public String toString() {
        String result = "";
        while (!queue.isEmpty()) {
            if (queue.first().getCoefficient() < 0) {
                result += queue.dequeue().toString();
            }
            else {
                result += "+" + queue.dequeue().toString();
            }
        }
        if (result.charAt(0) == '-') {
            return result;
        }
        else {
            result = result.substring(1, result.length());
        }
        return result;
    }

    public static void main(String[] args) {
        Polynomial pl1 = new Polynomial();
        Term t1 = new Term(5, 2);
        Term t2 = new Term(-7, 0);
        Term t3 = new Term(3, 1);
        pl1.addTerm(t1);
        pl1.addTerm(t2);
        pl1.addTerm(t3);
        System.out.println(pl1);
        Polynomial pl2 = new Polynomial();
        pl2.addTerm(t1);
        pl2.addTerm(t2);
        pl2.addTerm(t3);
        System.out.println(pl1.addPolynomial(pl2));
    }
}
