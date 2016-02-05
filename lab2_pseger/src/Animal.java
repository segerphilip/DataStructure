/**
 * Created by philip on 2/4/16.
 */
public class Animal {
    private String type;
    private String name;
    private String voice;
    private boolean canFly;
    private int number_legs;

    public Animal (String type, String name, String voice, boolean canFly, int number_legs) {
        this.type = type;
        this.name = name;
        this.voice = voice;
        this.canFly = canFly;
        this.number_legs = number_legs;
    }

    public String toString() {

    }


    public static void main(String[] args) {
        Animal doggy = new Animal("dog", "Rover", "bark", false, 4);
        Animal deer  = new Animal("reindeer", "Rudolph", "hi", true, 4);
    }
}
