/**
 * @author user7455602
 */

import java.util.ArrayList;
import java.util.Collections;


public class TriviaQuestion {
  private String triviaQuestion;
  private String correctAnswerShortcut;

  private ArrayList<TriviaOption> triviaOptions = new ArrayList<>();

  
  public TriviaQuestion(String triviaQuestion, ArrayList<String> options) {
    this.triviaQuestion = triviaQuestion;

    // the first option is the correct one
    boolean firstAnswer = true;
    for(String optionString : options){
      TriviaOption option = new TriviaOption(firstAnswer, optionString);
      triviaOptions.add(option);
      
      if( firstAnswer ){
        firstAnswer = false;
        correctAnswerShortcut = optionString;
      }
      
    }
  }

  public boolean isCorrect(int selectedOption){
    System.out.printf("%s\n", triviaOptions.get(selectedOption).getOption());
    return triviaOptions.get(selectedOption).isAnswer();
  }

  public String getTriviaQuestion(){
    return triviaQuestion;
  }

  public String getCorrectAnswer(){
    return correctAnswerShortcut;
  }

  public ArrayList<String> getTriviaOptions(){
    Collections.shuffle(triviaOptions);

    // build a list of strings to return
    ArrayList<String> options = new ArrayList<>();

    for(TriviaOption option : triviaOptions) {
      options.add(option.getOption());
    }
    return options;
  }
  
}