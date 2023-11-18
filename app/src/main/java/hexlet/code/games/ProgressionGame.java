package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class ProgressionGame {
    private static final Random GENERATOR = new Random();
    private static final int UPPER_BOUND_FOR_START = 15;
    private static final int UPPER_BOUND_FOR_STEP = 10;
    private static final int TO_AVOID_ZERO = 1;
    private static final int MIN_LENGTH_OF_PROGRESSION = 5;
    private static final int MAX_INCREMENT_OF_PROGRESSION_LENGTH = 5;

    public static int[][] preparingParameters() {
        int[][] parameters = new int[3][3];
        for (int i = 0; i < 3; i++) {
            int randomLengthOfProgression = GENERATOR.nextInt(MAX_INCREMENT_OF_PROGRESSION_LENGTH);
            int lengthOfProgression = MIN_LENGTH_OF_PROGRESSION + randomLengthOfProgression;
            parameters[i][0] = lengthOfProgression;
            int startOfProgression = GENERATOR.nextInt(UPPER_BOUND_FOR_START) + TO_AVOID_ZERO;
            parameters[i][1] = startOfProgression;
            int step = GENERATOR.nextInt(UPPER_BOUND_FOR_STEP) + TO_AVOID_ZERO;
            parameters[i][2] = step;
        }
        return parameters;
    }

    public static int[][] gettingProgressions(int[][] parameters) {
        int[][] progressions = {{}, {}, {}};
        for (int i = 0; i < 3; i++) {
            int[] currentParametres = parameters[i];
            int length = currentParametres[0];
            int start = currentParametres[1];
            int step = currentParametres[2];
            int[] progression = new int[length];
            int previousNumber = start;
            progression[0] = start;
            for (int j = 1; j < length; j++) {
                progression[j] = previousNumber + step;
                previousNumber += step;
            }
            progressions[i] = progression;
        }
        return progressions;
    }

    public static int[] discoveringTwoPointsPositions(int[][] progression) {
        int[] twoPointsPositions = new int[3];
        for (int i = 0; i < 3; i++) {
            int length = progression[i].length;
            int twoPointsPosition = GENERATOR.nextInt(length);
            twoPointsPositions[i] = twoPointsPosition;
        }
        return twoPointsPositions;
    }

    public static int[] calculatingMissingNumbers(int[][] integerProgression, int[] twoPointsPosition) {
        int[] missingNumbers = new int[3];
        for (int i = 0; i < 3; i++) {
            int position = twoPointsPosition[i];
            int reply = integerProgression[i][position];
            missingNumbers[i] = reply;
        }
        return missingNumbers;
    }

    public static void run() {
        String task = "What number is missing in the progression?";

        int[][] progressionsInInteger = gettingProgressions(preparingParameters());
        int[] twoPointsPosition = discoveringTwoPointsPositions(progressionsInInteger);
        String[] questionsInString = new String[3];
        for (int i = 0; i < 3; i++) {
            int length = progressionsInInteger[i].length;
            int currentTwoPointsPosition = twoPointsPosition[i];
            String currentProgression = "";
            for (int j = 0; j < length; j++) {
                if (j != currentTwoPointsPosition) {
                    currentProgression += progressionsInInteger[i][j] + " ";
                } else {
                    currentProgression += ".." + " ";
                }
            }
            questionsInString[i] = currentProgression;
        }

        int[] rightAnswersInIntegers = calculatingMissingNumbers(progressionsInInteger, twoPointsPosition);
        String[] rightAnswersInString = new String[3];
        for (int k = 0; k < 3; k++) {
            rightAnswersInString[k] = String.valueOf(rightAnswersInIntegers[k]);
        }

        Engine.run(task, questionsInString, rightAnswersInString);
    }
}
