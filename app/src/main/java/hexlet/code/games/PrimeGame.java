package hexlet.code.games;

import hexlet.code.Utils;
import hexlet.code.Engine;

public class PrimeGame {
    private static final int UPPER_BOUND = 100;
    private static final String TASK = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

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

    public static String[][] getQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_ROUNDS][2];
        for (int i = 0; i < Engine.NUMBER_OF_ROUNDS; i++) {
            var questionsAndAnswersPair = new String[2];
            int question = Utils.getRandomInt(UPPER_BOUND);
            questionsAndAnswersPair[0] = String.valueOf(question);
            boolean primeOrNot = isPrime(question);
            if (primeOrNot) {
                questionsAndAnswersPair[1] = "yes";
            } else {
                questionsAndAnswersPair[1] = "no";
            }
            questionsAndAnswers[i] = questionsAndAnswersPair;
        }
        return questionsAndAnswers;
    }

    public static void run() {
        Engine.run(getQuestionsAndAnswers(), TASK);
    }
}
