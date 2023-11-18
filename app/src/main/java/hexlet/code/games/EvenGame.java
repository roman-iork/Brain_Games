package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class EvenGame {
    private static final Random GENERATOR = new Random();
    private static final int UPPER_BOUND = 100;
    private static final int NUMBER_OF_ROUNDS = 3;

    public static int[] gettingNumbers() {
        int[] numbers = new int[NUMBER_OF_ROUNDS];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = GENERATOR.nextInt(UPPER_BOUND);
        }
        return numbers;
    }

    public static boolean[] isEven(int[] numbers) {
        boolean[] evenOrOdd = new boolean[NUMBER_OF_ROUNDS];
        for (int i = 0; i < evenOrOdd.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenOrOdd[i] = true;
            }
        }
        return evenOrOdd;
    }

    public static void run() {
        String task = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        int[] questionsInNumbers = gettingNumbers();
        String[] questionsInString = new String[NUMBER_OF_ROUNDS];
        for (int i = 0; i < questionsInString.length; i++) {
            questionsInString[i] = String.valueOf(questionsInNumbers[i]);
        }

        boolean[] rightAnswersInBoolean = isEven(questionsInNumbers);
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
