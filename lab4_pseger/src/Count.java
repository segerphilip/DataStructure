import java.util.Scanner;
/**
 * Created by philip and eliza on 2/19/16.
 */
public class Count {
    private String word;
    private int[] counts;
    
    public Count(String word) {
        this.word = word.toUpperCase();
        this.counts = new int[26];
    }
    
    public void countArray() {
        for (int i = 0; i < word.length(); i++) {
            try {
                int index = (int)(word.charAt(i) - 65);
                counts[index] += 1;
            }
            catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("Error: " + (char)(word.charAt(i)) + " is not allowed.");
            }
        }
    }
    
    public String toString() {
        String printString = "";
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                printString += ((char)(i + 65) + ": " + counts[i] + "\t"); 
            }
        }
        return printString;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a word");
        String word = scan.nextLine();
        
        Count c1 = new Count(word);
        c1.countArray();
        System.out.println(c1);
    }
}