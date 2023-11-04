package hexlet.code.games;

import hexlet.code.Engine;

public class GcdGame {
    public static void run() {
        //Greeting
        String userName = Engine.greeting();

        //Describing a task
        Engine.describeTask("Find the greatest common divisor of given numbers.");

        //Three rounds or quit
        boolean resultWin = true;
        int numberOfRounds = 3;
        for (int i = 0; i < numberOfRounds; i++) {
            //forming a question
            int randomUpBound = 100;
            int toAvoidZero = 1;
            int firstNum = Engine.random(randomUpBound) + toAvoidZero;
            int secondNum = Engine.random(randomUpBound) + toAvoidZero;
            String expressionToAsk = firstNum + " " + secondNum;
            System.out.println("Question: " + expressionToAsk);

            //discovering the right answer
            int minOfTwo = firstNum;
            int maxOfTwo = secondNum;
            if (firstNum > secondNum) {
                minOfTwo = secondNum;
                maxOfTwo = firstNum;
            }
            int gcd = 0;
            int potentialGcd = minOfTwo;
            if (maxOfTwo % minOfTwo == 0) {
                gcd = minOfTwo;
            } else {
                int makeHalf = 2;
                potentialGcd = minOfTwo / makeHalf;
            }
            while (gcd == 0) {
                if ((minOfTwo % potentialGcd == 0) & (maxOfTwo % potentialGcd == 0)) {
                    gcd = potentialGcd;
                    break;
                } else {
                    potentialGcd -= 1;
                }
            }
            String rightAnswer = String.valueOf(gcd);

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
