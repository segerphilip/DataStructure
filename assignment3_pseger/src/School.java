import java.util.Scanner;

/**
 * Created by philip on 2/15/16.
 */
public class School {
    private String name;
    private int academics,
                research,
                publications,
                rating = 0,
                rank = 0;

    public School(String name, int academics, int research, int publications) {
        this.name = name;
        this.academics = academics;
        this.research = research;
        this.publications = publications;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAcademics() {
        return academics;
    }

    public void setAcademics(int academics) {
        this.academics = academics;
    }

    public int getResearch() {
        return research;
    }

    public void setResearch(int research) {
        this.research = research;
    }

    public int getPublications() {
        return publications;
    }

    public void setPublications(int publications) {
        this.publications = publications;
    }

    public void computeRating(int w1, int w2, int w3) {
        rating = w1 * academics + w2 * research + w3 * publications;
    }

    public String toString() {
        return "Name: " + name +
                "\nAcademics: " + academics +
                "\nResearch: " + research +
                "\nPublications: " + publications +
                "\nOverall rating: " + rating +
                "\nCurrent rank: " + rank;
    }

    public static void main(String[] args) {
        
//        if (args.length != 3) {
//            System.out.println("Please provide 3 weights (1..5) for Academics, Research, and Publications");
//        }
//        else {
////            call computeRating
//        }
    }
}