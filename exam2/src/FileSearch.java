//Starter code for Problem 2. 

//There are two places that you need to insert code, marked below. 
//There may be other places you may need to add code.
// This program should work correctly.

import java.util.*;
import java.io.*;

import javafoundations.*;

public class FileSearch {

    // Instance variables
    private String path;
    private String query;
    private Vector<String> results;
    private LinkedQueue<File> queue;

    /**
     * Constructor that takes a path to begin searching for files with query in the name.
     *
     * @param path
     * @param query
     */
    public FileSearch(String path, String query) {
        this.path = path;
        this.query = query;
//        using a vector to store resulting paths because I don't have to worry about expanding it, and printing from it is easy
        this.results = new Vector<String>();
//        hold a directories in a queue of File objects
        this.queue = new LinkedQueue<File>();

//        check for if input was .  if so, get the proper path for use later
        if (path == ".") {
            path = new File("").getAbsolutePath();
        }
        queue.enqueue(new File(path));
//        System.out.println(queue.first());
    }

    /**
     * Method that searches folders (and sub-folders) for files with query in the title.
     * Uses a queue implementation to add new directories to search through.
     */
    public void performSearch() {
        while (!queue.isEmpty()) {
//            dequeue the directory to search through
            File dir = queue.dequeue();

//            get a list of all the items in the current directory and save it in folders array
            String[] folders = dir.list();
//            loop through all the items in folders array
            for (int i = 0; i < folders.length; i++) {
//                get the object referenced from the folders and create a File object from it so we can use File
//                methods to manipulate it
                File temp = new File(dir.getAbsolutePath() + '/' + folders[i]);

//                if temp is a file and also contains our query, add it to results
                if (temp.getAbsoluteFile().isFile() && temp.getName().contains(query)) {
                    results.add(temp.getAbsolutePath());
                }
//                if temp is a directory, enqueue its path so we can search through it next
                else if (temp.getAbsoluteFile().isDirectory()) {
                    queue.enqueue(new File(temp.getAbsolutePath()));
                }
            }

        }
    }

    /**
     * Method to print out all files (and their paths) that contain our query word, or no files found
     *
     * @return
     */
    public String toString() {
        String res = "";
        if (results.size() == 0) {
            res = "No files found";
        }

//        this is why vectors are great, we didn't need to expand it and can easily print (though arrays are similar)
        for (int i = 0; i < results.size(); i++) {
            res += results.elementAt(i) + "\n";
        }
        return res;
    }

    /**
     * Main method.
     *
     * @param args: path and query
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Please run the FileSearch application with two command line arguments corresponding to (1) the path to a folder on your computer and (2) some text that may be found in the name of a file.");
            return;
        }

//        hardcoded values for testing purposes
//        String path = "/Users/philip/Desktop";
//        String query = "jpg";

        FileSearch fs1 = new FileSearch(args[0], args[1]);
//        FileSearch fs1 = new FileSearch(path, query); // also for testing
        fs1.performSearch();
        System.out.println(fs1);
    }

}
