package hexlet.code.games;

import hexlet.code.Engine;

public class EvenGame {
    public static void run() {
        //Greeting
        String userName = Engine.greeting();

        //Setting variables
        int numToAsk;
        String rightAnswer;
        boolean resultWin = true;


        //Describing a task
        Engine.describeTask("Answer 'yes' if the number is even, otherwise answer 'no'.");

        //Three rounds or quit
        for (int i = 0; i < 3; i++) {
            //forming a question
            numToAsk = Engine.random(100);
            System.out.println("Question: " + numToAsk);




            //discovering the right answer
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
