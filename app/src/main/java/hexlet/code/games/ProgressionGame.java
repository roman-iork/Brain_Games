package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class ProgressionGame {

    public static String[] calculateQuestionAnswer() {
        Random generator = new Random();
        final int minLengthOfProgression = 5;
        final int maxIncrementOfProgressionLength = 5;
        int randomLengthOfProgression = generator.nextInt(maxIncrementOfProgressionLength);
        int lengthOfProgression = minLengthOfProgression + randomLengthOfProgression;
        String[] progression = new String[lengthOfProgression];
        final int toAvoidZero = 1;
        final int upperBoundForStart = 15;
        final int upperBoundForStep = 10;
        int startOfProgression = generator.nextInt(upperBoundForStart) + toAvoidZero;
        int step = generator.nextInt(upperBoundForStep) + toAvoidZero;
        int previousNumber = startOfProgression;
        progression[0] = String.valueOf(startOfProgression);
        for (int j = 1; j < lengthOfProgression; j++) {
            progression[j] = String.valueOf(previousNumber + step);
            previousNumber += step;
        }
        int twoDotsPlace = generator.nextInt(lengthOfProgression);
        String replacedNumber = progression[twoDotsPlace];
        String modifiedProgression = "";
        for (int k = 0; k < lengthOfProgression; k++) {
            if (k == twoDotsPlace) {
                modifiedProgression += ".. ";
            } else {
                modifiedProgression += progression[k] + " ";
            }
        }
        String[] result = {modifiedProgression, replacedNumber};
        return result;
    }

    public static void run() {
        //Greeting
        String task = "What number is missing in the progression?";
        String userName = Engine.greetingAndTask(task);

        //Three rounds or quit
        boolean resultWin = true;
        final int numberOfRounds = 3;
        for (int i = 0; i < numberOfRounds; i++) {
            String[] questionAndAnswer = calculateQuestionAnswer();
            //forming a question
            String expressionToAsk = questionAndAnswer[0];

            //discovering the right answer
            String rightAnswer = questionAndAnswer[1];

            //Starting Engine - question and compare
            resultWin = Engine.run(expressionToAsk, rightAnswer);
            if (!resultWin) {
                break;
            }
        }

        //Congratulations or another try
        Engine.resulting(resultWin, userName);
    }
}
