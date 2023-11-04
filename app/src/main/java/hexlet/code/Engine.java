package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    public static String greeting() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!"
                + "\nMay I have your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    public static void describeTask(String task) {
        System.out.println(task);
    }
    public static int random(int upLimit) {
        Random generator = new Random();
        return generator.nextInt(upLimit);
    }

    public static boolean getAnswerCheckResult(String rightAnswer) {
        boolean resultWin;
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();
        if (rightAnswer.equals(response)) {
            System.out.println("Correct!");
            resultWin = true;
        } else {
            System.out.println("'" + response + "' is wrong answer ;(. Correct answer was '" + rightAnswer + "'.");
            resultWin = false;
        }
        return resultWin;
    }
    public static void resulting(boolean win, String user) {
        if (win) {
            System.out.println("Congratulations, " + user + "!");
        } else {
            System.out.println("Let's try again, " + user + "!");
        }
    }
}
