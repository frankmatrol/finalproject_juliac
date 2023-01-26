/**
 * @author user7455602 - Julia Canhoto
 */


/***
 * A player class (in our case TournamentPlayer)
 * must implement this interface
 * this is what each game class depends on
 */
public interface Player {
  public String getName();

  public void addPoints(int points);
}