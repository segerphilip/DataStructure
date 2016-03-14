import java.util.Comparator;

/**
 * Created by philip and jason on 3/11/16.
 */
public class Term implements Comparable<Term> {
    private int coefficient;
    private int exponent;

    public Term(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int newCoeff) {
        coefficient = newCoeff;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int newExpo) {
        exponent = newExpo;
    }

    public int compareTo(Term t1) {
        if (exponent > t1.getExponent()) {
            return 1;
        }
        else if (exponent == t1.getExponent()) {
            return 0;
        }
        else {
            return -1;
        }
    }

    public String toString() {
        String result = "";
        if (exponent != 0 && coefficient != 0) {
            result += coefficient + "x^" + exponent;
        }
        else if (exponent == 0 && coefficient != 0) {
            result += coefficient;
        }
        return result;
    }

    public static void main(String[] args) {
        Term t1 = new Term(5, 2);
        System.out.println(t1);
        Term t2 = new Term(3, 0);
        System.out.println(t2);
        Term t3 = new Term(0, 10);
        System.out.println(t3);
        System.out.println(t1.compareTo(t2));
    }
}
