import java.util.Scanner;

/**
 * Created by philip on 2/1/16.
 */
public class CountVowels {
//    Returns true if character is lower-case
//    vowel (a, e, i, o, u), false otherwise.
    public static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        else
            return false;
    }

//    Returns the number of occurrences of
//    vowels in the String s.
    public static int countVowels(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i)) == true) {
               count++;
            }
        }
        return count;
    }

//    Calls isVowel and countVowels for some String.
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input a word: ");
        String word = scan.nextLine();
        System.out.println(countVowels(word));
    }
}
