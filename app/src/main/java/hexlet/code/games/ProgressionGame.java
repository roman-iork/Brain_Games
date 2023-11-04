package hexlet.code.games;

import hexlet.code.Engine;

public class ProgressionGame {
    public static void run() {
        //Greeting
        String userName = Engine.greeting();

        //Describing a task
        Engine.describeTask("What number is missing in the progression?");

        //Playing the game
        boolean resultWin = Engine.progression();

        //Congratulations or another try
        Engine.resulting(resultWin, userName);
    }
}
