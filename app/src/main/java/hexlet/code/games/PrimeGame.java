package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class PrimeGame {

    public static void run() {
        //Greeting
        String task = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
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
            String rightAnswer = "yes";
            final int makeHalf = 2;
            int divider = numberToAsk / makeHalf;
            if ((numberToAsk == 0) || (numberToAsk == 1)) {
                rightAnswer = "no";
            }
            for (int j = divider; j > 1; j--) {
                if (numberToAsk % j == 0) {
                    rightAnswer = "no";
                    break;
                }
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
