/**
 * Created by philip on 1/29/16.
 */
import java.util.Scanner;

public class Intro {
    public static void main(String[] args) {
//        declaration statement "Scanner scan", assign new Scanner object to scan, Scanner() call to the constructor
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your name? ");
        String name = scan.nextLine();
        System.out.println("What is your favorite color? ");
        String color = scan.nextLine();
        System.out.println("What is the land speed of an unladen swallow? ");
        int speed = scan.nextInt();
        System.out.println(name + ", " + color + ", " + speed);
    }
}
