//********************************************************************
//  MatchChecker.java       Java Foundations
//
//  Represents an array implementation of a stack. The bottom of
//  the stack is kept at array index 0. So, pushing and popping happens at the higher 
//  end of the underlying array.
//********************************************************************

package javafoundations;

import javafoundations.exceptions.*;

public class MatchChecker {
    private String expression;
    private VectorStack<Character> vectorStack; 
    
    public MatchChecker(String expression) {
        this.expression = expression;
        vectorStack = new VectorStack<Character>();
    }
    
//    Currently will fail because if it reaches the end but still open {[( in stack will not check
    public boolean updateStack() {
        for (int i = 0; i < expression.length(); i++) {
            if (openBracket(expression.charAt(i))) { 
                vectorStack.push(expression.charAt(i));
                System.out.println(expression.charAt(i));
            }   
            if (closeBracket(expression.charAt(i))) {
                char check = expression.charAt(i);
                System.out.println(check);
                if (matchingBracket(vectorStack.peek()) != (char)check) {
                    return false;
                }
                else 
                {
                    try {
                        vectorStack.pop();
                    }
                    catch (IndexOutOfBoundsException exception) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean openBracket(char c) {
        return (c == '(') || (c == '{') || (c == '<');
    }
    
    public boolean closeBracket(char c) {
        return (c == ')') || (c == '}') || (c == '>');
    }
    
    public char matchingBracket(char c) {
        if (c == '(') {
            return ')'; 
        }
        else if (c == '{') {
            return '}';
        }
        else if (c == '[') {
            return ']'; 
        }
        else if (c == '<') {
            return '>';
        }
        else
        {
            return 'X'; //error check this probably
        }
    }
    
    public static void main(String[] args) {
        MatchChecker m1 = new MatchChecker("T(hi)(is{})");
        System.out.println(m1.updateStack());
        MatchChecker m2 = new MatchChecker("Thi{{s()}");
        System.out.println(m2.updateStack());
//        MatchChecker m3 = new MatchChec
    }
        
}
