package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalcGame {
    private static final int UPPER_BOUND = 100;
    private static final String TASK = "What is the result of the expression?";
    private static final String GAME = "calc";

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

    public static String[] getQuestionAndAnswer() {
        var questionsAndAnswers = new String[2];
        int firstNum = Utils.getRandomInt(UPPER_BOUND);
        int secondNum = Utils.getRandomInt(UPPER_BOUND);
        char operator = gettingOperator();
        int result = calculatingResult(firstNum, secondNum, operator);
        questionsAndAnswers[0] = firstNum + " " + operator + " " + secondNum;
        questionsAndAnswers[1] = String.valueOf(result);
        return questionsAndAnswers;
    }

    public static void run() {
        Engine.run(TASK, GAME);
    }
}
