package hexlet.code.games;

import hexlet.code.Engine;

public class EvenGame {
    public static void run() {
        //Greeting
        String userName = Engine.greeting();

        //Describing a task
        Engine.describeTask("Answer 'yes' if the number is even, otherwise answer 'no'.");

        //Playing the game
        boolean resultWin = Engine.even();

        //Congratulations or another try
        Engine.resulting(resultWin, userName);
    }
}
