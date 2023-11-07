package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class GcdGame {

    public static String discoverRightAnswer(int firstNum, int secondNum) {
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
            final int makeHalf = 2;
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
        return String.valueOf(gcd);
    }

    public static void run() {
        //Greeting
        String task = "Find the greatest common divisor of given numbers.";
        String userName = Engine.greetingAndTask(task);

        //Three rounds or quit before
        boolean resultWin = true;
        final int numberOfRounds = 3;
        for (int i = 0; i < numberOfRounds; i++) {
            //forming a question
            Random generator = new Random();
            final int upBound = 100;
            final int toAvoidZero = 1;
            int firstNum = generator.nextInt(upBound) + toAvoidZero;
            int secondNum = generator.nextInt(upBound) + toAvoidZero;
            String expressionToAsk = firstNum + " " + secondNum;

            //discovering the right answer
            String rightAnswer = discoverRightAnswer(firstNum, secondNum);

            //Starting Engine - question and compare
            resultWin = Engine.run(expressionToAsk, rightAnswer);
            if (!resultWin) {
                break;
            }
        }
        //Congratulations or another try
        Engine.resulting(resultWin, userName);
    }
}
