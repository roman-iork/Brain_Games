package hexlet.code.games;

import hexlet.code.Utils;
import hexlet.code.Engine;

public class EvenGame {

    public static void run(int numberOfRounds) {
        String task = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        String[][] questionsAndAnswers = new String[numberOfRounds][2];
        for (int i = 0; i < numberOfRounds; i++) {
            final int upperBound = 100;
            int question = Utils.getRandomInt(upperBound);
            questionsAndAnswers[i][0] = String.valueOf(question);
            if (question % 2 == 0) {
                questionsAndAnswers[i][1] = "yes";
            } else {
                questionsAndAnswers[i][1] = "no";
            }
        }

        Engine.run(task, numberOfRounds, questionsAndAnswers);
    }
}
