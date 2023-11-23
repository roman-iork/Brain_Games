package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static void run(String task, int numberOfRounds, String[][] questionsAndAnswers) {
        Scanner scanner = new Scanner(System.in);
        //greeting
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        //print task
        System.out.println(task);
        //three rounds or fewer
        boolean win = true;
        for (int i = 0; i < numberOfRounds; i++) {
            String question = questionsAndAnswers[i][0];
            String rightAnswer = questionsAndAnswers[i][1];
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
