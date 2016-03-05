/**
 * Created by philip on 3/3/16.
 */
public class ClubStudent extends Student {
    private int yearJoined;
    private String clubName;

    public ClubStudent(String name, String userName, int year, int yearJoined, String clubName) {
        super(name, userName, year);
        this.yearJoined = yearJoined;
        this.clubName = clubName;
    }

    public String toString() {
        return super.toString() + ", club: " + clubName + ", member since: " + yearJoined;
    }

    public static void main(String[] args) {
        ClubStudent cl1 = new ClubStudent("Jon", "jn", 1990, 1989, "Chess club");
        ClubStudent cl2 = new ClubStudent("Mills", "ms", 1993, 1990, "Rugby");
        System.out.println(cl1);
        System.out.println(cl2);
        cl2.compareTo(cl1);
    }
}
