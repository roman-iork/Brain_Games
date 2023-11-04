package hexlet.code.games;

import hexlet.code.Engine;

public class GcdGame {
    public static void run() {
        //Greeting
        String userName = Engine.greeting();

        //Describing a task
        Engine.describeTask("Find the greatest common divisor of given numbers.");

        //Playing the game
        boolean resultWin = Engine.gcd();

        //Congratulations or another try
        Engine.resulting(resultWin, userName);
    }
}
