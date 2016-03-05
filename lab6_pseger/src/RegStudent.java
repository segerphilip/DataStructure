/**
 * FILE NAME: RegStudent.java
 * WHO: Stella
 * WHEN: S16
 * WHAT: Defines a class of type Student. Provides a main() for testing purposes.
 */

public class RegStudent extends Student {
    private int creditHrs;         // number of semester hours earned
    private double qualityPts;     // number of quality points earned
    private double gpa;            // grade point (quality point) average(gpa)


    public RegStudent(String name, String userName, int year, int hours, double points) {
        super(name, userName, year);
        creditHrs = hours;
        qualityPts = points;
        gpa = qualityPts / creditHrs;
    }

    public String toString() {
        return super.toString() + ", credit hours: " + creditHrs + ", quality points " + qualityPts + ", gpa " + gpa;
    }

    public boolean isOnWarning() {
        if (creditHrs < 30 && gpa < 1.5)
            return true;
        if (creditHrs < 60 && gpa < 1.75)
            return true;
        if (gpa < 2)
            return true;
        //if none of the above, return false
        return false;
    }

    public static void main(String[] args) {
        RegStudent s1 = new RegStudent("takis M", "pmetaxas", 2018, 12, 12);
        RegStudent s2 = new RegStudent("artemis M", "amk", 2019, 70, 200);

        System.out.println(s1);
        System.out.println("takis in probation (true): " + s1.isOnWarning());

        System.out.println(s2);
        System.out.println("artemis in probation (false): " + s2.isOnWarning());
    }

}