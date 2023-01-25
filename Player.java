/**
 * @author user7455602
 */

// A player class (in out case TournamentPlayer)
// must implemet this interface
// this is what each game class depends on

public interface Player {
  public String getName();

  public void addPoints(int points);
}