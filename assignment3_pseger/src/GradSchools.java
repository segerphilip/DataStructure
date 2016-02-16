import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jason and Philip on 2/15/16.
 */
public class GradSchools {
    private School[] schools;
    private int schoolIndex = 0;

    public GradSchools() {
        schools = new School[20]; // arbitrary size, didn't know what to set as default
    }

    public void addSchool(School sc1) {
        schools[schoolIndex] = sc1;
        schoolIndex++;
    }

    public void computeRatings() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please provide 3 weights (1..5) for Academics, Research, and Publications");
        int[] weights = new int[3];
//        scan for 3 separate inputs
        for (int i = 0; i < 3; i++) {
            weights[i] = scan.nextInt();
        }
//        compute the ranking for each school
        for (int i = 0; i < schoolIndex; i++) {
            schools[i].computeRating(weights[0], weights[1], weights[2]);
        }
    }

    public void rankSchools(String criteria) {
//        check for best research
        if (criteria.equals("research")) {
            int[] total = new int[schoolIndex];
//            copy research values only into int for sorting
            for (int i = 0; i < schoolIndex; i++) {
                total[i] = schools[i].getResearch();
            }
            Sort.sortArray(total);
            System.out.println("Ranking of schools from lowest to highest using research as sorting factor:\n");
            String[] outputs = new String[schoolIndex];
//            take sorted list and apply to school name
            for (int i = 0; i < total.length; i++) {
                for (int j = 0; j < total.length; j++) {
                    if (schools[j].getResearch() == total[i]) {
//                        if the value and school already exist in output, go to next school (and duplicate value)
//                        this is for the case where two schools have the same ranking
                        if (!Arrays.asList(schools).contains(total[i])) {
                            outputs[i] = schools[j].getName();
                        }
                    }
                }
            }
//            print out results
            formatOutput(outputs);
        }
        else if (criteria.equals("academics")) {
            int[] total = new int[schoolIndex];
//            copy academic values only into int for sorting
            for (int i = 0; i < schoolIndex; i++) {
                total[i] = schools[i].getAcademics();
            }
            Sort.sortArray(total);
            System.out.println("Ranking of schools from lowest to highest using academics as sorting factor:\n");
            String[] outputs = new String[schoolIndex];
//            take sorted list and apply to school name
            for (int i = 0; i < total.length; i++) {
                for (int j = 0; j < total.length; j++) {
                    if (schools[j].getAcademics() == total[i]) {
//                        if the value and school already exist in output, go to next school (and duplicate value)
//                        this is for the case where two schools have the same ranking
                        if (!Arrays.asList(schools).contains(total[i])) {
                            outputs[i] = schools[j].getName();
                        }
                    }
                }
            }
//            print out results
            formatOutput(outputs);
        }
        else if (criteria.equals("publications")) {
            int[] total = new int[schoolIndex];
//            copy publications int value into total for sorting
            for (int i = 0; i < schoolIndex; i++) {
                total[i] = schools[i].getPublications();
            }
            Sort.sortArray(total);
            System.out.println("Ranking of schools from lowest to highest using publications as sorting factor:\n");
            String[] outputs = new String[schoolIndex];
//            take sorted list and apply to school name
            for (int i = 0; i < total.length; i++) {
                for (int j = 0; j < total.length; j++) {
                    if (schools[j].getPublications() == total[i]) {
//                        if the value and school already exist in output, go to next school (and duplicate value)
//                        this is for the case where two schools have the same ranking
                        if (!Arrays.asList(schools).contains(total[i])) {
                            outputs[i] = schools[j].getName();
                        }
                    }
                }
            }
//            print out results
            formatOutput(outputs);
        }
        else if (criteria.equals("overall")) {
            int[] total = new int[schoolIndex];
//            copy overall rating int to total for sorting
            for (int i = 0; i < schoolIndex; i++) {
                total[i] = schools[i].getRating();
            }
            Sort.sortArray(total);
            System.out.println("Ranking of schools from lowest to highest using overall as sorting factor:\n");
            String[] outputs = new String[schoolIndex];
//            take sorted list and apply to school name
            for (int i = 0; i < total.length; i++) {
                for (int j = 0; j < total.length; j++) {
                    if (schools[j].getRating() == total[i]) {
//                        if the value and school already exist in output, go to next school (and duplicate value)
//                        this is for the case where two schools have the same ranking
                        if (!Arrays.asList(schools).contains(total[i])) {
                            outputs[i] = schools[j].getName();
                        }
                    }
                }
            }
//            print out results
            formatOutput(outputs);
        }
        else {
            System.out.println("Not a valid input");
        }
    }

//    nicely format the school names from rankSchools
    public void formatOutput(String[] outputs) {
        for (int i = 0; i < outputs.length; i++) {
            System.out.println(outputs[i] + "\n");
        }
    }

    public String toString() {
        String output = "There are " + schoolIndex + " schools in the database.\n";
        for (int i = 0; i < schoolIndex; i++) {
            output += schools[i].toString() + "\n\n";
        }
        return output;
    }

    public static void main(String[] args) {
        GradSchools gr1 = new GradSchools();
        School sc1 = new School("MIT", 9, 10, 7);
        gr1.addSchool(sc1);
//        gr1.computeRatings();
        System.out.println(gr1);

        School sc2 = new School("Harvard", 10, 5, 2);
        School sc3 = new School("Yale", 5, 7, 5);
        gr1.addSchool(sc2);
        gr1.addSchool(sc3);
        gr1.computeRatings();
        System.out.println(gr1);

//        scanner for ranking criteria testing
        Scanner scan = new Scanner(System.in);
        System.out.println("How would you like to filter school rankings? (academics, publications, research, or overall)");
        String criteria = scan.nextLine().toLowerCase();
        System.out.println(criteria);
//        get user input for criteria
        gr1.rankSchools(criteria);

        gr1.rankSchools("academics");
        gr1.rankSchools("research");
        gr1.rankSchools("publications");
        gr1.rankSchools("overall");
    }
}
