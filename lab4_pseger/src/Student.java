/**
 * Created by philip on 2/18/16.
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
  
  public int compareTo(Student student) {
    return this.name.compareTo(student.name);
  }
  
  private boolean isOnWarning() {
    if ((GPA < 1.5 && hours < 30) || (GPA < 1.75 && hours < 1.75) || (GPA < 2.0 && hours >= 1.75)) {
      return true;
    }
    else {
      return false;
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
    s1.isOnWarning();
    System.out.println(s1);
    s2.isOnWarning();
    System.out.println(s2);
    s3.isOnWarning();
    System.out.println(s3);
    s4.isOnWarning();
    System.out.println(s4);
    System.out.println("Is " + s4.name + " on warning? : " + s4.isOnWarning());
  }
}

