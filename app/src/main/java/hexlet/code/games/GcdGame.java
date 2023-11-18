package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class GcdGame {
    private static final Random GENERATOR = new Random();
    private static final int TO_AVOID_ZERO = 1;
    private static final int MAKE_HALF = 2;
    private static final int UPPER_BOUND = 100;

    public static int[][] gettingNumbers() {
        int[][] pairs = new int[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                int number = GENERATOR.nextInt(UPPER_BOUND) + TO_AVOID_ZERO;
                pairs[i][j] = number;
            }
        }
        return pairs;
    }

    public static int[] calculatingGcd(int[][] numbers) {
        int[] gcdNumbers = new int[3];
        for (int i = 0; i < 3; i++) {
            int first = numbers[i][0];
            int second = numbers[i][1];
            int minOfTwo = first;
            int maxOfTwo = second;
            if (first > second) {
                minOfTwo = second;
                maxOfTwo = first;
            }
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
        String[] questionsInString = new String[3];
        for (int i = 0; i < 3; i++) {
            questionsInString[i] = numbers[i][0] + " " + numbers[i][1];
        }

        int[] rightAnswersInInteger = calculatingGcd(numbers);
        String[] rightAnswersInString = new String[3];
        for (int j = 0; j < 3; j++) {
            rightAnswersInString[j] = String.valueOf(rightAnswersInInteger[j]);
        }

        Engine.run(task, questionsInString, rightAnswersInString);
    }
}
