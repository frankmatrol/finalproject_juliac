/**
 * @author user7455602
 */

import java.util.Scanner;
import java.util.*;
import java.io.*;
class Main {
  
  /**
   * Main will accept the player names for player1 and player2
   * and set them into the new Tournament.
   * Then will play the games and outout the results.
   * 
   */  
  public static void main(String[] args) {
    System.out.println("Welcome to the Mini-Games Tournament!\n");

    // input names for players
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter name for player 1:");
    String input = scanner.nextLine();
    TournamentPlayer player1 = new TournamentPlayer(input);

    System.out.println("Enter name for player 2:");
    input = scanner.nextLine();
    TournamentPlayer player2 = new TournamentPlayer(input);

    //create a tournament with the players and play all the games
    Tournament myTournament = new Tournament(player1, player2);
    myTournament.playGames();

    // the tounament is over, output the scores and the results
    System.out.printf("\nThe tournament is over!\n\nScores:\n%s : %d\n%s : %d\n", 
                     player1.getName(),
                     player1.getPoints(),
                     player2.getName(),
                     player2.getPoints()
                     );

    if(player1.getPoints() == player2.getPoints()){
      System.out.println("It's a tie!");
    } else {
      String winner = player1.getName();
      if (player2.getPoints() > player1.getPoints()){
        winner = player2.getName();
      } 
      System.out.printf("\n%s wins!\n", winner);
    }
  

    
  }
}