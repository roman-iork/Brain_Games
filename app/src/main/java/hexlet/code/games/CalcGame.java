package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalcGame {
    private static final int UPPER_BOUND = 100;
    private static final String TASK = "What is the result of the expression?";

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

    public static String[][] getQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_ROUNDS][2];
        for (int i = 0; i < Engine.NUMBER_OF_ROUNDS; i++) {
            var questionsAndAnswersPair = new String[2];
            int firstNum = Utils.getRandomInt(UPPER_BOUND);
            int secondNum = Utils.getRandomInt(UPPER_BOUND);
            char operator = gettingOperator();
            int result = calculatingResult(firstNum, secondNum, operator);
            questionsAndAnswersPair[0] = firstNum + " " + operator + " " + secondNum;
            questionsAndAnswersPair[1] = String.valueOf(result);
            questionsAndAnswers[i] = questionsAndAnswersPair;
        }
        return questionsAndAnswers;
    }

    public static void run() {
        Engine.run(getQuestionsAndAnswers(), TASK);
    }
}
