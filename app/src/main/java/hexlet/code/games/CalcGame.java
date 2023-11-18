package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class CalcGame {
    private static final Random GENERATOR = new Random();
    private static final int UPPER_BOUND = 100;
    private static final int REQUIRED_UPPER_BOUND = 3;
    private static final int NUMBER_OF_ROUNDS = 3;

    public static int[][] gettingNumbers() {
        int[][] numbers = new int[NUMBER_OF_ROUNDS][2];
        for (int i = 0; i < numbers[0].length; i++) {
            for (int j = 0; j < 2; j++) {
                numbers[i][j] = GENERATOR.nextInt(UPPER_BOUND);
            }
        }
        return numbers;
    }

    public static char[] gettingOperators() {
        char[] operatorsToChose = {'+', '-', '*'};
        char[] operators = new char[operatorsToChose.length];
        for (int i = 0; i < operators.length; i++) {
            operators[i] = operatorsToChose[GENERATOR.nextInt(REQUIRED_UPPER_BOUND)];
        }
        return operators;
    }

    public static int[] calculatingResults(int[][] numbers, char[] operators) {
        int[] results = new int[NUMBER_OF_ROUNDS];
        for (int i = 0; i < results.length; i++) {
            if (operators[i] == '+') {
                results[i] = numbers[i][0] + numbers[i][1];
            } else if (operators[i] == '-') {
                results[i] = numbers[i][0] - numbers[i][1];
            } else {
                results[i] = numbers[i][0] * numbers[i][1];
            }
        }
        return results;
    }

    public static void run() {
        String task = "What is the result of the expression?";

        int[][] numbers = gettingNumbers();
        char[] operators = gettingOperators();
        String[] questionsInString = new String[NUMBER_OF_ROUNDS];
        for (int i = 0; i < questionsInString.length; i++) {
            questionsInString[i] = numbers[i][0] + " " + operators[i] + " " + numbers[i][1];
        }

        int[] rightAnswersInInteger = calculatingResults(numbers, operators);
        String[] rightAnswersInStrings = new String[NUMBER_OF_ROUNDS];
        for (int i = 0; i < rightAnswersInStrings.length; i++) {
            rightAnswersInStrings[i] = String.valueOf(rightAnswersInInteger[i]);
        }

        Engine.run(task, NUMBER_OF_ROUNDS, questionsInString, rightAnswersInStrings);
    }
}
