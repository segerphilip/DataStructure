//********************************************************************
//  CircularArrayQueue.java       Java Foundations
//
//  Represents an array implementation of a queue in which neither
//  end of the queue is fixed in the array. The variables storing the
//  indexes of the front and rear of the queue continually increment
//  as elements are removed and added, cycling back to 0 when they
//  reach the end of the array.
//********************************************************************

package javafoundations;

import javafoundations.exceptions.*;

public class CircularArrayQueue<T> implements Queue<T> {
    private final int DEFAULT_CAPACITY = 10;
    private int front, rear, count;
    private T[] queue;

    //-----------------------------------------------------------------
    //  Creates an empty queue using the default capacity.
    //-----------------------------------------------------------------
    public CircularArrayQueue() {
        front = rear = count = 0;
        queue = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    //-----------------------------------------------------------------
    //  Adds the specified element to the rear of this queue, expanding
    //  the capacity of the queue array if necessary.
    //-----------------------------------------------------------------
    public void enqueue(T element) {
        if (count == queue.length)
            expandCapacity();

        queue[rear] = element;
        rear = (rear + 1) % queue.length;
        count++;
    }

    //-----------------------------------------------------------------
    //  Creates a new array to store the contents of this queue with
    //  twice the capacity of the old one.
    //-----------------------------------------------------------------
    public void expandCapacity() {
        T[] larger = (T[]) (new Object[queue.length * 2]);

        for (int index = 0; index < count; index++)
            larger[index] = queue[(front + index) % queue.length];

        front = 0;
        rear = count;
        queue = larger;
    }

    //-----------------------------------------------------------------
    //  Returns the first element in the queue, but also removes it.
    //-----------------------------------------------------------------
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("The queue is already empty");
        }

        T res = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        count--;
        return res;
    }

    //-----------------------------------------------------------------
    //  Returns the first element in the queue, but does not remove it.
    //-----------------------------------------------------------------
    public T first () throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("The queue is already empty");
        }

        return queue[front];
    }

    //-----------------------------------------------------------------
    //  Returns the size of count, the number of elements in the queue.
    //-----------------------------------------------------------------
    public int size() {
        return count;
    }

    //-----------------------------------------------------------------
    //  Returns true if the count is 0 for queue.
    //-----------------------------------------------------------------
    public boolean isEmpty() {
        return count == 0;
    }

    //-----------------------------------------------------------------
    //  Returns a string representation of the queue
    //-----------------------------------------------------------------
    public String toString() {
        if (count == 0) {
            return "Empty queue";
        }

        String res = "";
        int i = 0;
        while (i < count) {
            if (queue[i] != null) {
                res += queue[i].toString() + " ";
            }
            i++;
        }
        return res;
    }

    //-----------------------------------------------------------------
    //  Main method used for testing, moved to driver class.
    //-----------------------------------------------------------------
    public static void main(String[] args) {

    }
}