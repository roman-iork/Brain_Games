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

    public static String[] getQuestionAndAnswer() {
        var questionsAndAnswers = new String[2];
        int length = Utils.getRandomInt(MIN, MAX);
        int start = Utils.getRandomInt(1, MAX);
        int step = Utils.getRandomInt(1, MAX);
        String[] progression = gettingProgression(length, start, step);
        int twoPointsPosition = Utils.getRandomInt(progression.length);
        String answer = progression[twoPointsPosition];
        progression[twoPointsPosition] = "..";
        questionsAndAnswers[0] = String.join(" ", progression);
        questionsAndAnswers[1] = answer;
        return questionsAndAnswers;
    }

    public static void run() {
        Engine.run(getQuestionAndAnswer(), TASK);
    }
}
