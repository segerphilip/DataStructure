/**
 * FILE NAME:Rectangle.java
 * WHO: Copyright 1999 by J. Barry DeRoos
 * Edited by Stella K.
 * WHEN: Edits in Feb 2008
 * WHAT: Class with Rectangle properties. Adds a length and a width property
 * Inherits from Shape class. Added javadoc
 * Implements the area() method
 */
public class Rectangle extends Shape {

    private double length; //length of the rectangle
    private double width;  //width of the rectangle

    /**
     * Constructor
     *
     * @param len length of rectangle
     * @param wid width of rectangle
     */
    public Rectangle(double len, double wid) {
        super("rectangle"); //call the constructor in the super class (Shape)
        this.length = len;
        this.width = wid;
    }

    /**
     * Area Implemented for rectangle
     *
     * @return area
     */
    public double area() {
        return this.length * this.width;
    }

    /**
     * perimeter() Implemented for rectangle
     *
     * @return perimeter
     */
    public double perimeter() {
        return 2 * (this.length + this.width);
    }

    public String toString() {
        String s = super.toString();
        s = s + " (length: " + length + " width: " + width + ")";
        return s;
    }

    public static void main(String[] args) {

    }
} //End Rectangle Class
