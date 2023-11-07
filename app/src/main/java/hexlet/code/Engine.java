package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static String greetingAndTask(String task) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!"
                + "\nMay I have your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        System.out.println(task);
        return name;
    }

    public static boolean run(String expressionToAsk, String rightAnswer) {
        //Questioning
        System.out.println("Question: " + expressionToAsk);
        //Receiving the answer
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();
        //Comparing
        boolean resultWin;
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
