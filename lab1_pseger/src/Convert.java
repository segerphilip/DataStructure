import java.util.Scanner;

/**
 * Created by philip on 1/29/16.
 */
public class Convert {
    public  static void dollarsToEuros(double amount) {
        amount = amount * 0.88;
        System.out.println(amount);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many dollars do you have?");
        double dollars = scan.nextDouble();
        dollarsToEuros(dollars);
    }
}
