/**
 * Created by philip on 2/5/16.
 */
public class Point {
    private double x;
    private double y;

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

//    public void findDistance(Point ) {
//
//    }

    public String toString() {
        return "";
    }

    public static void main(String[] args) {
        Point pnt = new Point(15.5, 13.2);
    }
}
