package hexlet.code.games;

import hexlet.code.Engine;

public class PrimeGame {
    public static void run() {
        //Greeting
        String userName = Engine.greeting();

        //Describing a task
        Engine.describeTask("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        //Three rounds or quit
        boolean resultWin = true;
        int numberOfRounds = 3;
        for (int i = 0; i < numberOfRounds; i++) {
            //forming a question
            int randomUpBound = 100;
            int numToAsk = Engine.random(randomUpBound);
            System.out.println("Question: " + numToAsk);

            //discovering the right answer
            String rightAnswer = "yes";
            int makeHalf = 2;
            int divider = numToAsk / makeHalf;
            for (int j = divider; j > 1; j--) {
                if ((numToAsk == 0) | (numToAsk == 1) | (numToAsk % j == 0)) {
                    rightAnswer = "no";
                    break;
                }
            }

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
