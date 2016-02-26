//********************************************************************
//  ArrayStack.java       Java Foundations
//
//  Represents an array implementation of a stack. The bottom of
//  the stack is kept at array index 0. So, pushing and popping happens at the higher 
//  end of the underlying array.
//********************************************************************

package javafoundations;

import javafoundations.exceptions.*;

public class ArrayStack<T> implements Stack<T>
{
    private final int DEFAULT_CAPACITY = 10; //keep it small for testing purposes
    private int count; //num of elements in the array
    private T[] array; //array to hold the elements

    //-----------------------------------------------------------------
    //  Creates an empty stack using the default capacity.
    //-----------------------------------------------------------------
    public ArrayStack()
    {
        count = 0;
        array = (T[])(new Object[DEFAULT_CAPACITY]);
    }
    
    //-----------------------------------------------------------------
    //  Expands the array by a new value of DEFAULT_CAPACITY
    //-----------------------------------------------------------------
    private void expandCapacity() {
        T[] tempArray = (T[])(new Object[array.length + DEFAULT_CAPACITY]);
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[i];
        }
        array = tempArray;
    }
    
    //-----------------------------------------------------------------
    //  Adds the specified element to the top of this stack, expanding
    //  the capacity of the stack array if necessary.
    //-----------------------------------------------------------------
    public void push(T element)
    {
        if (count == array.length)
            expandCapacity();
        
        array[count] = element;
        count++;
    }
    
    //-----------------------------------------------------------------
    //  Returns the last element at the top of the stack
    //-----------------------------------------------------------------
    public T pop() throws EmptyCollectionException {
        try {
            T temp = array[count - 1]; 
            count--;
            return temp;
        }
        catch (ArrayIndexOutOfBoundsException exception) {
            throw new EmptyCollectionException("The stack is empty. pop() failed");
        }
    }
    
    //-----------------------------------------------------------------
    //  Return the top value of the stack, but do not remove it
    //-----------------------------------------------------------------
    public T peek() throws EmptyCollectionException {
        try {
            return array[count - 1];
        }
        catch (ArrayIndexOutOfBoundsException exception) {
            throw new EmptyCollectionException("The stack is empty. peek() failed"); 
        }
    }
    
    //-----------------------------------------------------------------
    //  Checks to see if the stack is empty
    //-----------------------------------------------------------------
    public boolean isEmpty() {
        return count == 0;
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
            result += array[index] + "\n";
        
        return result + "<bottom of stack>";
    }
    
    //-----------------------------------------------------------------
    //  Testing main method
    //-----------------------------------------------------------------
    public static void main(String[] args) {
        ArrayStack<String> test = new ArrayStack<String>();
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
