package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

public class Engine {
    private static final int NUMBER_OF_ROUNDS = 3;

    public static String[] getQuestionAndAnswer(String game) {
        String[] questionsAndAnswers = new String[2];
        switch (game) {
            case "even":
                questionsAndAnswers = EvenGame.getQuestionAndAnswer();
                break;
            case "calc":
                questionsAndAnswers = CalcGame.getQuestionAndAnswer();
                break;
            case "gcd":
                questionsAndAnswers = GcdGame.getQuestionAndAnswer();
                break;
            case "prime":
                questionsAndAnswers = PrimeGame.getQuestionAndAnswer();
                break;
            case "progression":
                questionsAndAnswers = ProgressionGame.getQuestionAndAnswer();
                break;
            default:
                return null;
        }
        return questionsAndAnswers;
    }

    public static void run(String task, String game) {
        Scanner scanner = new Scanner(System.in);
        //greeting
        System.out.print("Welcome to the Brain Games!" + "\nMay I have your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        //print task
        System.out.println(task);
        //three rounds or fewer
        boolean win = true;
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            String[] questionsAndAnswers = getQuestionAndAnswer(game);
            String question = questionsAndAnswers[0];
            String rightAnswer = questionsAndAnswers[1];
            //questioning
            System.out.println("Question: " + question);
            //get answer
            System.out.print("Your answer: ");
            String answer = scanner.next();
            if (!answer.equals(rightAnswer)) {
                win = false;
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + rightAnswer + "'.");
                break;
            }
            System.out.println("Correct!");
        }
        //announcing result
        if (win) {
            System.out.println("Congratulations, " + name + "!");
        } else {
            System.out.println("Let's try again, " + name + "!");
        }
    }
}
