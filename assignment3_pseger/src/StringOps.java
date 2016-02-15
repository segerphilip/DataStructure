/**
 * Created by philip on 2/15/16.
 * Assignment 3: Task 1
 * Methods removeChar - removes 1 instance of a character
 *         removeAllChar - removes all instances of a character
 *              (coded by accident, but the recursion is on
 *              point, so keeping it
 *         testAnagrams -
 */
public class StringOps {


    public static String removeChar (String S, char ch) {
        String stripString = "";
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == ch) {
                stripString = S.substring(0, S.indexOf(ch)) + S.substring(S.indexOf(ch) + 1);
            }
        }
        if (stripString.length() == 0) {
            stripString = S;
        }
        return stripString;
    }

    /**
     * @param S - initial word
     * @param ch - character to remove from string
     * @return string with all instances of ch removed
     */
    public static String removeAllChar (String S, char ch) {
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == ch) {
                return removeAllChar(S.substring(0, S.indexOf(ch)) + S.substring(S.indexOf(ch) + 1), ch);
            }
        }
        return S;
    }

    /**
     * Anagrams are two words that have exactly the same letters, but in a
     * different order. For example, the following pairs of words are anagrams:
     * (melon, lemon), (mothers, thermos) and (ocean, canoe). Given two input
     * strings, the testAnagrams() method should determine whether the two strings
     * are anagrams and print the outcome to the user.
     *
     For example, the method call testAnagrams("melon", "lemon");
     might result in the following printout: "melon and lemon are anagrams",
     while the method call testAnagrams("hello", "world");
     might result in: "hello and world are not anagrams"

     Assume that a word is not an anagram of itself, so the pair of words
     (hello, hello) are not anagrams. You can assume that both input strings
     consist entirely of lowercase letters. Hint: Your removeChar() method
     could be handy in the implementation of testAnagrams()!

     * @param word1 - to test with anagram of othe word
     * @param word2 - to test with anagram of othe word
     */
    public static void testAnagrams (String word1, String word2) {
        if (word1.length() == word2.length()) {
            if (word1.equals(word2)) {
                System.out.println("Not anagrams because exactly same word.");
            }
            else {
                String check = checkAnagram (word1, word2);
                if (check.equals("Anagram")) {
                    System.out.println("These words are anagrams.");
                }
                else {
                    System.out.println("These words are not anagrams.");
                }
            }
        }
        else {
            System.out.println("Not anagrams because not same length.");
        }
    }

    private static String checkAnagram (String word1, String word2) {
        for (int i = 0; i < word1.length(); i++) {
            word1 = removeAllChar(word1, word1.charAt(i));
            word2 = removeAllChar(word2, word1.charAt(i));
            if (word1.length() == 0 && word2.length() == 0) {
                return "Anagram";
            }
            else {
                return checkAnagram(word1, word2);
            }
        }
        return "fail";
    }

    public static void main(String[] args) {
//        String test = "This is a testing string";
//        System.out.println(removeChar(test, 'i'));
        testAnagrams("melon", "lemon");

//        System.out.println(removeChar("java", 'a'));
//        System.out.println(removeChar("java", 'q'));
    }
}
