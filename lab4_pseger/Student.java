/**
 * FILE NAME: Student.java
 * WHO: Stella
 * WHEN: S11
 * WHAT: Defines a class of type Student. Provides a main() for testing purposes.
 */

public class Student implements Comparable<Student>{
  int creditHrs;         // number of semester hours earned
  double qualityPts;     // number of quality points earned
  double gpa;            // grade point (quality point) average(gpa)
  
  String name;  //To hold the name of the student
  
  public Student(String name, int hours, double points) {
    creditHrs = hours;
    qualityPts = points;
    this.name = name;
    gpa = qualityPts / creditHrs;
  }
  
  public String toString() {
    return name + ": credit hours " + creditHrs + ", quality points " + qualityPts + " and gpa " + gpa;
  }
  
  public boolean isOnWarning() {
    if(creditHrs < 30 && gpa < 1.5)
      return true;
    if(creditHrs < 60 && gpa < 1.75)
      return true;
    if(gpa < 2)
      return true;
    //if none of the above, return false
    return false;
  }
  
  public int compareTo(Student other) {
    return this.name.compareTo(other.name);
  }
  
  public static void main(String[] args) {
    Student s1 = new Student("takis", 12, 12);
    Student s2 = new Student("artemis", 70, 200);
    System.out.println(s1);
    System.out.println("takis in probation (true): " + s1.isOnWarning());
    
    System.out.println(s2);
    System.out.println("artemis in probation (false): " + s2.isOnWarning());
    
    System.out.println("\ncomapre takis to artemis (positive): " + s1.compareTo(s2));
    System.out.println("comapre artemis to takis (negative): " + s2.compareTo(s1));
    System.out.println("comapre takis to takis (zero): " + s1.compareTo(s1));
  }
  
}