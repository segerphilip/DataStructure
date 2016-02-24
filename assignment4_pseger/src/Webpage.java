import java.net.*;
import java.io.*;

/**
 * Created by philip on 2/23/16.
 */
public class Webpage implements Comparable<Webpage> {
    private String url;
    private int lines;
    private String sentence;

    /**
     * constructor that creates a Webpage object with an inputted url
     * line amounts are by default set to 0
     * sentence is a new string object
     * @param url
     */
    public Webpage(String url) {
        this.url = url;
        this.lines = 0;
        this.sentence = new String();
    }

//    getters and setters
    public int getLines() {
        return lines;
    }

    public void setLines(int newLines) {
        lines = newLines;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String newUrl) {
        url = newUrl;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String newSentence) {
        sentence = newSentence;
    }

    /**
     * opens a connection to a website and reads the lines found on the page
     * throws an exception if the url is bad, or if it is unable to read the webpage
     * @throws IOException
     */
    public void countLines() throws IOException {
        URL ur1 = null;
        try {
            ur1 = new URL(url);
        }
        catch (MalformedURLException e) {
            System.out.println("That is not a proper URL");
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(ur1.openStream()));
        int count = 0;
        String input = "";

        while (in.readLine() != null) {
            input += in.readLine();
            count += 1;
        }
        in.close();
        try {
            sentence = input.substring(0, 20);
        }
        catch (IndexOutOfBoundsException exception) {
            sentence = input;
        }
        lines = count;
    }

    /**
     * compares a webpage to another inputted webpage object
     *  1 for if current webpage has more lines
     *  0 for if both have same number of lines
     *  -1 for if other webpage has more lines
     * @param T another webpage object
     * @return int value
     */
    public int compareTo(Webpage T) {
        if (lines > T.getLines()) {
            return 1;
        }
        else if (lines == T.getLines()) {
            return 0;
        }
        return -1;
    }

    /**
     * tostring method
     * @return
     */
    public String toString() {
        return url + "\t\t\t" + lines + "\t\t\t" + sentence;
    }

    /**
     * testing for reading number of lines of a website
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Webpage wp1 = new Webpage("https://www.google.com/");
        wp1.countLines();
        System.out.println(wp1);
        Webpage wp2 = new Webpage("http://www.olin.edu/students/academic-calendar-2015-16/");
        wp2.countLines();
        System.out.println(wp2);
        System.out.println(wp1.compareTo(wp2));
    }
}
