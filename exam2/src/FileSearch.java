//Starter code for Problem 2. 

//There are two places that you need to insert code, marked below. 
//There may be other places you may need to add code.

import java.util.*;
import java.io.*;

public class FileSearch {

  // Instance variables
  private String path;
  private String query;

  // Constructor
  public FileSearch(String path, String query) {
    this.path = path;
    this.query = query;
  }

  // Instance methods
  public void performSearch() {

    // YOUR CODE HERE

  }

  // main method
  public static void main(String[] args) {
    if (args.length < 2) {
      System.err.println("Please run the FileSearch application with two command line arguments corresponding to (1) the path to a folder on your computer and (2) some text that may be found in the name of a file.");
      return;
    }

    // YOUR CODE HERE

  }

}
