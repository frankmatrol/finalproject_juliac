import java.util.*;

/**
 * @author user7455602- Julia Canhoto
 */


/***
 * Memory Game
 * NOTE: I modified my project 2 game (memory) to be a class and
 * made it a 2 player game
 */

public class Memory extends TwoPlayerGame {

  ArrayList<Character> pieces;
  ArrayList<ArrayList<Character>> gameBoard;
  ArrayList<Character> matched;
  Player currentPlayer;

  public void playGame() {
    System.out.printf("%s & %s play Memory!\n\n",
        getPlayer1().getName(), getPlayer2().getName());

    Scanner scanner = new Scanner(System.in);
    boolean stopGame = false;
    int guessOne = 0;
    int guessTwo = 0;

    // loop till the player wins or quits
    while (!stopGame) {

      // print out the game board
      if (!printGameBoard(gameBoard, matched, guessOne, guessTwo)) {
        System.out.println("\n");
        printGameBoard(gameBoard, matched, -1, -1);
      } else {
        currentPlayer = getNextPlayer();
      }
      System.out.printf("\nMatched %s\n", matched);

      // check if we're done
      if (matched.size() == pieces.size()) {
        System.out.printf("\n\nYou got them all! You Win!\n");
        break;
      }

      // loop till we get good input or player quits
      while (true) {
        System.out.printf("\n%s, it is your turn.\n", currentPlayer.getName());
        // get a guess and check for quit
        System.out.printf("\nEnter first guess (1 - 16) or 'q' to quit :");
        String input1 = scanner.nextLine();
        if (input1.toUpperCase().compareTo("Q") == 0) {
          stopGame = true;
          break;
        }

        // get a guess and check for quit
        System.out.printf("\nEnter second guess (1 - 16) or 'q' to quit :");
        String input2 = scanner.nextLine();
        if (input2.toUpperCase().compareTo("Q") == 0) {
          stopGame = true;
          break;
        }

        // try to get 2 good guesses
        // break if we do, otherwise keep asking
        try {
          guessOne = Integer.parseInt(input1);
          guessTwo = Integer.parseInt(input2);
          if (guessOne > 0 && guessOne <= 16 &&
              guessTwo > 0 && guessTwo <= 16) {
            break;
          }
        } catch (Exception ex) {
          System.out.printf("\nInput error!\n%s\n", ex.getMessage());
          System.out.println("\n");
          printGameBoard(gameBoard, matched, -1, -1);
        }
        System.out.println("\nError: At least one of those numbers is <1 or >16, try again please.\n");
      }
    }
  }

  public void printInstructions() {
    System.out.println("Memory!");
    System.out.printf("\nThe game starts with a grid of cards with numbers up and symbols down. The \n" +
        "players pick 2 cards to be revealed at a time. If the two cards have the same \n" +
        "symbols, they are removed from the grid, otherwise they stay selectable with the\n" +
        "symbol face down again. The game is done once all the matches have been made.  \n" +
        "1 point for each match.\n\n");
  }

  public Memory(Player player1, Player player2) {
    super(player1, player2);

    pieces = new ArrayList<Character>(Set.of('@', '#', '$', '%', '&', '*', '=', '+'));
    gameBoard = getGameBoard(pieces);
    matched = new ArrayList<>();

  }

  /***
   * create a randomized game board based on pieces provided
   *
   * @param pieces
   * @return a 2d game board
   */
  private ArrayList<ArrayList<Character>> getGameBoard(ArrayList<Character> pieces) {
    int rowColumnSize = 4;

    // double the piecs and shuffle the order before we place on the game board
    ArrayList<Character> newPieces = new ArrayList<>();
    newPieces.addAll(pieces);
    newPieces.addAll(pieces);
    Collections.shuffle(newPieces);

    // this is the game board
    // add each piece as we make the 2d array
    ArrayList<ArrayList<Character>> gameBoard = new ArrayList<>();
    int index = 0;
    for (int row = 0; row < rowColumnSize; row++) {
      ArrayList<Character> pieceList = new ArrayList<>();
      for (int col = 0; col < rowColumnSize; col++) {
        pieceList.add(newPieces.get(index++));
      }
      gameBoard.add(pieceList);
    }

    return gameBoard;
  }

  /***
   * Print the game board and evaluation player moves
   *
   * @param gameBoard 2d game board
   * @param matched   list of already matched pieces
   * @param guessOne  player's first guess
   * @param guessTwo  player's second guess
   * @return true if no errors occured, false otherwise
   */

  private boolean printGameBoard(ArrayList<ArrayList<Character>> gameBoard, ArrayList<Character> matched, int guessOne,
      int guessTwo) {

    int spaceLabel = 1;
    Character guessOneContents = 0;
    Character guessTwoContents = 1;

    System.out.printf("\n\n\n");

    for (ArrayList<Character> row : gameBoard) {
      System.out.printf("+---+---+---+---+\n");
      for (Character ch : row) {
        if (matched.contains(ch)) {
          System.out.printf("| %-2c", ' ');
          if (guessOne == spaceLabel || guessTwo == spaceLabel) {
            System.out.printf("\nError! : Space was already matched.\n");
            return false;
          }
        } else {
          if (guessOne == spaceLabel) {
            System.out.printf("| %-2c", ch);
            guessOneContents = ch;
          } else if (guessTwo == spaceLabel) {
            System.out.printf("| %-2c", ch);
            guessTwoContents = ch;
          } else {
            System.out.printf("| %-2d", spaceLabel);
          }
        }
        spaceLabel++;
      }
      System.out.printf("|\n");
    }
    System.out.printf("+---+---+---+---+\n");

    if (guessOneContents == guessTwoContents) {
      matched.add(guessOneContents);
      System.out.printf("\n%s, you got a Match!\n", currentPlayer.getName());
      currentPlayer.addPoints(1);
      printGameBoard(gameBoard, matched, 0, 0);
    }
    return true;
  }

}