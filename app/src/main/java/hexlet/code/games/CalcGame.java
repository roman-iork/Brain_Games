package hexlet.code.games;

import hexlet.code.Engine;

public class CalcGame {
    public static void run() {
        //Greeting
        String userName = Engine.greeting();

        //Describing a task
        Engine.describeTask("What is the result of the expression?");

        //Playing the game
        boolean resultWin = Engine.calc();

        //Congratulations or another try
        Engine.resulting(resultWin, userName);
    }
}
