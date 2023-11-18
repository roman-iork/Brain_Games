package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class CalcGame {
    private static final Random GENERATOR = new Random();
    private static final int UPPER_BOUND = 100;
    private static final int REQUIRED_UPPER_BOUND = 3;

    public static int[] gettingNumbers() {
        int[] numbers = new int[6];
        for (int i = 0; i < 6; i++) {
            numbers[i] = GENERATOR.nextInt(UPPER_BOUND);
        }
        return numbers;
    }

    public static char[] gettingOperators() {
        char[] operatorsToChose = {'+', '-', '*'};
        char[] operators = new char[3];
        for (int j = 0; j < 3; j++) {
            operators[j] = operatorsToChose[GENERATOR.nextInt(REQUIRED_UPPER_BOUND)];
        }
        return operators;
    }

    public static int[] calculatingResults(int[] numbers, char[] operators) {
        int[] results = new int[3];
        int increaser = 0;
        for (int k = 0; k < 3; k++) {
            if (operators[k] == '+') {
                results[k] = numbers[k + increaser] + numbers[k + increaser + 1];
                increaser++;
            } else if (operators[k] == '-') {
                results[k] = numbers[k + increaser] - numbers[k + increaser + 1];
                increaser++;
            } else {
                results[k] = numbers[k + increaser] * numbers[k + increaser + 1];
                increaser++;
            }
        }
        return results;
    }

    public static void run() {
        String task = "What is the result of the expression?";

        int[] numbers = gettingNumbers();
        char[] operators = gettingOperators();
        String[] questionsInString = new String[3];
        int count = 0;
        for (int l = 0; l < 3; l++) {
            questionsInString[l] = numbers[l + count] + " " + operators[l] + " " + numbers[l + count + 1];
            count++;
        }

        int[] rightAnswersInInteger = calculatingResults(numbers, operators);
        String[] rightAnswersInStrings = new String[3];
        for (int m = 0; m < 3; m++) {
            rightAnswersInStrings[m] = String.valueOf(rightAnswersInInteger[m]);
        }

        Engine.run(task, questionsInString, rightAnswersInStrings);
    }
}
