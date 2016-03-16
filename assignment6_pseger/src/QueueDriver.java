import javafoundations.*;
/**
 * Created by philip on 3/15/16.
 */
public class QueueDriver {
    public static void main(String[] args) {
        System.out.println("Linked Queue");
        LinkedQueue<String> lq1 = new LinkedQueue<String>();
        lq1.enqueue("Test");
        lq1.enqueue("New");
        lq1.enqueue("Final");
        System.out.println(lq1);
        System.out.println(lq1.first());
        System.out.println(lq1.dequeue());
        System.out.println(lq1);
        System.out.println(lq1.size());

        System.out.println("Array Queue");
        ArrayQueue<String> aq1 = new ArrayQueue<String>();
        aq1.enqueue("Test");
        aq1.enqueue("New");
        aq1.enqueue("Final");
        System.out.println(aq1);
        System.out.println(aq1.first());
        System.out.println(aq1.dequeue());
        System.out.println(aq1);
        System.out.println(aq1.size());

        System.out.println("Circular Array Queue");
        CircularArrayQueue<String> cq1 = new CircularArrayQueue<String>();
        cq1.enqueue("Test");
        cq1.enqueue("New");
        cq1.enqueue("Final");
        System.out.println(cq1);
        System.out.println(cq1.first());
        System.out.println(cq1.dequeue());
        System.out.println(cq1);
    }
}
