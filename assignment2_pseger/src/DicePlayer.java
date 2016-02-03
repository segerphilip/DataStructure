/** CODE TEMPLATE
* Creates the "hand" of a player by creating an object of 5 random dice
* @author 		Philip Seger, Uyen Nguyen
* @version     %I%, %G%
*/


public class DicePlayer {

final private int hand = 5;
private Die FiveDice = new Die();
private int[] player = new int[hand];
	
    /** Constructor: Creates a player's hand by creating and rolling dice. 
     */   
	public DicePlayer() {
//        create the player that is playing
         for (int i = 0; i < hand; i++) {
             FiveDice.roll();
             this.player[i] = FiveDice.getFaceValue();
         }
	}

    /** Prints the contents of the hand that a player holds.
    */
	public String toString()  {
	    String s = "";
        for (int i = 0; i < this.player.length; i++) {
            s.concat(Integer.toString(this.player[i]));
        }
	    return  s;
	}

    /** Returns an array the contents of the hand that a player holds.
     * @return integer array of @param hand values corresponding to dice
    */
    public int[] getValues() {
        int [] values = new int[hand];
        for (int i = 0; i < this.player.length; i++) {
            values[i] = this.player[i];
//            System.out.println(values[i]);
        }
        System.out.println(values.toString());
        return values;
    }


  /** Testing method.
  */
  public static void main (String args[]) {

	DicePlayer hal = new DicePlayer();
	System.out.println("Hal rolled " + hal);
	DicePlayer dave = new DicePlayer();
	System.out.println("Dave rolled " + dave);

	
  }
}
