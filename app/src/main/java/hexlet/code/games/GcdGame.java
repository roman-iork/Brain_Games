package hexlet.code.games;

import hexlet.code.Engine;

public class GcdGame {
    public static void run() {
        //Greeting
        String userName = Engine.greeting();

        //Setting variables
        String expressionToAsk;
        String rightAnswer;
        boolean resultWin = true;


        //Describing a task
        Engine.describeTask("Find the greatest common divisor of given numbers.");

        //Three rounds or quit
        for (int i = 0; i < 3; i++) {
            //forming a question
            int firstNum = Engine.random(100) + 1;
            int secondNum = Engine.random(100) + 1;
            expressionToAsk = firstNum + " " + secondNum;
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
                potentialGcd = minOfTwo / 2;
            }
            while (gcd == 0) {
                if ((minOfTwo % potentialGcd == 0) & (maxOfTwo % potentialGcd == 0)) {
                    gcd = potentialGcd;
                    break;
                } else {
                    potentialGcd -= 1;
                }
            }
            rightAnswer = String.valueOf(gcd);

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
