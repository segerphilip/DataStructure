/**
 * Created by philip on 4/24/16.
 */
public class Scheduler {
    public Scheduler() {

    }

    public void add(Task tk) {

    }

    public Task runTask() {
        return new Task("B", 1, 1, 1);
    }

    public static void main(String[] args) {
        Scheduler sd1 = new Scheduler();

        System.out.println(sd1);
    }
}
