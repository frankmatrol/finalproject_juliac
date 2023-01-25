/**
 * @author user7455602
 */

// let's us keep track of the correct answer after shuffling
public class TriviaOption {
  private boolean isAnswer;
  private String option;

  public TriviaOption(boolean isAnswer, String option) {
    this.isAnswer = isAnswer;
    this.option = option;
  }

  public boolean isAnswer() {
    return isAnswer;
  }

  public String getOption() {
    return option;
  }
}