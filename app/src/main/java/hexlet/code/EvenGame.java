package hexlet.code;
import java.util.Scanner;
import java.util.Random;

public class EvenGame {
    public static int run() {
        Scanner scanner = new Scanner(System.in);
        Random generator = new Random();
        final int aiyayai = 0;
        final int allCorrect = 1;
        int numToAsk;
        String rightAnswer;
        String response;
        int result = allCorrect;
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < 3; i++) {
            numToAsk = generator.nextInt(100);
            System.out.println("Question: " + numToAsk);
            if (numToAsk % 2 == 0) {
                rightAnswer = "yes";
            } else {
                rightAnswer = "no";
            }
            System.out.print("Your answer: ");
            response = scanner.next();
            if (rightAnswer.equals(response)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + response + "' is wrong answer ;(. Correct answer was '" + rightAnswer + "'.");
                result = aiyayai;
                break;
            }
        }
        return result;
    }
}
