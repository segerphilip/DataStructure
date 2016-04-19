/**
 * Created by philip on 4/19/16.
 */
public class MyGenealogy {
    public static void main(String[] args) {
        System.out.println("This is the genealogy tree in the universe Characters-are-the-names.");

        GenealogyTree<String> gt1 = new GenealogyTree<String>("T");
        gt1.setPater("T", "Y");
        gt1.setMater("T", "E");

        gt1.setPater("Y", "P");
        gt1.setMater("Y", "M");

        gt1.setPater("E", "B");
        gt1.setMater("E", "D");

        gt1.setPater("P", "A");
        gt1.setMater("P", "C");

        gt1.setPater("M", "F");
        gt1.setMater("M", "G");

        gt1.setPater("B", "H");
        gt1.setMater("B", "I");

        gt1.setPater("D", "J");
        gt1.setMater("D", "K");

        System.out.println(gt1);

        System.out.println();

        System.out.println("T was found: " + gt1.appears("T"));
        System.out.println("Offspring of Y is: " + gt1.getOffspring("Y"));
        System.out.println("The root is: " + gt1.getCoTU());
        System.out.println("P's father is: " + gt1.getPater("P"));
        System.out.println("P's mother is: " + gt1.getMater("P"));
        System.out.println("P and B are in-laws: " + gt1.inLaws("P", "B"));
        System.out.println("P and E are in-laws: " + gt1.inLaws("P", "E"));
    }
}
