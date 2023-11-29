package hexlet.code.games;

import hexlet.code.Utils;
import hexlet.code.Engine;

public class GcdGame {
    private static final int UPPER_BOUND = 100;
    private static final String TASK = "Find the greatest common divisor of given numbers.";
    private static final String GAME = "gcd";

    public static int calculatingGcd(int firstNum, int secondNum) {
        int minOfTwo = Math.min(firstNum, secondNum);
        int maxOfTwo = Math.max(firstNum, secondNum);
        if (maxOfTwo % minOfTwo == 0) {
            return minOfTwo;
        }
        int gcd = 0;
        int potentialGcd = minOfTwo / 2;
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

    public static String[] getQuestionAndAnswer() {
        var questionsAndAnswers = new String[2];
        int firstNum = Utils.getRandomInt(1, UPPER_BOUND);
        int secondNum = Utils.getRandomInt(1, UPPER_BOUND);
        int gcd = calculatingGcd(firstNum, secondNum);
        questionsAndAnswers[0] = firstNum + " " + secondNum;
        questionsAndAnswers[1] = String.valueOf(gcd);
        return questionsAndAnswers;
    }

    public static void run() {
        Engine.run(TASK, GAME);
    }
}
