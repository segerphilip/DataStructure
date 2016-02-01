import java.util.Scanner;

/**
 * Created by philip and Dasol on 1/31/16.
 */
public class AreaTriangle {
//    takes the three sides (as doubles) and returns the area as a double
    public static double area(double first, double second, double third) {
        double s = (first + second + third) / 2;
        double area = Math.sqrt(s * (s - first) * (s - second) * (s - third));
        return area;
    }

//    takes the three sides (as doubles) and returns true for if two or three sides are equal, otherwise false
    public static boolean isosceles(double first, double second, double third) {
        if (first == second || first == third || second == third)
            return true;
        else
            return false;
    }

//    gets the side lengths (as doubles) from user, then runs area and isosceles
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter length of the first side of a triangle: ");
        double first = scan.nextDouble();
        System.out.print("Please enter length of the second side of a triangle: ");
        double second = scan.nextDouble();
        System.out.print("Please enter length of the third side of a triangle: ");
        double third = scan.nextDouble();
        if (isosceles(first, second, third) == true)
            System.out.println("The triangle is isosceles.");
        else
            System.out.println("The triangle is not isosceles.");
        System.out.println("The area of the triangle is " + area(first, second, third));
        scan.close();
    }
}
