package hexlet.code.games;

import hexlet.code.Engine;

public class CalcGame {
    public static void run() {
        //Greeting
        String userName = Engine.greeting();

        //Describing a task
        Engine.describeTask("What is the result of the expression?");

        //Three rounds or quit
        boolean resultWin = true;
        int numberOfRounds = 3;
        for (int i = 0; i < numberOfRounds; i++) {
            //forming a question
            int randomUpBound = 100;
            int firstNum = Engine.random(randomUpBound);
            int secondNum = Engine.random(randomUpBound);
            char[] operators = {'+', '-', '*'};
            char currOperator = operators[Engine.random(operators.length)];
            String expressionToAsk = firstNum + " " + currOperator + " " + secondNum;
            System.out.println("Question: " + expressionToAsk);

            //discovering the right answer
            String rightAnswer;
            if (currOperator == '+') {
                rightAnswer = String.valueOf(firstNum + secondNum);
            } else if (currOperator == '-') {
                rightAnswer = String.valueOf(firstNum - secondNum);
            } else {
                rightAnswer = String.valueOf(firstNum * secondNum);
            }
            //getting the answer, comparing values, announcing results
            resultWin = Engine.getAnswerCheckResult(rightAnswer);
            if (!resultWin) {
                break;
            }
        }

        //Congratulations or another try
        Engine.resulting(resultWin, userName);
    }
}
