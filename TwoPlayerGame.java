import java.util.ArrayList;
import java.util.Collections;

/**
 * @author user7455602
 */

// TwoPlayerGame implements the game interface but also has
// two players defined and set via its constructor.
// This class is abstract, as it is only meant to be extended
// by actual game classes.

public abstract class TwoPlayerGame implements Game {

  private Player player1;
  private Player player2;

  private int currentIndex;

  // store players in a list
  private ArrayList<Player> players = new ArrayList<>();

  public TwoPlayerGame(Player player1, Player player2) {
    this.player1 = player1;
    this.player2 = player2;

    players.add(this.player1);
    players.add(this.player2);
    Collections.shuffle(players);
    currentIndex = 0;
  }

  // always return the other player
  public Player getNextPlayer() {
    return players.get(currentIndex++ % players.size());
  }

  // we will use these get methods so we can call
  // getName() and addPoints() functions from
  // our games
  // (like TicTacToe or trivia or poker etc)
  public Player getPlayer1() {
    return this.player1;
  }

  public Player getPlayer2() {
    return this.player2;
  }
}