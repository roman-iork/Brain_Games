package hexlet.code.games;

import hexlet.code.Utils;
import hexlet.code.Engine;

public class PrimeGame {

    public static boolean isPrime(int number) {
        boolean numberIsPrime = true;
        int divider = number / 2;
        if ((number == 0) || (number == 1)) {
            numberIsPrime = false;
        }
        for (int i = divider; i > 1; i--) {
            if (number % i == 0) {
                numberIsPrime = false;
                break;
            }
        }
        return numberIsPrime;
    }

    public static void run(int numberOfRounds) {
        String task = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        String[][] questionsAndAnswers = new String[numberOfRounds][2];
        for (int i = 0; i < numberOfRounds; i++) {
            int question = Utils.getRandomInt(100);
            questionsAndAnswers[i][0] = String.valueOf(question);
            boolean primeOrNot = isPrime(question);
            if (primeOrNot) {
                questionsAndAnswers[i][1] = "yes";
            } else {
                questionsAndAnswers[i][1] = "no";
            }
        }

        Engine.run(task, numberOfRounds, questionsAndAnswers);
    }
}
