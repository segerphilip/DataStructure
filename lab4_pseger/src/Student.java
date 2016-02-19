/**
 * Created by eliza and philip on 2/18/16.
 */
public class Student implements Comparable<Student> {
    private String name;
    private int hours;
    private double quality;
    private double GPA;
    
    public Student(String name, int hours, double quality) {
        this.name = name;
        this.hours = hours;
        this.quality = quality;
        GPA = quality / hours;
    }
    
    public double getGPA() {
        return GPA;
    }
    
    public String getName() {
        return name;
    }
    
    public int getHours() {
        return hours;
    }
    
    public double getQuality() {
        return quality;
    }
    
    public int compareTo(Student student) {
        return this.name.compareTo(student.name);
    }
    
    public boolean isOnWarning() {
        if ((GPA < 1.5 && hours < 30) || (GPA < 1.75 && hours < 1.75) || (GPA < 2.0 && hours >= 1.75)) {
            return true;
        }
        return false;
    }
    
    public String toString() {
        return name + ": credit hours " + hours + ", quality points " + quality + 
            " and has a GPA of " + GPA + "\nIs this student on warning? " + isOnWarning();
    }
    
    public static void main(String[] args) {
        Student s1 = new Student("Pip", 50, 230.1);
        Student s2 = new Student("Kelly", 84, 292.4);
        Student s3 = new Student("Jonathan", 75, 200.1);
        Student s4 = new Student("Bob", 10, 15);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        
        System.out.println("Pip compared to Kelly..." + s1.compareTo(s2));
    }
}

