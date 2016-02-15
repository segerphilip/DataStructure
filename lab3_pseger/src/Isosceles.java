/**
 * Created by philip on 2/12/16.
 */
public class Isosceles extends Triangle {
    private double base, length;

    public Isosceles(double base, double length) {
        super(base, length, length);
        this.base = base;
        this.length = length;
        name = "isosceles " + name;
    }

    public static void main(String[] args) {
        double base, length;
        if (args.length > 1) {
            base = Double.parseDouble(args[0]);
            length = Double.parseDouble(args[1]);
        } else {
            System.out.println("You must input a BASE and LENGTH " +
                    "values (where length is val of 2 sides).");
            return;
        }
        Isosceles is1 = new Isosceles(base, length);
        System.out.println(is1);
    }
}
