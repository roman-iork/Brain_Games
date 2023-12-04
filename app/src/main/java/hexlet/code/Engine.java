package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int NUMBER_OF_ROUNDS = 3;

    public static void run(String[] questionAndAnswer, String task) {
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
            //String[] questionsAndAnswers = questionAndAnswer;
            String question = questionAndAnswer[0];
            String rightAnswer = questionAndAnswer[1];
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
