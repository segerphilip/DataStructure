/**
 * Created by philip on 4/24/16.
 */
public class Task implements Comparable<Task> {
    private String name;
    private int timeNeeded;
    private int timeIn;
    private int priority;

    public Task(String name, int timeNeeded, int timeIn, int priority) {
        this.name = name;
        this.timeNeeded = timeNeeded;
        this. timeIn = timeIn;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getTimeNeeded() {
        return timeNeeded;
    }

    public int getTimeIn() {
        return timeIn;
    }

    public int getPriority() {
        return priority;
    }

    public String toString() {
        String result = "";
        result += name + " --" + timeNeeded + " cycles priority " + priority;
        return result;
    }

    public int compareTo(Task t1) {
        if (priority > t1.getPriority()) {
            return 1;
        } else if (priority == t1.getPriority()) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Task t1 = new Task("Firefox", 10, 1, 3);
        Task t2 = new Task("FirstClass", 7, 2, 1);
        Task t3 = new Task("DrJava", 5, 3, 3);

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

        System.out.println("comparisons: ");
        System.out.println(t1.compareTo(t2));
        System.out.println(t1.compareTo(t1));
        System.out.println(t2.compareTo(t1));
        System.out.println(t3.compareTo(t1));
    }
}
