/**
 * Created by philip on 1/29/16.
 */
import java.util.Scanner;

public class Height {
    public static void Height(int inches) {
        int ft = inches / 12;
        int leftover = inches % 12;
        System.out.println(ft + " feet, " + leftover + " inches");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your height in inches?");
        Height(scan.nextInt());
    }
}
