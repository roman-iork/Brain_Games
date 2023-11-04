package hexlet.code.games;

import hexlet.code.Engine;

public class ProgressionGame {
    public static void run() {
        //Greeting
        String userName = Engine.greeting();

        //Describing a task
        Engine.describeTask("What number is missing in the progression?");

        //Three rounds or quit
        boolean resultWin = true;
        int numberOfRounds = 3;
        for (int i = 0; i < numberOfRounds; i++) {
            //forming a question
            int minLengthOfProgression = 5;
            int maxIncrementOfProgressionLength = 5;
            int randomLengthOfProgression = Engine.random(maxIncrementOfProgressionLength);
            int lengthOfProgression = minLengthOfProgression + randomLengthOfProgression;
            String[] progression = new String[lengthOfProgression];
            int toAvoidZero = 1;
            int upperBoundForStart = 15;
            int upperBoundForStep = 10;
            int startOfProgression = Engine.random(upperBoundForStart) + toAvoidZero;
            int step = Engine.random(upperBoundForStep) + toAvoidZero;
            int previousNumber = startOfProgression;
            progression[0] = String.valueOf(startOfProgression);
            for (int j = 1; j < lengthOfProgression; j++) {
                progression[j] = String.valueOf(previousNumber + step);
                previousNumber += step;
            }
            int twoDotsPlace = Engine.random(lengthOfProgression);
            System.out.print("Question: ");
            for (int k = 0; k < lengthOfProgression; k++) {
                if (k != twoDotsPlace) {
                    System.out.print(progression[k] + " ");
                } else {
                    System.out.print(".. ");
                }
            }
            System.out.print("\n");

            //discovering the right answer
            String rightAnswer = progression[twoDotsPlace];

            //getting the answer, comparing values, announcing results
            resultWin = Engine.getAnswerCheckResult(rightAnswer);
            if (!resultWin) {
                break;
            }
        }

        //Congratulations or another try
        Engine.resulting(resultWin, userName);
    }
}
