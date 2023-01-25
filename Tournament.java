import java.util.ArrayList;

/**
 * @author user7455602
 */

// The Tournament class accepts 2 tournament players and
// add games to a list to be played

public class Tournament {
  TournamentPlayer player1;
  TournamentPlayer player2;

  ArrayList<Game> games;

  public Tournament(TournamentPlayer player1, TournamentPlayer player2) {
    // set the players for the tournament
    this.player1 = player1;
    this.player2 = player2;

    // create a list to hold the games
    games = new ArrayList<Game>();

    // create and add each game to this list
    // this is the order the games will be played
    games.add(new Memory(player1, player2));
    games.add(new TicTacToe(player1, player2));
    games.add(new Trivia(player1, player2));
    games.add(new RockPaperScissors(player1, player2));

  }

  public void playGames() {

    for (Game game : games) {
      // print the instructions (do we want to do this every time?)
      game.printInstructions();
      // play the game
      game.playGame();

      // outputs a status inbetween each game
      System.out.printf("\nLets have an update on the scores!\n\nScores:\n%s : %d\n%s : %d\n\n",
          player1.getName(),
          player1.getPoints(),
          player2.getName(),
          player2.getPoints());

    }
  }
}