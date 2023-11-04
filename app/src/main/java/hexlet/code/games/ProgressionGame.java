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
        for (int i = 0; i < 3; i++) {
            //forming a question
            int minLengthOfProgression = 5;
            int randomLengthOfProgression = Engine.random(5);
            int lengthOfProgression = minLengthOfProgression + randomLengthOfProgression;
            String[] progression = new String[lengthOfProgression];
            int toAvoidZero = 1;
            int startOfProgression = Engine.random(15) + toAvoidZero;
            int step = Engine.random(10) + toAvoidZero;
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
