package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        final int numberOfRounds = 3;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter."
                + "\n1 - Greet"
                + "\n2 - Even"
                + "\n3 - Calc"
                + "\n4 - GCD"
                + "\n5 - Progression"
                + "\n6 - Prime"
                + "\n0 - Exit");
        System.out.print("Your choice: ");
        String choice = scanner.next();
        System.out.print("\n");
        switch (choice) {
            case "1":
                Cli.greeting();
                break;
            case "2":
                EvenGame.run(numberOfRounds);
                break;
            case "3":
                CalcGame.run(numberOfRounds);
                break;
            case "4":
                GcdGame.run(numberOfRounds);
                break;
            case "5":
                ProgressionGame.run(numberOfRounds);
                break;
            case "6":
                PrimeGame.run(numberOfRounds);
                break;
            default:
        }
        scanner.close();
    }
}
