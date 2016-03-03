//********************************************************************
//  LinkedStack.java       Java Foundations
//
//  Represents a linked implementation of a stack.
//********************************************************************
/**
 * Created by philip on 3/3/16.
 */
package javafoundations;

import javafoundations.exceptions.*;

public class LinkedStack<T> implements Stack<T> {
    private int count;
    private LinearNode<T> top;

    //-----------------------------------------------------------------
    //  Creates an empty stack using the default capacity.
    //-----------------------------------------------------------------
    public LinkedStack() {
        count = 0;
        top = null;
    }

    //-----------------------------------------------------------------
    //  Adds an element elm at the top of the stack.
    //-----------------------------------------------------------------
    public void push(T elm) {

    }

    //-----------------------------------------------------------------
    //  Removes the element at the top of this stack and returns a
    //  reference to it. Throws an EmptyCollectionException if the
    //  stack contains no elements.
    //-----------------------------------------------------------------
    public T pop() throws EmptyCollectionException {
        if (count == 0)
            throw new EmptyCollectionException("Pop operation failed. "
                    + "The stack is empty.");

        T result = top.getElement();
        top = top.getNext();
        count--;

        return result;
    }

    //-----------------------------------------------------------------
    //  Returns the value for the element at the top of the stack.
    //  Throws an EmptyCollectionException if the stack contains no
    //  elements.
    //-----------------------------------------------------------------
    public T peek () throws EmptyCollectionException {

    }

    //-----------------------------------------------------------------
    //  Returns true if the stack is empty or false otherwise.
    //-----------------------------------------------------------------
    public boolean isEmpty() {
        return (count == 0) ? true : false;
    }

    //-----------------------------------------------------------------
    //  Returns the amount of elements in the stack.
    //-----------------------------------------------------------------
    public int size() {
        return count;
    }

    //-----------------------------------------------------------------
    //  Returns a string representation of this stack.
    //-----------------------------------------------------------------
    public String toString() {
        String result = "<top of stack>\n";
        LinearNode current = top;

        while (current != null) {
            result += current.getElement() + "\n";
            current = current.getNext();
        }

        return result + "<bottom of stack>";
    }

    //-----------------------------------------------------------------
    //  Testing method for stack implementation.
    //-----------------------------------------------------------------
    public static void main(String[] args) {

    }
}
