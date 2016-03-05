/**
 * FILE NAME: RegStudent.java
 * WHO: Stella
 * WHEN: S16
 * WHAT: Defines a class of type Student. Provides a main() for testing purposes.
 */

public class Student implements Comparable<Student> {

    protected String name;  //To hold the name  (first and last name) of the student
    protected String address; // the student's home address
    protected String userName;
    protected int year; //graduation year


    public Student(String name, String usrName, int y) {
        this.name = name;
        this.userName = usrName;
        this.year = y;
        this.address = "unavailable";
    }

    public Student(String name, String addr, String usrName, int y) {
        this(name, usrName, y); //notice the use of the construtor above!
        this.address = addr;
    }

    public void setAddress(String addr) {
        this.address = addr;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getAddress() {
        return address;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        String j = (address.equals("unavailable")) ? "" : (" address: " + address);
        return name + " (" + userName + ")" + j + ", year of " + year;
    }


    /**
     * two student objects are considered equal if they have the same userName
     */
    public boolean equals(Student other) {
        return this.userName.equals(other.userName);
    }

    /**
     * compares two Student objects based on their name (last + first name).
     * To be used for sorting student objects alphabetically
     */
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    public static void main(String[] args) {
        Student s1 = new Student("takis M", "8 Pine Ridge Rd Wellesley MA", "pmetaxas", 2018);
        Student s2 = new Student("artemis M", "8 Pine Ridge Rd Wellesley MA", "amk", 2019);
        Student s3 = new Student("Stella K ", "8 Pine Ridge Rd Wellesley MA", "skakavou", 2016);
        Student s4 = new Student("Danae MK", "dmk", 2020);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

        System.out.println("\ntakis equals to artemis (false): " + s1.equals(s2));
        System.out.println("artemis equals to takis (false): " + s2.equals(s1));
        System.out.println("takis equals to takis (true): " + s1.equals(s1));
    }

}