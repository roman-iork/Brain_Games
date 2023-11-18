package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class PrimeGame {
    private static final Random GENERATOR = new Random();
    private static final int UPPER_BOUND = 100;
    private static final int MAKE_HALF = 2;

    public static int[] gettingNumbers() {
        int[] numbersToAsk = new int[3];
        for (int i = 0; i < 3; i++) {
            int number = GENERATOR.nextInt(UPPER_BOUND);
            numbersToAsk[i] = number;
        }
        return numbersToAsk;
    }

    public static boolean[] isPrime(int[] numbersToAsk) {
        boolean[] primeOrNotArray = new boolean[3];
        for (int i = 0; i < 3; i++) {
            boolean primeOrNot = true;
            int numberToAsk = numbersToAsk[i];
            int divider = numberToAsk / MAKE_HALF;
            if ((numberToAsk == 0) || (numberToAsk == 1)) {
                primeOrNot = false;
            }
            for (int j = divider; j > 1; j--) {
                if (numberToAsk % j == 0) {
                    primeOrNot = false;
                    break;
                }
            }
            primeOrNotArray[i] = primeOrNot;
        }
        return primeOrNotArray;
    }

    public static void run() {
        String task = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        int[] questionsInIntegers = gettingNumbers();
        String[] questionsInString = new String[3];
        for (int i = 0; i < 3; i++) {
            questionsInString[i] = String.valueOf(questionsInIntegers[i]);
        }

        boolean[] rightAnswersInBoolean = isPrime(questionsInIntegers);
        String[] rightAnswersInString = new String[3];
        for (int j = 0; j < 3; j++) {
            if (rightAnswersInBoolean[j]) {
                rightAnswersInString[j] = "yes";
            } else {
                rightAnswersInString[j] = "no";
            }
        }

        Engine.run(task, questionsInString, rightAnswersInString);
    }
}
