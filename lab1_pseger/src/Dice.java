/**
 * Created by philip on 1/29/16.
 */
import java.util.Random;
import java.util.Scanner;

public class Dice {
    public static String roll(int rolls) {
        Random rand = new Random();
        String output = "";
        for(int i = 0; i < rolls; i++) {
            int value = rand.nextInt(6);
            if (value == 0) {
                i--;
            }
            else {
                output = output + " " + value; //wrong method, fix this
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many rolls to perform?");
        int rolls = scan.nextInt();
        System.out.println("You rolled " + roll(rolls));
    }
}
