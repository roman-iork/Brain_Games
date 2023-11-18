package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class EvenGame {
    private static final Random GENERATOR = new Random();
    private static final int UPPER_BOUND = 100;

    public static int[] gettingNumbers() {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = GENERATOR.nextInt(UPPER_BOUND);
        }
        return numbers;
    }

    public static boolean[] isEven(int[] numbers) {
        boolean[] evenOrOdd = new boolean[3];
        for (int j = 0; j < 3; j++) {
            if (numbers[j] % 2 == 0) {
                evenOrOdd[j] = true;
            }
        }
        return evenOrOdd;
    }

    public static void run() {
        String task = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        int[] questionsInNumbers = gettingNumbers();
        String[] questionsInString = new String[3];
        for (int k = 0; k < 3; k++) {
            questionsInString[k] = String.valueOf(questionsInNumbers[k]);
        }

        boolean[] rightAnswersInBoolean = isEven(questionsInNumbers);
        String[] rightAnswersInStrings = new String[3];
        for (int l = 0; l < 3; l++) {
            if (rightAnswersInBoolean[l]) {
                rightAnswersInStrings[l] = "yes";
            } else {
                rightAnswersInStrings[l] = "no";
            }
        }

        Engine.run(task, questionsInString, rightAnswersInStrings);
    }
}
