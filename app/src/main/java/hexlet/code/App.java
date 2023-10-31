package hexlet.code;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        final int tryAgain = 0;
        final int congratulate = 1;
        final int skip = 2;
        int whatToDo;
        String user = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter."
                + "\n1 - Greet"
                + "\n2 - Even"
                + "\n0 - Exit");
        System.out.print("Your choice: ");
        String choice = scanner.next();
        System.out.print("\n");
        switch (choice) {
            case "1":
                Cli.greeting();
                whatToDo = skip;
                break;
            case "2":
                user = Cli.greeting();
                whatToDo = EvenGame.run();
                break;
            default:
                whatToDo = skip;
        }
        scanner.close();
        if (whatToDo == congratulate) {
            System.out.println("Congratulations, " + user + "!");
        } else if (whatToDo == tryAgain) {
            System.out.println("Let's try again, " + user + "!");
        }
    }
}
