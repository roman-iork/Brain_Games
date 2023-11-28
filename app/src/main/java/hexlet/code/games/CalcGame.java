package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalcGame {
    private static final int UPPER_BOUND = 100;

    public static char gettingOperator() {
        char[] operatorsToChose = {'+', '-', '*'};
        return operatorsToChose[Utils.getRandomInt(operatorsToChose.length)];
    }

    public static Integer calculatingResult(int firstNum, int secondNum, char operator) {
        int result;
        switch (operator) {
            case '+':
                result = firstNum + secondNum;
                break;
            case '-':
                result = firstNum - secondNum;
                break;
            case '*':
                result = firstNum * secondNum;
                break;
            default:
                return null;
        }
        return result;
    }

    public static void run(int numberOfRounds) {
        String task = "What is the result of the expression?";

        String[][] questionsAndAnswers = new String[numberOfRounds][2];
        for (int i = 0; i < numberOfRounds; i++) {
            int firstNum = Utils.getRandomInt(UPPER_BOUND);
            int secondNum = Utils.getRandomInt(UPPER_BOUND);
            char operator = gettingOperator();
            int result = calculatingResult(firstNum, secondNum, operator);
            questionsAndAnswers[i][0] = firstNum + " " + operator + " " + secondNum;
            questionsAndAnswers[i][1] = String.valueOf(result);
        }

        Engine.run(task, numberOfRounds, questionsAndAnswers);
    }
}
