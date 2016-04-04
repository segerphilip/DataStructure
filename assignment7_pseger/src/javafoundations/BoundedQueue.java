package javafoundations;
import javafoundations.exceptions.*;

/**
 * Created by philip on 4/3/16.
 */
public class BoundedQueue<T> extends CircularArrayQueue<T> {
    private int capacity;
    private int front, rear, count;
    private T[] queue;

    //-----------------------------------------------------------------
    //  Constructor that takes a capacity to make a bounded queue.
    //-----------------------------------------------------------------
    public BoundedQueue(int capacity) {
        this.capacity = capacity;
        front = rear = count = 0;
        queue = (T[]) (new Object[capacity]);
    }

    //-----------------------------------------------------------------
    //  Returns true if the capacity is full.
    //-----------------------------------------------------------------
    public boolean isFull() {
        return count == capacity;
    }

    //-----------------------------------------------------------------
    //  Adds elements to the queue if it is not full already.
    //-----------------------------------------------------------------
    public void enqueue(T element) {
        if (count == capacity) {
            System.out.println("Queue is already full");
            return;
        }

        queue[rear] = element;
        rear = (rear + 1) % queue.length;
        count++;
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
    //  Returns a string representation of the queue.
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
    //  Testing code.
    //-----------------------------------------------------------------
    public static void main(String[] args) {
        BoundedQueue<String> bq1 = new BoundedQueue<String>(2);
        bq1.enqueue("test");
        bq1.enqueue("new");
        System.out.println(bq1);
        bq1.enqueue("wow");
        bq1.dequeue();
        bq1.enqueue("wee");
        System.out.println(bq1);
        bq1.enqueue("full");
    }
}
