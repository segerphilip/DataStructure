/**
 * FILE NAME:Triangle.java
 * WHO: Copyright 1999 by J. Barry DeRoos
 * Edited by Stella K.
 * WHEN: Edits in Feb 2008
 * WHAT: Class with Triangle properties.
 * Inherits from Shape class
 * Implements the area() method
 */
public class Triangle extends Shape {

    private double a;
    private double b;
    private double c;

    /**
     * Constructor
     *
     * @param side1 The length of one side of the triangle
     * @param side2 The length of the second side of the triangle
     * @param side3 The length of the third side of the triangle
     */
    public Triangle(double side1, double side2, double side3) {
        super("triangle"); //call the constructor in the super class (Shape)
        this.a = side1;
        this.b = side2;
        this.c = side3;
    }

    /**
     * area() Implemented for triangle, according to Heron's formula:
     * S = 1/4 * sqrt( (a^2 + b^2 + c^2)^2  - 2*(a^4 + b^4 + c^4))
     *
     * @return area
     */
    public double area() {
        double temp1 = a * a + b * b + c * c;
        temp1 = temp1 * temp1;

        double temp2 = Math.pow(a, 4) + Math.pow(b, 4) + Math.pow(c, 4);
        return 1.0 / 4 * Math.sqrt(temp1 - 2 * temp2);
    }

    /**
     * perimeter() Implemented for triangle
     *
     * @return perimeter
     */
    public double perimeter() {
        return this.a + this.b + this.c;
    }

    public String toString() {
        String s = super.toString();
        s = s + " (sides: " + a + ", " + b + ", " + c + ")";
        return s;
    }

    public static void main(String[] args) {
        Triangle tr1 = new Triangle(1, 2, 3);
        System.out.println(tr1);
    }
} //End Rectangle Class
