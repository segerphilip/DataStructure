//********************************************************************
//  VectorStack.java       Java Foundations
//
//  Represents a vector implementation of a stack. The bottom of
//  the stack is kept at index 0. So, pushing and popping happens at the higher 
//  end of the underlying vector.
//********************************************************************

package javafoundations;

import javafoundations.exceptions.*;
import java.util.Vector; 

public class VectorStack<T> implements Stack<T> {
    
    private int count; //num of elements in the array
    private Vector<T> vector; //vector to hold the elements
    
    //-----------------------------------------------------------------
    //  Creates an empty stack using the default capacity.
    //-----------------------------------------------------------------
    public VectorStack()
    {
        count = 0;
        vector = new Vector<T>();
    }
    
    //-----------------------------------------------------------------
    //  Adds the specified element to the top of this stack, expanding
    //  the capacity of the stack array if necessary.
    //-----------------------------------------------------------------
    public void push(T element)
    {
        vector.add(count, element);
        count++;
    }
    
    //-----------------------------------------------------------------
    //  Returns the last element at the top of the stack
    //-----------------------------------------------------------------
    public T pop() throws EmptyCollectionException {
        try {
            T temp = vector.elementAt(count - 1); 
            count--;
            return temp;
        }
        catch (IndexOutOfBoundsException exception) {
            throw new EmptyCollectionException("The stack is empty. pop() failed");
        }
    }
    
    //-----------------------------------------------------------------
    //  Return the top value of the stack, but do not remove it
    //-----------------------------------------------------------------
    public T peek () throws EmptyCollectionException {
        try {
            return vector.elementAt(count-1);
        }
        catch (IndexOutOfBoundsException exception) {
            throw new EmptyCollectionException("The stack is empty. peek() failed");
        }
    }
    
    //-----------------------------------------------------------------
    //  Checks to see if the stack is empty
    //-----------------------------------------------------------------
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    //-----------------------------------------------------------------
    //  Checks how many objects are in the array 
    //-----------------------------------------------------------------
    public int size() {
        return count;
    }
    
    //-----------------------------------------------------------------
    //  Returns a string representation of this stack.
    //-----------------------------------------------------------------
    public String toString()
    {
        String result = "<top of stack>\n";
        
        for (int index=count-1; index >= 0; index--)
            result += vector.elementAt(index) + "\n";
        
        return result + "<bottom of stack>";
    }
    
    //-----------------------------------------------------------------
    //  Testing main method
    //-----------------------------------------------------------------
    public static void main(String[] args) {
        VectorStack<String> test = new VectorStack<String>();
        System.out.println(test.isEmpty());
        test.push("mon");
        test.push("tues");
        test.push("wed");
        test.push("thrs");
        System.out.println(test.pop());
        System.out.println(test.peek());
        test.push("fri");
        System.out.println(test);
        System.out.println(test.size());
    }
}