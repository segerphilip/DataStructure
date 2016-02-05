/** Simulates a Dice Poker game played between the computer and user. 
 * This class definition contains a main() method that assumes 
 * that the user enters a name and an integer in the command line, for example: 
 * java PlayDice Wendy 7
 * @author 		Philip Seger, Uyen Nguyen
 * @version     %I%, %G%
 */
 

public class DiceGame {
	
  /** Creates a game object that contains the variables associated with a game.
  */
  
  String name; // Dave is the default
  private int numRounds; // 5 rounds by default
  private int pwin; //round wins of the player
  private int cwin; //round wins of the computer

  public DiceGame() {
	// Your code here

  }
	
	

  /** Counts how many distinct values appear in the input array
  * and stores each count onto the diceResults array.
  * PRE-CONDITION: diceResults[] should have enough length 
  * to accomodate the values found in the input array.
  *
  * @param	input			the input array
  * @param	diceResults		holds the multiplicity of values found in input.
  *							Note that this is actually the output parameter
  */
  private void accumulateValues(int[] input, int[] diceResults) {
  
	// Your code here
	
  }
  
  /** Given an input array storing five dice values, 
   * determines the rank of the set of values 
   * @param input		the array with the five dice values
   * @return 			the rank: an integer between 0 and 6
   */
  private int getRank (int[] input) {
	
	// Your code here

      return 0;
  }
  


  /** Plays one round of the game: First the computer's turn, 
   * then the player's turn
   * @param name	the player's name
   * @return   0 if computer wins the round, 1 if player wins, 2 if a tie
  */
  private int playOneRound(String name) {
  
	// Your code here
  
	return 0;
	
  }
  


/**  Simulates the playing of numRounds of the Dice Poker game between 
 * HAL and player name, and prints the winner at the end
 * @param name			the player's name
 * @param numRounds		the number of rounds to play
*/
  public void playDiceGame (String name, int numRounds) {
   
    System.out.println("Good evening, " + name + ". Everything's running smoothly. And you?" + ".");
    System.out.println("I'm completely operational and all my circuits are functioning perfectly.");
	System.out.println("Would you like to play a game of Dice Poker? I play very well.");
 
	// Your code here
	
    // After all rounds played, determine the final winner of the game and print the results
    if (pwin>cwin) System.out.print("The game was won by "+ name + " with a score of " + pwin + " to " + cwin);
    else if (cwin>pwin) System.out.print("The game was won by the HAL with a score of " + cwin + " to " + pwin);
    else System.out.print("The game was tied with a score of " + cwin + " to " + pwin);

    System.out.println(" in " + numRounds + " rounds.");
    System.out.println("Thank you for a very enjoyable game!");

  }


/** Start the homework by reading this method. 
 */
  public static void main (String args[]) {
    	
	// Create an instance of a new game and play the rounds
	String name = (args.length >  0)? args[0] : "Dave";
	
	// 5 rounds by default
	int numRounds = (args.length >  1)? Integer.parseInt(args[1]) : 5;
    DiceGame game = new DiceGame(name, numRounds);
	game.playDiceGame(name, numRounds);
    
  }

}