import java.util.Scanner;

/**
 * Created by philip on 2/9/16.
 */
public class Square1 {
    private double side;

    public Square1(double side) {
        this.side = side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    private double getArea(double side) {
        return (Math.pow(side, 2));
    }

    private double getPerimeter(double side) {
        return (side * 4);
    }

    public String toString() {
        return "Square with side length of " + side + ", area of " + getArea(side) +
                ", and perimeter of " + getPerimeter(side);
    }

    public static void main(String[] args) {
        double sqrSide;
//        either use input args
        if (args.length > 0) {
            sqrSide = Double.parseDouble(args[0]);
        }
//        or ask for input
        else {
            Scanner scan = new Scanner(System.in);
            System.out.println("How long is a side?");
            sqrSide = scan.nextDouble();
        }

        Square1 sqr = new Square1(sqrSide);
        System.out.println(sqr);
    }
}
