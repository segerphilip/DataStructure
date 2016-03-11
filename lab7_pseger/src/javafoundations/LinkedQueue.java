//********************************************************************
//  LinkedQueue.java       Java Foundations
//
//  Represents a linked implementation of a queue.
//********************************************************************

package javafoundations;

import javafoundations.exceptions.*;

public class LinkedQueue<T> implements Queue<T> {
    private int count;
    private LinearNode<T> front, rear;

    //-----------------------------------------------------------------
    //  Creates an empty queue.
    //-----------------------------------------------------------------
    public LinkedQueue() {
        count = 0;
        front = rear = null;
    }

    //-----------------------------------------------------------------
    //  Adds the specified element to the rear of this queue.
    //-----------------------------------------------------------------
    public void enqueue(T el) {
        //create a LinearNote out of the input element
        LinearNode<T> node = new LinearNode<T>(el);

        if (count == 0)
            front = node;
        else
            rear.setNext(node);

        rear = node;
        count++;
    }

    //-----------------------------------------------------------------
    //  The following methods are left as Programming Projects.
    //-----------------------------------------------------------------
    public T dequeue() throws EmptyCollectionException {

    }

    public T first() throws EmptyCollectionException {

    }


    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public String toString() {
        String result = "<top of stack>\n";

        for (int i = )
            result += array[index] + "\n";

        return result + "<bottom of stack>";
    }

    public static void main(String[] args) {

    }

}
