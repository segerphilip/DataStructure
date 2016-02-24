import com.sun.javaws.exceptions.InvalidArgumentException;
import com.sun.tools.corba.se.idl.InvalidArgument;
import com.sun.tools.javac.code.Attribute;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by philip on 2/23/16.
 *
 * Error: unable to test because calling webpage.getLines always returns 0
 *     however works fine for testing in the Webpage class
 */
public class Cyberspace {
    private String inFile;
    private Webpage[] webpages;
    private String[] input;
    private int counter = 0;

    /**
     * constructor to get input from the user
     */
    public Cyberspace() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter URLs (without spaces) below; end your list with ctrl-D:");
        input = new String[10];
        try {
            while (scan.hasNextLine()) {
                if (scan.hasNextLine() && counter > input.length) {
                    String[] newInput = new String[20];
                    for (int i = 0; i < input.length; i++) {
                        newInput[i] = input[i];
                    }
                    input = newInput;
                }
                System.out.println(scan.nextLine());
                input[counter] = scan.nextLine();
                counter++;
            }
        }
        catch (NoSuchElementException except) {
            System.out.println("End of line");
        }
    }

    /**
     * constructor to read webpages from txt file
     * @param infile
     */
    public Cyberspace(String infile) {
        this.inFile = infile;
        try {
            Scanner reader = new Scanner(new File(inFile));

            while (reader.hasNext()) {
                if (reader.hasNextLine() && counter > input.length) {
                    String[] newInput = new String[20];
                    for (int i = 0; i < input.length; i++) {
                        newInput[i] = input[i];
                    }
                    input = newInput;
                }
                input[counter] = reader.nextLine();
                counter++;
            }
            reader.close();
        }
        catch (FileNotFoundException exception) {
            System.out.println("Input file could not be found.");
        }
    }

    /**
     * creates an array of Webpage objects based on input arguments
     */
    public void createObjects() {
        webpages = new Webpage[counter];
        for (int i = 0; i < counter; i++) {
            webpages[i] = new Webpage(input[i]);
        }
    }

    /**
     * loops through and sorts the webpages list based on line length
     */
    public void sortObjects() {
        Webpage temp;
        for (int i = 1; i < webpages.length; i++) {
            for (int j = i ; j > 0 ; j--) {
                if (webpages[j].getLines() < webpages[j-1].getLines()) {
                    temp = webpages[j];
                    webpages[j] = webpages[j-1];
                    webpages[j-1] = temp;
                }
            }
        }
    }

    /**
     * Not fully working, but should sort through each value and store the larger one
     * only currently works comparing the right and left values
     * @param wp1
     */
    public void addObjects(Webpage wp1) {
        Webpage[] temp = new Webpage[webpages.length + 1];
        int counter = 0;
        while (counter < webpages.length) {
            if (webpages[counter].compareTo(wp1) == 1) {
                temp[counter] = webpages[counter];
                temp[counter + 1] = wp1;
                counter += 2;
            }
            else if (webpages[counter].compareTo(wp1) == -1) {
                temp[counter] = wp1;
                temp[counter + 1] = webpages[counter];
                counter += 2;
            }
            else {
                temp[counter] = webpages[counter];
                counter++;
            }
        }
    }

    /**
     * either call the constructor with the file for websites,
     * or call the no args constructor to ask for user input
     * create objects and save in array
     * @param args
     */
    public static void main(String[] args) {
        Cyberspace cs1;
        if (args.length > 0) {
            cs1 = new Cyberspace(args[1]);
        }
        else {
            cs1 = new Cyberspace();
        }
        cs1.createObjects();
    }
}
