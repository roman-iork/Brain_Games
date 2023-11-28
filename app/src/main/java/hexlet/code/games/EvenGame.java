package hexlet.code.games;

import hexlet.code.Utils;
import hexlet.code.Engine;

public class EvenGame {
    private static final int UPPER_BOUND = 100;

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void run(int numberOfRounds) {
        String task = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        String[][] questionsAndAnswers = new String[numberOfRounds][2];
        for (int i = 0; i < numberOfRounds; i++) {
            int questionNumber = Utils.getRandomInt(UPPER_BOUND);
            questionsAndAnswers[i][0] = String.valueOf(questionNumber);
            if (isEven(questionNumber)) {
                questionsAndAnswers[i][1] = "yes";
            } else {
                questionsAndAnswers[i][1] = "no";
            }
        }

        Engine.run(task, numberOfRounds, questionsAndAnswers);
    }
}
