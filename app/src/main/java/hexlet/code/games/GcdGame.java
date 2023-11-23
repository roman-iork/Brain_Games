package hexlet.code.games;

import hexlet.code.Utils;
import hexlet.code.Engine;

public class GcdGame {

    public static int calculatingGcd(int firstNum, int secondNum) {
        int minOfTwo = Math.min(firstNum, secondNum);
        int maxOfTwo = Math.max(firstNum, secondNum);
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
        return gcd;
    }

    public static void run(int numberOfRounds) {
        String task = "Find the greatest common divisor of given numbers.";

        String[][] questionsAndAnswers = new String[numberOfRounds][2];
        for (int i = 0; i < numberOfRounds; i++) {
            int firstNum = Utils.getRandomInt(1, 100);
            int secondNum = Utils.getRandomInt(1, 100);
            int gcd = calculatingGcd(firstNum, secondNum);
            questionsAndAnswers[i][0] = firstNum + " " + secondNum;
            questionsAndAnswers[i][1] = String.valueOf(gcd);
        }

        Engine.run(task, numberOfRounds, questionsAndAnswers);
    }
}
