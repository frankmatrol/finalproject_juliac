/**
 * @user7455602
 */

// Based off my project 3, but modified for 2 players

/***
 * the TicTacToeBoard Class
 */
public class TicTacToeBoard {

  // default board
  private final Character[] freshBoard = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

  // active play board
  private Character[] activeGame;

  // help with tie
  private int moveCounter;

  private TicTacToePiece currentPiece;

  /***
   * constructor
   */
  public TicTacToeBoard() {
    resetGame();
  }

  /***
   * reset the game
   */
  public void resetGame() {
    activeGame = freshBoard.clone();
    moveCounter = 0;
    currentPiece = TicTacToePiece.X; // X is always 1st!
  }

  /***
   * human's turn selection
   *
   * @param space
   * @return GameStatus
   */
  public TicTacToeStatus takeTurn(int space) {
    if (space < 1 || space > 9) {
      return TicTacToeStatus.ERROR;
    }

    TicTacToeStatus status = checkBoard();

    if (status == TicTacToeStatus.PLAYABLE) {
      status = placePiece(getCurrentPiece(), space);
      if (TicTacToeStatus.WIN == status) {
        return TicTacToeStatus.WIN;
      }
      if (status == TicTacToeStatus.PLAYABLE) {
        currentPiece = getCurrentPiece() == TicTacToePiece.X ? TicTacToePiece.O : TicTacToePiece.X;
      }
    }
    return status;
  }

  /***
   * returns the game board
   */
  public String getBoard() {
    return String.format(
        "\n%s|%s|%s\n-+-+-\n%s|%s|%s\n-+-+-\n%s|%s|%s",
        activeGame[0], activeGame[1], activeGame[2],
        activeGame[3], activeGame[4], activeGame[5],
        activeGame[6], activeGame[7], activeGame[8]);
  }

  private TicTacToeStatus checkBoard() {
    if ((activeGame[0] == activeGame[1] && activeGame[1] == activeGame[2]) ||
        (activeGame[3] == activeGame[4] && activeGame[4] == activeGame[5]) ||
        (activeGame[6] == activeGame[7] && activeGame[7] == activeGame[8]) ||
        (activeGame[0] == activeGame[3] && activeGame[3] == activeGame[6]) ||
        (activeGame[1] == activeGame[4] && activeGame[4] == activeGame[7]) ||
        (activeGame[2] == activeGame[5] && activeGame[5] == activeGame[8]) ||
        (activeGame[2] == activeGame[4] && activeGame[4] == activeGame[6]) ||
        (activeGame[0] == activeGame[4] && activeGame[4] == activeGame[8])) {
      return TicTacToeStatus.WIN;
    } else if (moveCounter >= 9) {
      return TicTacToeStatus.TIE;
    }
    return TicTacToeStatus.PLAYABLE;
  }

  private TicTacToeStatus placePiece(TicTacToePiece piece, int space) {
    if (Character.isDigit(activeGame[space - 1])) {
      activeGame[space - 1] = piece.toString().charAt(0);
      moveCounter++;
      return checkBoard();
    }
    return TicTacToeStatus.ERROR;
  }

  public TicTacToePiece getCurrentPiece() {
    return currentPiece;
  }
}