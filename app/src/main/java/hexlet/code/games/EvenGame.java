package hexlet.code.games;

import hexlet.code.Utils;
import hexlet.code.Engine;

public class EvenGame {
    private static final int UPPER_BOUND = 100;
    private static final String TASK = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static String[][] getQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_ROUNDS][2];
        for (int i = 0; i < Engine.NUMBER_OF_ROUNDS; i++) {
            var questionsAndAnswersPair = new String[2];
            int questionNumber = Utils.getRandomInt(UPPER_BOUND);
            questionsAndAnswersPair[0] = String.valueOf(questionNumber);
            if (isEven(questionNumber)) {
                questionsAndAnswersPair[1] = "yes";
            } else {
                questionsAndAnswersPair[1] = "no";
            }
            questionsAndAnswers[i] = questionsAndAnswersPair;
        }
        return questionsAndAnswers;
    }

    public static void run() {
        Engine.run(getQuestionsAndAnswers(), TASK);
    }
}
