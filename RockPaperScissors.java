import java.util.Random;
import java.util.Scanner;

/**
 * @author user7455602
 */

/***
 * the Rock Paper Scissors game
 * Modified to a class from my project 1
 * and changed to support 2 players
 */
public class RockPaperScissors extends TwoPlayerGame {

  private String rock = "rock";
  private String paper = "paper";
  private String scissors = "scissors";

  private int numberOfOptions = 3;
  private int totalRounds = 2;
  private String[] options = { "NotUsed", rock, paper, scissors };

  // Constructor
  public RockPaperScissors(Player player1, Player player2) {
    // set the player1 and player2 into the class
    // we're extending (TwoPlayerGame)
    super(player1, player2);
  }


  // play the game
  public void playGame() {
    Scanner scanner = new Scanner(System.in);

    System.out.printf("%s & %s play Rock Paper Scissors!\n\n",
        getPlayer1().getName(), getPlayer2().getName());

    // default to bad input
    int num = -1;

    // get the first player to play
    Player currentPlayer = getNextPlayer();

    // play the rounds
    for (int round = 0; round < totalRounds * 2; round++) {
      // loop with current player till valid
      // selection is made
      while (true) {
        // get the player's choice
        System.out.printf(
            "\n%s's turn.\n1=%s, 2=%s, or 3=%s? : ",
            currentPlayer.getName(),
            options[1],
            options[2],
            options[3]);

        String input = scanner.nextLine();
        try {
          num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
          num = -1;
        }

        int result = playSelection(num);
        if (result >= 0) {
          // display message and add points
          currentPlayer.addPoints(result);
          System.out.printf("%s gets %d points.\n\n", currentPlayer.getName(), result);
          currentPlayer = getNextPlayer();
          break;
        } else {
          System.out.printf("\n");
        }
      }
    }
  }

  // evalulate the player's selection
  private int playSelection(int num) {
    switch (num) {
      case 1, 2, 3: // the only valid options
        String computerPick = options[getComputerPick(numberOfOptions)];
        String humanPick = options[num];
        System.out.printf("You picked %s, computer picked %s.\n", humanPick, computerPick);

        if (humanPick.equals(computerPick)) {
          System.out.println("It is a tie!");
          return 1; // 1 point for a tie
        } else if (humanPick.equals(rock) && computerPick.equals(scissors) ||
            humanPick.equals(paper) && computerPick.equals(rock) ||
            humanPick.equals(scissors) && computerPick.equals(paper)) {
          System.out.println("You Win!");
          return 2; // 2 points for a win
        } else {
          System.out.println("Computer Wins!");
          return 0; // no points
        }
      default: // everything else is bad
        System.out.println("Error. Try again.");
        return -1;
    }
  }

  // get computer's random pick
  private int getComputerPick(int options) {
    Random random = new Random();
    return random.nextInt(options) + 1;
  }

  // display instructions
  public void printInstructions() {
    System.out.println("Rock Paper Scissors!");
    System.out.println(
        "Welcome to Rock Paper Scissors. rock = 1, paper =2, scissors = 3!\nYou will recieve 2 points for every game you win! The order is picked randomly. \nPlayers take turns against the computer");
  }

}