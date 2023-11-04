package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter."
                + "\n1 - Greet"
                + "\n2 - Even"
                + "\n3 - Calc"
                + "\n4 - GCD"
                + "\n5 - Progression"
                + "\n6 - Prime"
                + "\n0 - Exit");
        System.out.print("Your choice: ");
        String choice = Engine.inputFromUser();
        System.out.print("\n");
        if (choice.equals("1")) {
            Cli.greeting();
        } else if (choice.equals("2")) {
            EvenGame.run();
        } else if (choice.equals("3")) {
            CalcGame.run();
        } else if (choice.equals("4")) {
            GcdGame.run();
        } else if (choice.equals("5")) {
            ProgressionGame.run();
        } else if (choice.equals("6")) {
            PrimeGame.run();
        }
    }
}
