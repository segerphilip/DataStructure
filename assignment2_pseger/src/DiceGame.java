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
  
  private String name; // Dave is the default
  private int numRounds; // 5 rounds by default
  private int pwin; //round wins of the player
  private int cwin; //round wins of the computer

  public DiceGame(String name, int numRounds) {
    this.name = name;
    this.numRounds = numRounds;
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
      for (int i = 0; i < diceResults.length - 1; i++) {
          if (input[i] == 1) {
              diceResults[0]++;
          }
          else if (input[i] == 2) {
              diceResults[1]++;
          }
          else if (input[i] == 3) {
              diceResults[2]++;
          }
          else if (input[i] == 4) {
              diceResults[3]++;
          }
          else if (input[i] == 5) {
              diceResults[4]++;
          }
          else if (input[i] == 6) {
              diceResults[5]++;
          }
      }
  }
  
  /** Given an input array storing five dice values, 
   * determines the rank of the set of values 
   * @param input		the array with the five dice values
   * @return 			the rank: an integer between 0 and 6
   */
  private int getRank (int[] input) {
      int rank = 0;
      int[] diceResults = new int[input.length + 1];
      for (int i = 0; i < input.length; i++) {
          diceResults[i] = input[i];
      }
      accumulateValues(input, diceResults);
      for (int i = 0; i < diceResults.length; i++) {
          if (diceResults[i] == 5) {
              rank = 6;
          }
          else if (diceResults[i] == 4) {
              rank = 5;
          }
          else if (diceResults[i] == 3) {
              for (int j = 0; j < diceResults.length; j++) {
                  if (diceResults[j] == 2) {
                      rank = 4;
                  }
              }
              rank = 3;
          }
          else if (diceResults[i] == 2) {
              for (int j = 0; j < diceResults.length; j++) {
                  if (diceResults[j] == 2) {
                      rank = 2;
                  }
              }
              rank = 1;
          }
      }
      return rank;
  }
  


  /** Plays one round of the game: First the computer's turn, 
   * then the player's turn
   * @param name	the player's name
   * @return   0 if computer wins the round, 1 if player wins, 2 if a tie
  */
  private int playOneRound(String name) {
      int rank = 0;
      DicePlayer hal = new DicePlayer();
      DicePlayer dave = new DicePlayer();
      int rank1 = getRank(hal.getValues());
      int rank2 = getRank(dave.getValues());

      System.out.println("HAL: " + hal.toString() + " Rank: " + rank1);
      System.out.println(name + ": " + dave.toString() + " Rank: " + rank2);

      if (rank1 > rank2) {
          cwin += 1;
      }
      else if (rank1 == rank2) {
          rank = rank1;
      }
      else {
          pwin += 1;
      }

      return rank;
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

      for (int i = 1; i < numRounds + 1; i++) {
          System.out.println("\n*** Round " + i);
          playOneRound(name);
      }

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
