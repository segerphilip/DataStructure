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

    /**
     * Takes String S and char ch, removing the first instance of ch
     * from String S and returning S
     * @param S
     * @param ch
     * @return
     */
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
     * Takes String S and char ch, removing first instance of ch,
     * then returning and removing the rest of ch. Returns S.
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
     * Initial checks for anagram, same length, same word.
     * @param word1 - to test with anagram of other word
     * @param word2 - to test with anagram of other word
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

    /**
     * Goes through word1 and word2, removing letters until they are either different,
     * or they are the same last letter. Then anagram.
     * @param word1
     * @param word2
     * @return
     */
    private static String checkAnagram (String word1, String word2) {
        if (word1.length() == 1 && word2.length() == 1 && word1.equals(word2)) {
            return "Anagram";
        }
        else if (word1.length() > 1 && word2.length() > 1) {
            return checkAnagram(removeChar(word1, word1.charAt(0)), removeChar(word2, word1.charAt(0)));
        }
        else {
            return "fail";
        }
    }

    /**
     * Testing method.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(removeChar("This is a testing string", 'i'));
        testAnagrams("melon", "lemon");
        testAnagrams("testi", "tsett");
        testAnagrams("hello", "hello");
        testAnagrams("", "");
        testAnagrams("philip", "piplih");

        System.out.println(removeChar("java", 'a'));
        System.out.println(removeChar("java", 'q'));
        System.out.println(removeChar("test", 'x'));
        System.out.println(removeAllChar("mississippi", 's'));
    }
}
