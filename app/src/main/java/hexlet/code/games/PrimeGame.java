package hexlet.code.games;

import hexlet.code.Engine;

public class PrimeGame {
    public static void run() {
        //Greeting
        String userName = Engine.greeting();

        //Describing a task
        Engine.describeTask("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        //Playing the game
        boolean resultWin = Engine.prime();

        //Congratulations or another try
        Engine.resulting(resultWin, userName);
    }
}
