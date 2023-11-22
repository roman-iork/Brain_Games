package hexlet.code.games;

//import java.util.Random;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalcGame {
    //private static final Random GENERATOR = new Random();
    //private static final int UPPER_BOUND = 100;
    //private static final int REQUIRED_UPPER_BOUND = 3;
    private static final int NUMBER_OF_ROUNDS = 3;

    public static int[][] gettingNumbers(int numberOfRounds) {
        int[][] numbers = new int[numberOfRounds][2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < 2; j++) {
                numbers[i][j] = Utils.getRandomInt(100);
            }
        }
        return numbers;
    }

    public static char[] gettingOperators(int numberOfRounds) {
        char[] operatorsToChose = {'+', '-', '*'};
        char[] operators = new char[numberOfRounds];
        for (int i = 0; i < operators.length; i++) {
            operators[i] = operatorsToChose[Utils.getRandomInt(operatorsToChose.length)];
        }
        return operators;
    }

    public static int[] calculatingResults(int[][] numbers, char[] operators, int numberOfRounds) {
        int[] results = new int[numberOfRounds];
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

        int[][] numbers = gettingNumbers(NUMBER_OF_ROUNDS);
        char[] operators = gettingOperators(NUMBER_OF_ROUNDS);
        String[] questionsInString = new String[NUMBER_OF_ROUNDS];
        for (int i = 0; i < questionsInString.length; i++) {
            questionsInString[i] = numbers[i][0] + " " + operators[i] + " " + numbers[i][1];
        }

        int[] rightAnswersInInteger = calculatingResults(numbers, operators, NUMBER_OF_ROUNDS);
        String[] rightAnswersInStrings = new String[NUMBER_OF_ROUNDS];
        for (int i = 0; i < rightAnswersInStrings.length; i++) {
            rightAnswersInStrings[i] = String.valueOf(rightAnswersInInteger[i]);
        }

        Engine.run(task, NUMBER_OF_ROUNDS, questionsInString, rightAnswersInStrings);
    }
}
