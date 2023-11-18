package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class PrimeGame {
    private static final Random GENERATOR = new Random();
    private static final int UPPER_BOUND = 100;
    private static final int MAKE_HALF = 2;
    private static final int NUMBER_OF_ROUNDS = 3;

    public static int[] gettingNumbers() {
        int[] numbersToAsk = new int[NUMBER_OF_ROUNDS];
        for (int i = 0; i < numbersToAsk.length; i++) {
            int number = GENERATOR.nextInt(UPPER_BOUND);
            numbersToAsk[i] = number;
        }
        return numbersToAsk;
    }

    public static boolean[] isPrime(int[] numbersToAsk) {
        boolean[] primeOrNotArray = new boolean[NUMBER_OF_ROUNDS];
        for (int i = 0; i < primeOrNotArray.length; i++) {
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
        String[] questionsInString = new String[NUMBER_OF_ROUNDS];
        for (int i = 0; i < questionsInString.length; i++) {
            questionsInString[i] = String.valueOf(questionsInIntegers[i]);
        }

        boolean[] rightAnswersInBoolean = isPrime(questionsInIntegers);
        String[] rightAnswersInString = new String[NUMBER_OF_ROUNDS];
        for (int i = 0; i < rightAnswersInString.length; i++) {
            if (rightAnswersInBoolean[i]) {
                rightAnswersInString[i] = "yes";
            } else {
                rightAnswersInString[i] = "no";
            }
        }

        Engine.run(task, NUMBER_OF_ROUNDS, questionsInString, rightAnswersInString);
    }
}
