package hexlet.code.games;

import hexlet.code.Utils;
import hexlet.code.Engine;

public class ProgressionGame {
    private static final int MIN = 5;
    private static final int MAX = 10;
    private static final String TASK = "What number is missing in the progression?";

    public static String[] gettingProgression(int length, int start, int step) {
        var progression = new String[length];
        progression[0] = String.valueOf(start);
        for (int i = 1; i < length; i++) {
            int currentValue = start + step;
            progression[i] = String.valueOf(currentValue);
            start = currentValue;
        }
        return progression;
    }

    public static String[][] getQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_ROUNDS][2];
        for (int i = 0; i < Engine.NUMBER_OF_ROUNDS; i++) {
            var questionsAndAnswersPair = new String[2];
            int length = Utils.getRandomInt(MIN, MAX);
            int start = Utils.getRandomInt(1, MAX);
            int step = Utils.getRandomInt(1, MAX);
            String[] progression = gettingProgression(length, start, step);
            int twoPointsPosition = Utils.getRandomInt(progression.length);
            String answer = progression[twoPointsPosition];
            progression[twoPointsPosition] = "..";
            questionsAndAnswersPair[0] = String.join(" ", progression);
            questionsAndAnswersPair[1] = answer;
            questionsAndAnswers[i] = questionsAndAnswersPair;
        }
        return questionsAndAnswers;
    }

    public static void run() {
        Engine.run(getQuestionsAndAnswers(), TASK);
    }
}
