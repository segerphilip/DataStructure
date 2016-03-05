import java.util.LinkedList;

/**
 * Created by philip on 3/5/16.
 */
public class StudentOrganization {
//    an instance variable of type LinkedList to hold objects of type ClubStudent
    private LinkedList<ClubStudent> linkedlist;
    //    instance variables to hold the name of the Organization, its president and Vice President.
    private String pres;
    private String orgName;
    private String vpres;

//    a constructor that takes the name of the Organization as its only input.
    public StudentOrganization(String orgName) {
        this.orgName = orgName;
        linkedlist = new LinkedList<ClubStudent>();
    }

//    the definition of a method to add a member to the Organization
    public void addMember(ClubStudent member) {
        if (linkedlist.size() == 0) {
            linkedlist.addFirst(member);
        }
        else {
            linkedlist.add(member);
        }
    }

//    a membership method, to examine whether a certain student is a member of the Organization
    public boolean isMember(ClubStudent member) {
        return (linkedlist.contains(member) == true) ? true : false;
    }

//    a method to remove all graduating students upon their graduation
    public void removeGrads(int year) {
        for (int i = 0; i < linkedlist.size() - 1; i++) {
            if (linkedlist.get(i).getYear() > year) {
                try {
                    linkedlist.remove(i);
                }
                catch (ArrayIndexOutOfBoundsException exception) {
                    System.out.println("No more graduated students in club");
                }
            }
        }
    }

//    a method to figure out the common members between two certain organizations
//    public ClubStudent checkCommon(ClubStudent member1, ClubStudent member2) {
//    }

//    the definition of the toString() method to provide for a reasonable string representation of a Student Organization
    public String toString() {
        return "The " + orgName + " has " + linkedlist.size() + " members. The President is " +
                pres + " and the Vice President is " + vpres;
    }

    public static void main(String[] args) {
        StudentOrganization so1 = new StudentOrganization("Chess club");
        ClubStudent cs1 = new ClubStudent("Jon", "jn", 1990, 1989, "Chess club");
        so1.addMember(cs1);
        System.out.println(so1);
    }
}
