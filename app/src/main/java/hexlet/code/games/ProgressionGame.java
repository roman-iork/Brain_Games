package hexlet.code.games;

import hexlet.code.Utils;
import hexlet.code.Engine;

public class ProgressionGame {
    private static final int NUMBER_OF_PARAMETERS = 3;

    public static int[] preparingParameters(int numberOfParameters) {
        int[] parameters = new int[numberOfParameters];
        final int lowerBound = 5;
        final int upperBound = 10;
        int lengthOfProgression = Utils.getRandomInt(lowerBound, upperBound);
        parameters[0] = lengthOfProgression;
        int startOfProgression = Utils.getRandomInt(1, upperBound);
        parameters[1] = startOfProgression;
        int step = Utils.getRandomInt(1, upperBound);
        parameters[2] = step;
        return parameters;
    }

    public static int[] gettingProgression(int[] parameters) {
        int length = parameters[0];
        int start = parameters[1];
        int step = parameters[2];
        int[] progression = new int[length];
        progression[0] = start;
        for (int i = 1; i < length; i++) {
            progression[i] = progression[i - 1] + step;
        }
        return progression;
    }

    public static void run(int numberOfRounds) {
        String task = "What number is missing in the progression?";

        String[][] questionsAndAnswers = new String[numberOfRounds][2];
        for (int i = 0; i < numberOfRounds; i++) {
            int[] progression = gettingProgression(preparingParameters(NUMBER_OF_PARAMETERS));
            int twoPointsPosition = Utils.getRandomInt(progression.length);
            String question = "";
            for (int j = 0; j < progression.length; j++) {
                if (j != twoPointsPosition) {
                    question += progression[j] + " ";
                } else {
                    question += ".. ";
                }
            }
            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = String.valueOf(progression[twoPointsPosition]);
        }

        Engine.run(task, numberOfRounds, questionsAndAnswers);
    }
}
