import java.util.*;

/**
 * @author user7455602
 */

public class Trivia extends TwoPlayerGame {

  ArrayList<TriviaQuestion> questions = new ArrayList<>();

  public void playGame() {
    addQuestions();

    Scanner scanner = new Scanner(System.in);

    System.out.printf("%s & %s play Trivia!\n\n",
        getPlayer1().getName(), getPlayer2().getName());

    Player currentPlayer = getNextPlayer();

    // output the question and possible answers
    for (TriviaQuestion question : questions) {
      System.out.printf("\n%s, here is your question:\n\n", currentPlayer.getName());
      System.out.printf("%s?\n\n", question.getTriviaQuestion());

      // we'll number the answers so the user can pick
      int num = 1;
      for (String option : question.getTriviaOptions()) {
        System.out.printf("%d : %s\n", num++, option);
      }

      int guess = -1;

      while (true) {

        // get the player's guess
        System.out.printf("Enter number for your guess:\n");
        String input = scanner.nextLine();

        try {
          guess = Integer.parseInt(input);
        } catch (NumberFormatException e) {
          guess = -1;
        }

        // if guess is bad
        if (guess > 0 && guess <= 4) {
          // check the players guess and add points
          if (question.isCorrect(guess - 1)) {
            System.out.printf("%s, you're RIGHT!\n", currentPlayer.getName());
            currentPlayer.addPoints(1);
          } else {
            System.out.printf("%s, ah too bad, you got it wrong..\n", currentPlayer.getName());
            System.out.printf("The correct answer is:\n%s\n", question.getCorrectAnswer());
          }
          break;
        } else {
          System.out.printf("Bad input.  Try again\n");
        }

        System.out.printf("\n\n");
      }

      currentPlayer = getNextPlayer();
    }

  }

  public void printInstructions() {
    System.out.println("Trivia!");
    System.out.println("Welcome to Trivia. Pick the right answer, get 1 point! The order is picked randomly.");
  }

  public Trivia(Player player1, Player player2) {
    super(player1, player2);
    // addQuestions();
  }

  // question list
  private void addQuestions() {
    questions.clear();

    { // add a question 1
      String question = "What year was the first model of the Iphone released?";
      ArrayList<String> options = new ArrayList<>(Arrays.asList(
          "2007",
          "2002",
          "2010",
          "2013"));
      questions.add(new TriviaQuestion(question, options));
    } // end question

    { // add a question 2
      String question = "What is the largest planet in our solar system?";
      ArrayList<String> options = new ArrayList<>(Arrays.asList(
          "Jupiter",
          "Uranus",
          "Mars",
          "The Sun"));
      questions.add(new TriviaQuestion(question, options));
    } // end question

    { // add a question 3
      String question = "Which country produces the most coffee beans?";
      ArrayList<String> options = new ArrayList<>(Arrays.asList(
          "Brazil",
          "Columbia",
          "Vietnam",
          "Cuba"));
      questions.add(new TriviaQuestion(question, options));
    } // end question

    { // add a question 4
      String question = "What is your body's largest organ?";
      ArrayList<String> options = new ArrayList<>(Arrays.asList(
          "Skin",
          "Brain",
          "Lungs",
          "Liver"));
      questions.add(new TriviaQuestion(question, options));
    } // end question

    { // add a question 5
      String question = "What is the fastest animal in the world?";
      ArrayList<String> options = new ArrayList<>(Arrays.asList(
          "Peregrine Falcon",
          "Ostrich",
          "Dolphin",
          "Cheetah"));
      questions.add(new TriviaQuestion(question, options));
    } // end question

    { // add a question 6
      String question = "What is the speed of light?";
      ArrayList<String> options = new ArrayList<>(Arrays.asList(
          "2.99x10^8 m/s",
          "3x10^8 m/s",
          "1 000 000 000 m/s",
          "399 m/s"));
      questions.add(new TriviaQuestion(question, options));
    } // end question

    { // add a question 7
      String question = "What is the largest continent on the planet?";
      ArrayList<String> options = new ArrayList<>(Arrays.asList(
          "Asia",
          "North America",
          "South America",
          "Antarctica"));
      questions.add(new TriviaQuestion(question, options));
    } // end question

    { // add a question 8
      String question = "What animal has the longest life span?";
      ArrayList<String> options = new ArrayList<>(Arrays.asList(
          "Giant Tortoise",
          "Boreal Owl",
          "Borneo Elephant",
          "Rougheye Rockfish"));
      questions.add(new TriviaQuestion(question, options));
    } // end question

    { // add a question 9
      String question = "How many teeth should an adult human have?";
      ArrayList<String> options = new ArrayList<>(Arrays.asList(
          "32",
          "40",
          "28",
          "36"));
      questions.add(new TriviaQuestion(question, options));
    } // end question

    { // add a question 10
      String question = "How many elements are on the periodic table?";
      ArrayList<String> options = new ArrayList<>(Arrays.asList(
          "118",
          "217",
          "103",
          "146"));
      questions.add(new TriviaQuestion(question, options));
    } // end question

    { // add a question 11
      String question = "What is the chemical compound symbol for hydrochloric acid?";
      ArrayList<String> options = new ArrayList<>(Arrays.asList(
          "HCl",
          "HClO",
          "HOCl",
          "ClO"));
      questions.add(new TriviaQuestion(question, options));
    } // end question

    { // add a question 12
      String question = "What colour is a giraffes tongue?";
      ArrayList<String> options = new ArrayList<>(Arrays.asList(
          "purple",
          "red",
          "blue",
          "orange"));
      questions.add(new TriviaQuestion(question, options));
    } // end question

    { // add a question 13
      String question = "How many bones does a shark have?";
      ArrayList<String> options = new ArrayList<>(Arrays.asList(
          "0",
          "84",
          "43",
          "217"));
      questions.add(new TriviaQuestion(question, options));
    } // end question

    { // add a question 14
      String question = "How many time zones are there in Russia?";
      ArrayList<String> options = new ArrayList<>(Arrays.asList(
          "11",
          "7",
          "12",
          "14"));
      questions.add(new TriviaQuestion(question, options));
    } // end question

    { // add a question 15
      String question = "What country invented tea?";
      ArrayList<String> options = new ArrayList<>(Arrays.asList(
          "China",
          "Berlin",
          "United Kingdom",
          "Ireland"));
      questions.add(new TriviaQuestion(question, options));
    } // end question

    { // add a question 16
      String question = "What is the deadliest mammal?";
      ArrayList<String> options = new ArrayList<>(Arrays.asList(
          "Hippo",
          "Box Jellyfish",
          "Scorpions",
          "Crocodiles"));
      questions.add(new TriviaQuestion(question, options));
    } // end question

    Collections.shuffle(questions);
  }
}