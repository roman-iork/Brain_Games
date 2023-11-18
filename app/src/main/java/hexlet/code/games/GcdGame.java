package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class GcdGame {
    private static final Random GENERATOR = new Random();
    private static final int TO_AVOID_ZERO = 1;
    private static final int MAKE_HALF = 2;
    private static final int UPPER_BOUND = 100;
    private static final int NUMBER_OF_ROUNDS = 3;

    public static int[][] gettingNumbers() {
        int[][] pairs = new int[NUMBER_OF_ROUNDS][2];
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < 2; j++) {
                int number = GENERATOR.nextInt(UPPER_BOUND) + TO_AVOID_ZERO;
                pairs[i][j] = number;
            }
        }
        return pairs;
    }

    public static int[] calculatingGcd(int[][] numbers) {
        int[] gcdNumbers = new int[NUMBER_OF_ROUNDS];
        for (int i = 0; i < gcdNumbers.length; i++) {
            int first = numbers[i][0];
            int second = numbers[i][1];
            int minOfTwo = Math.min(first, second);
            int maxOfTwo = Math.max(first, second);
            int gcd = 0;
            int potentialGcd = minOfTwo;
            if (maxOfTwo % minOfTwo == 0) {
                gcd = minOfTwo;
            } else {
                potentialGcd = minOfTwo / MAKE_HALF;
            }
            while (gcd == 0) {
                if ((minOfTwo % potentialGcd == 0) & (maxOfTwo % potentialGcd == 0)) {
                    gcd = potentialGcd;
                    break;
                } else {
                    potentialGcd -= 1;
                }
            }
            gcdNumbers[i] = gcd;
        }
        return gcdNumbers;
    }

    public static void run() {
        String task = "Find the greatest common divisor of given numbers.";

        int[][] numbers = gettingNumbers();
        String[] questionsInString = new String[NUMBER_OF_ROUNDS];
        for (int i = 0; i < questionsInString.length; i++) {
            questionsInString[i] = numbers[i][0] + " " + numbers[i][1];
        }

        int[] rightAnswersInInteger = calculatingGcd(numbers);
        String[] rightAnswersInString = new String[NUMBER_OF_ROUNDS];
        for (int i = 0; i < rightAnswersInString.length; i++) {
            rightAnswersInString[i] = String.valueOf(rightAnswersInInteger[i]);
        }

        Engine.run(task, NUMBER_OF_ROUNDS, questionsInString, rightAnswersInString);
    }
}
