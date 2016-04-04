import java.io.*;
import java.util.Hashtable;

/**
 * Created by philip on 4/4/16.
 */
public class EnglishHashDictionary implements Dictionary {
    Hashtable<String, Integer> phrasing;

    /**
     * No-args constructor to create a blank hashtable.
     */
    public EnglishHashDictionary() {
        phrasing = new Hashtable<String, Integer>();
    }

    /**
     * Constructor that accepts a text file with english words.
     * @param words
     */
    public EnglishHashDictionary(String words) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(words));
        } catch (FileNotFoundException e) {
            System.out.println("Unable to read the file");
        }

        try {
//            read each line from the text file and add to hashmap
            String line = "";
            while ((line = br.readLine()) != null) {
                phrasing.put(line, 1);
            }
            br.close();

        } catch (IOException exception) {
            System.out.println("Unable to read file, error:\n" + exception);
        }
    }

    /**
     * Adds input String to the dictionary
     */
    public void addWord(String word) {
//        check to see if word already in hashtable
        if (phrasing.containsKey(word)) {
            int count = phrasing.get(word);
            phrasing.put(word, count++);
        }

//        if there is no instance of word, then create one
        phrasing.put(word, 1);
    }

    /**
     * Searches the dictionary for the input String.
     * Returns true if found, false otherwise.
     */
    public boolean searchWord(String word) {
        return phrasing.containsKey(word);
    }

    /**
     * Removes from the dictionary for the input String.
     * It does nothing if the input word is not in the dictionary.
     */
    public void removeWord(String word) {
//        check that word is in hashtable
        if (phrasing.containsKey(word)) {
            phrasing.remove(word);
        }
    }

    /**
     * Main testing method to run the program.
     */
    public static void main(String[] args) {
        EnglishHashDictionary ehd = new EnglishHashDictionary("EnglishWords.txt");
        System.out.println("donut: " + ehd.searchWord("donut"));
        System.out.println("Adding donut to dictionary");
        ehd.addWord("donut");
        System.out.println("donut: " + ehd.searchWord("donut"));
        System.out.println("data: " + ehd.searchWord("data"));
        System.out.println("booger: " + ehd.searchWord("booger"));
        System.out.println("  ");
    }
}
