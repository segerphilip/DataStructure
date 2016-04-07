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
    //  Removes an element from the front of the queue.
    //-----------------------------------------------------------------
    public T dequeue() throws EmptyCollectionException {
        if (count == 0) {
            throw new EmptyCollectionException("No elements in the queue");
        }
        T temp = front.getElement();
        front = front.getNext();
        count--;
        return temp;
    }

    //-----------------------------------------------------------------
    //  Returns the first element in the queue.
    //-----------------------------------------------------------------
    public T first() throws EmptyCollectionException {
        if (count == 0) {
            throw new EmptyCollectionException("No elements in the queue");
        }
        return front.getElement();
    }

    //-----------------------------------------------------------------
    //  Returns true if the queue is empty.
    //-----------------------------------------------------------------
    public boolean isEmpty() {
        return count == 0;
    }

    //-----------------------------------------------------------------
    //  Returns the size of the queue.
    //-----------------------------------------------------------------
    public int size() {
        return count;
    }

    //-----------------------------------------------------------------
    //  Prints out the contents of the queue in a reasonable format.
    //-----------------------------------------------------------------
    public String toString() {
        String result = "<front of queue\n";
        LinearNode pointer = front;

        while (pointer != null) {
            result += pointer.getElement() + "\n";
            pointer = pointer.getNext();
        }

        return result + "<rear of queue>";
    }

    //-----------------------------------------------------------------
    //  Main method used for testing.
    //-----------------------------------------------------------------
    public static void main(String[] args) {
        LinkedQueue<String> lq1 = new LinkedQueue<String>();
        lq1.enqueue("Test");
        lq1.enqueue("New");
        lq1.enqueue("Final");
        System.out.println(lq1);
        System.out.println(lq1.first());
        System.out.println(lq1.dequeue());
        System.out.println(lq1);
    }

}
