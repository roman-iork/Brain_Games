package hexlet.code.games;

import hexlet.code.Engine;

public class EvenGame {
    public static void run() {
        //Greeting
        String userName = Engine.greeting();

        //Describing a task
        Engine.describeTask("Answer 'yes' if the number is even, otherwise answer 'no'.");

        //Three rounds or quit
        boolean resultWin = true;
        int numberOfRounds = 3;
        for (int i = 0; i < numberOfRounds; i++) {
            //forming a question
            int randomUpBound = 100;
            int numToAsk = Engine.random(randomUpBound);
            System.out.println("Question: " + numToAsk);

            //discovering the right answer
            String rightAnswer;
            if (numToAsk % 2 == 0) {
                rightAnswer = "yes";
            } else {
                rightAnswer = "no";
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
