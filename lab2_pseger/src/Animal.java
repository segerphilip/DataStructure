/**
 * Created by philip on 2/4/16.
 */

import java.util.Scanner; 

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
    
    public Animal (String type, String name) { 
      this.type = type;
      this.name = name;
      this.voice = "";
      this.canFly = false;
      this.number_legs = 4;
    }
    
    public String getType() {
      return type;
    }
    
    public void setType(String value) {
      this.type = value;
    }
    
    public String getName() {
      return name;
    }
    
    public void setName(String value) {
      this.name = value; 
    }
    
    public String getVoice() {
      return voice;
    }
    
    public void setVoice(String value) { 
      this.voice = value; 
    }
    
    public boolean getCanFly() {
      return canFly;
    }
    
    public void setCanFly(boolean value) { 
      this.canFly = value; 
    }
    
    public int getNumber_legs() {
      return number_legs;
    }
    
    public void setNumber_legs(int value) {
      this.number_legs = value; 
    }
    
    public void tookFlyingLessons() {
      this.canFly = true;
    }
    
    public void caughtLaryngitis() {
      this.voice = "";
    }
    
    public void likesToImitateCats() {
      this.voice = "meow";
    }
    
    public void speak() {
      for (int i = 0; i < 3; i++) {
        System.out.print(voice + " ");
      }
    }
    
    public String conversation(Animal a2) {
      String conver = "A conversation between " + name + " and " + 
        a2.getName() + ":\n";
      for (int i = 0; i < 2; i++) {
        conver = conver + voice + "\n";
        conver = conver + a2.getVoice() + "\n";
      } 
      return conver;
    }

    public String toString() {
      return (name + " is a " + type + " with " + number_legs + 
              " legs that can" + (canFly ? "" : "not") + " fly and that says " + voice);
    }
    
    public static Animal readAndCreateAnimal() {
      Scanner scan = new Scanner(System.in);
      System.out.println("Please enter the type of animal:");
      String type = scan.nextLine();
      System.out.println("Please enter the name of the animal:");
      String name = scan.nextLine();
      System.out.println("What does the animal say?");
      String voice = scan.nextLine();
      System.out.println("Can the animal fly? (true/false)");
      boolean canFly = scan.nextBoolean();
      System.out.println("How many legs does the animal have?");
      int number_legs = scan.nextInt();
      
      Animal aNew = new Animal(type, name, voice, canFly, number_legs);
      
      return aNew;
    }

    public static void main(String[] args) {
        Animal doggy = new Animal("dog", "Rover", "bark", false, 4);
        Animal deer  = new Animal("reindeer", "Rudolph", "hi", true, 4);
        System.out.println(doggy);
        testing();
        readAndCreateAnimal();
    }
    
//    testing method
    public static void testing() {
      Animal duck1 =  new Animal("duck","daffy","quack",true,2);
      Animal spidey =  new Animal("spider","charlotte", " ",false,8);
      Animal froggy = new Animal("frog","bill","ribbit",false,4);
      System.out.println(duck1.getType());   // duck 
      System.out.println(duck1.getName());   // daffy 
      System.out.println(duck1.getVoice());  // quack 
      System.out.println(duck1.getCanFly()); // true
      System.out.println(duck1.getNumber_legs()); // 2 
      System.out.println(froggy);
      //bill is a frog with 4 legs that cannot fly that says ribbitt
      System.out.println(froggy.getType());   // frog 
      froggy.setType("prince");
      System.out.println(froggy.getType());  // prince 
      froggy.setNumber_legs(2); 
      froggy.setName("Charming");
      System.out.println(froggy);
      //Charming is a prince with 2 legs that cannot fly that says ribbitt
      System.out.println(spidey);
      //Charlotte is a spider with 8 legs that cannot fly that says 
      
      Animal a1 = new Animal("dog","lassie","ruff",false,4);
      Animal a2 = new Animal("cow","helga","moooo",false,4);
      System.out.println(a1.conversation(a2));
      a1.setVoice("everyone dance!");
      System.out.println(a1.conversation(a2));
      
      Animal a3 = new Animal("dog","lassie");
      System.out.println(a3);
      // lassie is a dog with 4 legs that cannot fly that says 

      Animal a4 = new Animal("eagle","ralph");
      System.out.println(a4);
      // ralph is a eagle with 4 legs that cannot fly that says
    }
}