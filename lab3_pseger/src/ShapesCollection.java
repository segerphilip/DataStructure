import java.util.*;  // for Scanner class

/**
 * FILE NAME:ShapesCollection.java
 * WHO:
 * WHEN:
 * WHAT: Uses an array to maintain a collection of Shapes
 * (Circles, Triangles, or Rectangles)
 */

public class ShapesCollection {


    //instance variables
    private int maxNumShapes = 100; //the max number of the shape our program can process.
    private Shape[] myShapesArray;
    private int counter;  //counts the current number of shapes in the collection (array)

    public ShapesCollection() {
        this.myShapesArray = new Shape[maxNumShapes];
        this.counter = 0;
    }


    public void add(Shape s) {
        myShapesArray[counter] = s;
        counter++;
    }


    public String toString() {
        String start = "This collection contains " + counter;

        if (counter > 0) {
            start += " shapes:\n";
            for (int i = 0; i < counter; i++) {
                start += myShapesArray[i] + "\n";
            }
        }
        return start;
    }

//      returns the index of the Shape with the largest area in the collection of shapes
//      (do not use the sort() method here)
    public int findLargest() {
        int largest = 0;
        for (int i = 1; i < counter; i++) {
            if (myShapesArray[largest].compareTo(myShapesArray[i]) < 0) {
                largest = i;
            }
        }
        return largest;
    }

//    removes the largest Shape in the collection and returns the shape
//    that was removed (do not use the sort() method here)
//    public Shape removeLargest() {
//        int largestIndex = myShapesArray.findLargest();
//        Shape[] tempArray = new Shape[myShapesArray.length - 1];
//
//        for (int i = 0; i < counter; i++) {
//        }
//    }

    /**
     * Sorts the collection of Shapes
     */
    public void sort() {
        // sorts the  Shape[] in increasing order,
        // according to the area of each Shape obj
        // uses the selection sort algorithm

        Shape maxShape;  // Shape with maximum area
        int maxIndex;   // index of maximum area Shape
        int i, j;
        for (j = counter - 1; j > 0; j--) {
            maxIndex = 0;
            maxShape = myShapesArray[0];
            for (i = 1; i <= j; i++) {
                if (myShapesArray[i].compareTo(maxShape) > 0) {
                    maxShape = myShapesArray[i];
                    maxIndex = i;
                }
            }
            swap(myShapesArray, maxIndex, j);
        }
    }

    /**
     * exchanges the contents of input array at positions i and j
     */
    private void swap(Shape[] a, int i, int j) {
        // exchanges the contents of locations i and j in input array
        Shape temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    /**
     * static main method
     * Method to read in data, from the standard input.
     * Then, sorts and displays the inputted Shape objects according to their area
     *
     * @param args an array of strings
     */
    public static void main(String[] args) {

        ShapesCollection tester = new ShapesCollection();
        //populate the collection with a few shapes
        Rectangle r1 = new Rectangle(2, 6);
        tester.add(r1);

        Circle c1 = new Circle(4.5);
        tester.add(c1);

        Isosceles i1 = new Isosceles(5.4, 3.2);
        tester.add(i1);

        Circle c2 = new Circle(5.0);
        tester.add(c2);

        System.out.println(tester);
        System.out.println(tester.findLargest());

        System.out.println("Unsorted\n===========\n" + tester);
        tester.sort();
        System.out.println("Sorted\n===========\n" + tester);

        // keep on creating and adding Shapes to your collection...
    }
}