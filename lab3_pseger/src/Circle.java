/**
 * FILE NAME:Circle.java
 * WHO: Copyright by J. Barry DeRoos
 * Edited by Sohie
 * WHEN: Edits in Fall 2015
 * WHAT: Class with circle properties. Adds a radius property
 * Inherits from Shape class
 * Implements the area() method
 */
public class Circle extends Shape {

    private static final double PI = 3.14159265358979323;
    private double radius;

    /**
     * Constructor
     *
     * @param r radius of the circle
     */
    public Circle(double r) {
        super("circle"); //calls constructor in Shape class
        this.radius = r;
    }

    /**
     * Area method implemented for circle
     *
     * @return area
     */
    public double area() {
        return PI * this.radius * this.radius;
    }

    /**
     * perimeter() (known as circumference) Implemented for circle
     *
     * @return perimeter
     * h
     */
    public double perimeter() {
        return 2 * PI * this.radius;
    }

    public String toString() {
        String s = super.toString();
        s = s + " (radius: " + radius + ")";
        return s;
    }

    public static void main(String[] args) {
        Circle cr1 = new Circle(5.3);
        System.out.println(cr1);
    }

} //End Circle class
