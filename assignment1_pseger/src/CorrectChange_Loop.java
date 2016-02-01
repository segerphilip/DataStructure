import java.util.Scanner;

/**
 * Created by philip on 1/31/16.
 */
public class CorrectChange_Loop {
    //    convertToCents takes double amount, converts to int without decimal
    public static int convertToCents(double total) {
        total = total * 100;
        int cents = (int) total;
        return cents;
    }

    //    makeChange... prints the amount, remainder, and denomination of the inputs
    public static int makeChangeWithOneDenomination(int total, String denominationName, int denomination) {
        int new_total = 0;
        while (total >= denomination) {
            new_total++;
            total -= denomination;
        }
        System.out.println(new_total + " " + denominationName);
        return (total);
    }

    //    main takes user input, then calls makeChange with different total and denomination values
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How much money do you want to make change for?");
        double dollars = scan.nextDouble();
        int total = convertToCents(dollars);

        total = makeChangeWithOneDenomination(total, " $100 bills", 10000);
        total = makeChangeWithOneDenomination(total, " $50 bills", 5000);
        total = makeChangeWithOneDenomination(total, " $20 bills", 2000);
        total = makeChangeWithOneDenomination(total, " $10 bills", 1000);
        total = makeChangeWithOneDenomination(total, " $5 bills", 500);
        total = makeChangeWithOneDenomination(total, " $1 bills", 100);
        total = makeChangeWithOneDenomination(total, " quarters", 25);
        total = makeChangeWithOneDenomination(total, " dimes", 10);
        total = makeChangeWithOneDenomination(total, " nickels", 5);
        total = makeChangeWithOneDenomination(total, " pennies", 1);

        scan.close();
    }
}
