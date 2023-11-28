package hexlet.code.games;

import hexlet.code.Utils;
import hexlet.code.Engine;

public class ProgressionGame {
    private static final int MIN = 5;
    private static final int MAX = 10;

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

    public static void run(int numberOfRounds) {
        String task = "What number is missing in the progression?";

        String[][] questionsAndAnswers = new String[numberOfRounds][2];
        for (int i = 0; i < numberOfRounds; i++) {
            int length = Utils.getRandomInt(MIN, MAX);
            int start = Utils.getRandomInt(1, MAX);
            int step = Utils.getRandomInt(1, MAX);
            String[] progression = gettingProgression(length, start, step);
            int twoPointsPosition = Utils.getRandomInt(progression.length);
            String answer = progression[twoPointsPosition];
            progression[twoPointsPosition] = "..";
            questionsAndAnswers[i][0] = String.join(" ", progression);
            questionsAndAnswers[i][1] = answer;
        }

        Engine.run(task, numberOfRounds, questionsAndAnswers);
    }
}
