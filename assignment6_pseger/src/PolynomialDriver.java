import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by philip on 3/11/16.
 */
public class PolynomialDriver {
    public static void someTest() {
        //        create a new polynomial
        Polynomial pl1 = new Polynomial();
//        create the terms to add to the polynomial
        Term t1 = new Term(4, 3);
        Term t2 = new Term(5, 0);
        Term t3 = new Term(2, 2);
        Term t4 = new Term(6, 0);
//        add each term
        pl1.addTerm(t1);
        pl1.addTerm(t2);
        pl1.addTerm(t3);
        pl1.addTerm(t4);
//        print out polynomial
        System.out.println(pl1);

//        similar to above
        Polynomial pl2 = new Polynomial();
        Term t5 = new Term(-2, 3);
        Term t6 = new Term(3, 1);
        Term t7 = new Term(1, 2);
        pl2.addTerm(t4);
        pl2.addTerm(t5);
        pl2.addTerm(t6);
//        print out polynomial
        System.out.println(pl2);

//        adds the two polynomials together
        System.out.println(pl1.addPolynomial(pl2));
    }

    public static String getInput() {
        Scanner scan = new Scanner(System.in).useDelimiter("\\s*x\\^\\+\\s*");;
        System.out.println("Please input a polynomial\n(example: 2x^2 + 3x + 1)");
        String polynomial = scan.nextLine();
        polynomial = polynomial.replaceAll("\\s+","");
        return polynomial;
    }

    public static Term[] filterInput(String input) {
        int coeff = 0,
            expon = 0;

//        I am not making expanding code for this, mainly because
//        it has been done before and this is for testing
        Term[] terms = new Term[20];
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
//            don't want to have to keep writing below line because I'm lazy
            char at = input.charAt(i);
//            check inputs and build coeff and expon from there
            if (!(at == 'x' || at == '^' || at == '+' || at == ' ')) {
                try {
                    if (coeff == 0) {
                        coeff = at;
                    }
                    else {
                        expon = at;
                    }
                }
                catch (InputMismatchException exception) {
                    System.out.println ("That is not a supported character");
                }
            }

            if (coeff != 0) {
                terms[count] = new Term(coeff, expon);
                count++;
            }
            System.out.println(coeff + " " + expon);
        }

        return terms;
    }

    public static void runPolynomial(Term[] terms) {
        Polynomial pl1 = new Polynomial();

        for (int i = 0; i < terms.length; i++) {
            try {
                pl1.addTerm(terms[i]);
            }
            catch (NullPointerException exception) {
                System.out.println("invalid: " + exception);
            }
        }
        System.out.println(pl1);
    }

    public static void main(String[] args) {
//        testing
        someTest();
//        input
//        String input = getInput();
//        Term[] terms = filterInput(input);
//        runPolynomial(terms);
    }
}
