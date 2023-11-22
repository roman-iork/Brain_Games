package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static String name;
    private static boolean win = true;

    public static void run(String task, int numberOfRounds, String[] question, String[] rightAnswer) {
        //greeting
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        name = SCANNER.next();
        System.out.println("Hello, " + name + "!");
        //print task
        System.out.println(task);
        //three rounds or fewer
        for (int i = 0; i < numberOfRounds; i++) {
            //questioning
            System.out.println("Question: " + question[i]);
            //get answer
            System.out.print("Your answer: ");
            String answer = SCANNER.next();
            if (!answer.equals(rightAnswer[i])) {
                win = false;
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + rightAnswer[i] + "'.");
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
