/**
 * @author user7455602
 */

// TournamentPlayer implements the player interface but also adds
// a .getPoints() method so we can output a player's score in the Tournament
// class

public class TournamentPlayer implements Player {
  private String name;
  private int totalPoints;

  public TournamentPlayer(String name) {
    this.name = name;
    totalPoints = 0;
  }

  public String getName() {
    return name;
  }

  public void addPoints(int points) {
    this.totalPoints += points;
  }

  public int getPoints() {
    return totalPoints;
  }
}