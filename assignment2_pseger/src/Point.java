import java.util.Scanner;

/**
 * Created by philip on 2/5/16.
 */
public class Point {
    private double x;
    private double y;
    private static final double TOLERANCE = .01;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double val) {
        x = val;
    }

    public double getY() {
        return y;
    }

    public void setY(double val) {
        y = val;
    }

    private double findDistance(Point p) {
        double distance = Math.sqrt(Math.pow(Math.abs(p.getX() - x), 2) + Math.pow(Math.abs(p.getY() - y), 2));
        return distance;
    }

    private static boolean areEquidistant(Point p1, Point p2) {
        if (p1.findDistance(p2) <= TOLERANCE) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "X: " + x + "\tY: " + y;
    }

    private static Point readPoint() {
        Scanner scan =  new Scanner(System.in);
        System.out.print("X:");
        double x1 = scan.nextDouble();
        System.out.print("Y:");
        double y1 = scan.nextDouble();
        Point pnts = new Point(x1, y1);
        return pnts;
    }

    public static void main(String[] args) {
        System.out.println("Point 1");
        Point pnt1 = readPoint();
        System.out.println("Point 2");
        Point pnt2 = readPoint();
        System.out.println("Point 3");
        Point pnt3 = readPoint();

        if (areEquidistant(pnt1, pnt2) || areEquidistant(pnt2, pnt3) || areEquidistant(pnt1, pnt3))
            System.out.println("Yes, there is equadistance");
        else
            System.out.println("Nope");
    }
}
