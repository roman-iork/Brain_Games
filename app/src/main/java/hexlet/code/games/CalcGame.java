package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class CalcGame {

    public static String formQuestion(int firstNum, int secondNum, char currOperator) {
        return firstNum + " " + currOperator + " " + secondNum;
    }

    public static String discoverRightAnswer(int firstNum, int secondNum, char currOperator) {
        String rightAnswer;
        if (currOperator == '+') {
            rightAnswer = String.valueOf(firstNum + secondNum);
        } else if (currOperator == '-') {
            rightAnswer = String.valueOf(firstNum - secondNum);
        } else {
            rightAnswer = String.valueOf(firstNum * secondNum);
        }
        return rightAnswer;
    }

    public static void run() {
        //Greeting
        String task = "What is the result of the expression?";
        String userName = Engine.greetingAndTask(task);

        //Three rounds or quit before
        boolean resultWin = true;
        final int numberOfRounds = 3;
        for (int i = 0; i < numberOfRounds; i++) {
            //forming a question
            Random generator = new Random();
            final int upBound = 100;
            int firstNum = generator.nextInt(upBound);
            int secondNum = generator.nextInt(upBound);
            char[] operators = {'+', '-', '*'};
            char currOperator = operators[generator.nextInt(operators.length)];
            String expressionToAsk = formQuestion(firstNum, secondNum, currOperator);
            //discovering the right answer
            String rightAnswer = discoverRightAnswer(firstNum, secondNum, currOperator);
            //Starting Engine
            resultWin = Engine.run(expressionToAsk, rightAnswer);
            if (!resultWin) {
                break;
            }
        }
        //Congratulations or another try
        Engine.resulting(resultWin, userName);
    }
}
