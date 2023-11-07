package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class EvenGame {

    public static void run() {
        //Greeting
        String task = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String userName = Engine.greetingAndTask(task);

        //Three rounds or quit before
        boolean resultWin = true;
        final int numberOfRounds = 3;
        for (int i = 0; i < numberOfRounds; i++) {
            //forming a question
            Random generator = new Random();
            final int upBound = 100;
            int numberToAsk = generator.nextInt(upBound);
            String expressionToAsk = String.valueOf(numberToAsk);

            //discovering the right answer
            String rightAnswer;
            if (numberToAsk % 2 == 0) {
                rightAnswer = "yes";
            } else {
                rightAnswer = "no";
            }

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
