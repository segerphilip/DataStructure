import java.util.*;
import java.io.*;
/**
 * Created by philip and eliza on 2/19/16.
 */
public class Warning {
    private String inFile,
        outFile;
    
    public Warning(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
        
        try {
            PrintWriter writer = new PrintWriter(new File (outFile));
            Scanner reader = new Scanner(new File(inFile));
            
            
            while (reader.hasNext()) {
                try {
                    String name = reader.next();
                    int hours = reader.nextInt();
                    double quality = reader.nextDouble();
                    
                    Student student = new Student(name, hours, quality);
                    
                    if (student.isOnWarning()) {
                        writer.write(student.getName() + " " + student.getHours() + " " + 
                                     student.getGPA() + "\n");
                    }
                }
                catch (InputMismatchException exception) {
                    System.out.println("This data has elements of the wrong type."); 
                }
                catch (NoSuchElementException exception) {
                    System.out.println("This data has elements of the wrong type.");
                }
            }
            
            writer.close();
            reader.close();
        }
        catch (FileNotFoundException exception) {
            System.out.println("Input file could not be found.");
        }
    }
    
    public static void main(String[] args) {
        Warning warning = new Warning("students.dat", "warnings.txt");
    }
}