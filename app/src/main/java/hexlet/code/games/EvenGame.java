package hexlet.code.games;

import hexlet.code.Utils;
import hexlet.code.Engine;

public class EvenGame {
    private static final int UPPER_BOUND = 100;
    private static final String TASK = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static String[] getQuestionAndAnswer() {
        var questionsAndAnswers = new String[2];
        int questionNumber = Utils.getRandomInt(UPPER_BOUND);
        questionsAndAnswers[0] = String.valueOf(questionNumber);
        if (isEven(questionNumber)) {
            questionsAndAnswers[1] = "yes";
        } else {
            questionsAndAnswers[1] = "no";
        }
        return questionsAndAnswers;
    }

    public static void run() {
        Engine.run(getQuestionAndAnswer(), TASK);
    }
}
