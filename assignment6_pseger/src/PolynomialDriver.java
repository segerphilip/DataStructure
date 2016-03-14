/**
 * Created by philip on 3/11/16.
 */
public class PolynomialDriver {
    public static void main(String[] args) {
        Polynomial pl1 = new Polynomial();
        Term t1 = new Term(4, 3);
        Term t2 = new Term(5, 0);
        Term t3 = new Term(2, 2);
        pl1.addTerm(t1);
        pl1.addTerm(t2);
        pl1.addTerm(t3);
        System.out.println(pl1);

        Polynomial pl2 = new Polynomial();
        Term t4 = new Term(-2, 3);
        Term t5 = new Term(3, 1);
        Term t6 = new Term(1, 2);
        pl2.addTerm(t4);
        pl2.addTerm(t5);
        pl2.addTerm(t6);

        System.out.println(pl1.addPolynomial(pl2));
    }
}
