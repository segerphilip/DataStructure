/**
 * Created by philip on 2/18/16.
 */
public class Student {
    private String name;
    private int hours;
    private double quality;
    private double GPA;

    public Student(String name, int hours, double quality) {
        this.name = name;
        this.hours = hours;
        this.quality = quality;
        GPA = 0;
    }

    private void computeGPA() {
        GPA = quality / hours;
        if (GPA > 4.0) {
            System.out.println("That's not possible!");
        }
        else if ((GPA < 1.5 && hours < 30) || (GPA < 1.75 && hours < 1.75) || (GPA < 2.0 && hours >= 1.75)) {
            System.out.println("You're GPA is dangerously low!");
        }
    }

    public String toString() {
        return name + " has a GPA of " + GPA;
    }

    public static void main(String[] args) {
        Student s1 = new Student("Pip", 50, 230.1);
        Student s2 = new Student("Kelly", 84, 292.4);
        Student s3 = new Student("Jonathan", 75, 200.1);
        Student s4 = new Student("Bob", 10, 15);
        s1.computeGPA();
        System.out.println(s1);
        s2.computeGPA();
        System.out.println(s2);
        s3.computeGPA();
        System.out.println(s3);
        s4.computeGPA();
        System.out.println(s4);
    }
}

