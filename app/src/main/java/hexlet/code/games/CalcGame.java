package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalcGame {

    public static char gettingOperator() {
        char[] operatorsToChose = {'+', '-', '*'};
        return operatorsToChose[Utils.getRandomInt(operatorsToChose.length)];
    }

    public static int calculatingResult(int firstNum, int secondNum, char operator) {
        int result;
        if (operator == '+') {
            result = firstNum + secondNum;
        } else if (operator == '-') {
            result = firstNum - secondNum;
        } else {
            result = firstNum * secondNum;
        }
        return result;
    }

    public static void run(int numberOfRounds) {
        String task = "What is the result of the expression?";

        String[][] questionsAndAnswers = new String[numberOfRounds][2];
        for (int i = 0; i < numberOfRounds; i++) {
            final int upperBound = 100;
            int firstNum = Utils.getRandomInt(upperBound);
            int secondNum = Utils.getRandomInt(upperBound);
            char operator = gettingOperator();
            int result = calculatingResult(firstNum, secondNum, operator);
            questionsAndAnswers[i][0] = firstNum + " " + operator + " " + secondNum;
            questionsAndAnswers[i][1] = String.valueOf(result);
        }

        Engine.run(task, numberOfRounds, questionsAndAnswers);
    }
}
