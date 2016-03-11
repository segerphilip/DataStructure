/** RadixSort.java
 CS230 Lab 7: 
 Written by: Eliza McNair and Philip Seger
 Modified date: 3/11/16 */

import javafoundations.*; 
import java.util.Vector; 

public class RadixSort {
  
  // task 2b: Instance Variables:
  private final int NUMBERLENGTH = 3; 
     // the length of each number in the input
  
  private final int BASE = 10;
     // number system we are working on
  
  private Vector<Integer> input, output; 
     // to hold the input (unsorted) and the output (sorted) numbers
  
  // task 2c: Constructor: 
  
  public RadixSort() {
    input = new Vector<Integer>(); 

    input.add(346); 
    input.add(278);
    input.add(981); 
    input.add(776);
    input.add(431); 
    input.add(246); 
    input.add(571); 
    
    output = new Vector<Integer>();
    
    for (int i = 0; i < input.size(); i ++) {
      output.add(input.get(i));
    }
  }
  
  private void processOnePosition(int pos) {
    Vector<ArrayQueue<Integer>> queues = new Vector<ArrayQueue<Integer>>();
    
    for (int digitVal = 0; digitVal < BASE; digitVal ++) {
      queues.add(new ArrayQueue<Integer>()); 
    }
    
    for (int i = 0; i < output.size(); i++) {
      String tempStr = String.valueOf(output.elementAt(i)); 
      int digit = Character.digit (tempStr.charAt(pos), BASE);
      queues.get(digit).enqueue(output.elementAt(i));
    }
    
    // All digit queues filled (if necessary)
    
    output.clear(); 
    
    for (int q = 0; q < BASE; q++) {
      while (!(queues.get(q).isEmpty())) {
        output.add(queues.get(q).dequeue());
      }
    }
  }
 
  public void processAll() {
    for (int i = NUMBERLENGTH-1; i >= 0; i--) {
      processOnePosition(i);
      System.out.println(output);
    }
  }
  
  public String toString() {
    String result = "Unsorted Contents:\n"; 
    
    for (int i = 0; i < input.size(); i ++) {
      result += input.elementAt(i) + ", "; 
    }
    
    result += "\nSorted Contents:\n";
    
    for (int j = 0; j < output.size(); j ++) {
      result += output.elementAt(j) + ", "; 
    }
    return result; 
  }
  
  public static void main(String [] args) {
    RadixSort test = new RadixSort(); 
    System.out.println("Radices: \n"); 
    test.processAll(); 
    System.out.println("\n" + test); 
  }
}