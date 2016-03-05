import javafoundations.LinkedStack;

import java.util.function.Predicate;

/**
 * Created by philip on 3/5/16.
 */
public class PalindromeChecker {
    private String word;

//    palindrome constructor that saves the word as a global var
    public PalindromeChecker(String word) {
//        sets input word to word, along with removing any spaces
        this.word = word.replaceAll("\\s+","");
    }

//    predicate method to check if a palindrome
    public boolean checkPalindrome() {
//        create the stack object
        LinkedStack<Character> linked = new LinkedStack<Character>();

//        add each character from word into the stack
        for (int i = 0; i < word.length(); i++) {
            linked.push(word.charAt(i));
        }

//        get the reverse of the string from stack and save it
        String reverse = "";
        while (!linked.isEmpty()) {
            reverse += linked.pop();
        }

//        check that word and reverse are equal
        if (word.equals(reverse)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * The program should contain a predicate method checkPalindrome()
     * that returns true or false as appropriate.
     *
     * I did not know how to implement this, as the method above as a
     * predicate method would not return boolean values, as instructed.
     */


    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Program requires input. E.X.\njava PalindromeChecker.class anna");
            return;
        }
        PalindromeChecker pc1 = new PalindromeChecker(args[0]);
        System.out.println(pc1.checkPalindrome());
    }
}
