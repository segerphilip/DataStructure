/**
 * Created by philip on 2/3/16.
 */
public class Grade {
    private String letter;
    private double score;

//    constructor
    public Grade (String letterGrade, double numericalGrade) {
        letter = letterGrade;
        score = numericalGrade;
    }

//    Returns the score associated with this Grade
    public double getScore() {
        return this.score;
    }

//    Returns true if this Grade is higher than Grade g
    public boolean isHigherThan (Grade g) {
        if (this.score > g.getScore()) {
            return true;
        }
    }

//    Returns a String representation of this grade
    public String toString() {
        return "Letter grade: " + this.letter + "\n" + "Score: " + this.score + "\n";
    }

//    Returns the maximum of the two Grade objects
    public static Grade max(Grade g1, Grade g2) {
        if (g1.isHigherThan(g2)) {
            return g1;
        }
        else {
            return g2;
        }
    }


    public static void main(String[] args) {
        Grade charlotte = new Grade("B-", 82.1);
        Grade emily = new Grade("A", 94.5);
        Grade anne = new Grade("C+", 79.0);

        System.out.println(charlotte.isHigherThan(emily));
        System.out.println(Grade.max(charlotte, anne).toString());
    }
}