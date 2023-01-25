/**
 * @author user7455602
 */

// Based off my project 3, but modified for 2 players

import java.util.*;
import java.io.*;

public class TicTacToe extends TwoPlayerGame{

  private int totalRounds = 3;

  public void playGame(){
    System.out.printf("%s & %s play TicTacToe!\n\n",
                      getPlayer1().getName(), getPlayer2().getName());
    for (int round = 0; round < totalRounds; round++) {

    System.out.printf("\n\nRound %d BEGINS!\n\n", round+1);
      
        playRound();
    }
    

  }

  private void playRound(){
        Scanner scanner = new Scanner(System.in);
        TicTacToeBoard game = new TicTacToeBoard();

        // set current player
        Player currentPlayer = getNextPlayer();

        //turn loop
        while (true) {
            System.out.println(game.getBoard());
            System.out.printf(
                    "%s, it is your turn.\nEnter a number (1 to 9) to place your %s\n",
                    currentPlayer.getName(),
                    game.getCurrentPiece());
            String input = scanner.nextLine();

            int numSelected = -1;

            try {
                numSelected = Integer.parseInt(input); // try to convert to an int
            } catch (NumberFormatException e) {
                //numSelected = -1; // can't, so we make it -1 and let default handle it
            }

            // handle human turn
            TicTacToeStatus status = game.takeTurn(numSelected);
            if (status == TicTacToeStatus.WIN) {
                System.out.printf("\n%s\n %s WINS!\n", game.getBoard(), currentPlayer.getName());
                currentPlayer.addPoints(2); // 2 points for a win
                break;
            } else if (status == TicTacToeStatus.TIE) {
                System.out.println(game.getBoard());
                System.out.printf("\n%s\nIt is a TIE!\n", game.getBoard());
                // 1 point for each in a tie
                getPlayer1().addPoints(1);
                getPlayer2().addPoints(1);
                break;
            } else if (status == TicTacToeStatus.ERROR) {
                System.out.printf("\nInvalid choice!\n");
            } else if (status == TicTacToeStatus.PLAYABLE) {
                currentPlayer = getNextPlayer();
            }

        }


  }
  
  public void printInstructions(){
    System.out.println("TicTacToe!");
    System.out.println("Welcome to TicTacToe. You will recieve 2 points for every game you win!\n Tie is one point each.\n The order is picked randomly.");
  }

  public TicTacToe(Player player1, Player player2){
    super(player1, player2);
  }
}