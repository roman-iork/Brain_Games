package hexlet.code.games;

import hexlet.code.Utils;
import hexlet.code.Engine;

public class PrimeGame {
    private static final int UPPER_BOUND = 100;
    private static final String TASK = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final String GAME = "prime";

    public static boolean isPrime(int number) {
        boolean numberIsPrime = true;
        int divider = number / 2;
        if ((number == 0) || (number == 1)) {
            numberIsPrime = false;
        }
        for (int i = divider; i > 1; i--) {
            if (number % i == 0) {
                numberIsPrime = false;
                break;
            }
        }
        return numberIsPrime;
    }

    public static String[] getQuestionAndAnswer() {
        var questionsAndAnswers = new String[2];
        int question = Utils.getRandomInt(UPPER_BOUND);
        questionsAndAnswers[0] = String.valueOf(question);
        boolean primeOrNot = isPrime(question);
        if (primeOrNot) {
            questionsAndAnswers[1] = "yes";
        } else {
            questionsAndAnswers[1] = "no";
        }
        return questionsAndAnswers;
    }

    public static void run() {
        Engine.run(TASK, GAME);
    }
}
