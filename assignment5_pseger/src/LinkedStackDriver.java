package javafoundations;
/**
 * Created by philip on 3/2/16.
 */
public class LinkedStackDriver {

    //-----------------------------------------------------------------
    //  Testing method for stack implementation.
    //-----------------------------------------------------------------
    public static void main(String[] args) {
        LinkedStack<String> ls1 = new LinkedStack<String>();
        ls1.push("test");
        System.out.println(ls1);
        ls1.push("new");
        System.out.println(ls1);
        ls1.push("done");
        System.out.println(ls1.peek());
        System.out.println(ls1);
        System.out.println(ls1.pop());
        System.out.println(ls1);
        ls1.pop();
        ls1.pop();
//        check that exception handling works for empty stack
        System.out.println(ls1.peek());
    }
}
