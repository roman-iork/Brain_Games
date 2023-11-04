package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    public static String greeting() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!"
                + "\nMay I have your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    public static void describeTask(String task) {
        System.out.println(task);
    }

    public static int random(int upLimit) {
        Random generator = new Random();
        return generator.nextInt(upLimit);
    }

    public static boolean getAnswerCheckResult(String rightAnswer) {
        boolean resultWin;
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();
        if (rightAnswer.equals(response)) {
            System.out.println("Correct!");
            resultWin = true;
        } else {
            System.out.println("'" + response + "' is wrong answer ;(. Correct answer was '" + rightAnswer + "'.");
            resultWin = false;
        }
        return resultWin;
    }

    public static boolean even() {
        boolean resultWin = true;
        final int numberOfRounds = 3;
        for (int i = 0; i < numberOfRounds; i++) {
            //forming a question
            final int randomUpBound = 100;
            int numToAsk = Engine.random(randomUpBound);
            System.out.println("Question: " + numToAsk);

            //discovering the right answer
            String rightAnswer;
            if (numToAsk % 2 == 0) {
                rightAnswer = "yes";
            } else {
                rightAnswer = "no";
            }

            //getting the answer, comparing values, announcing results
            resultWin = Engine.getAnswerCheckResult(rightAnswer);
            if (!resultWin) {
                break;
            }
        }
        return resultWin;
    }

    public static boolean calc() {
        boolean resultWin = true;
        final int numberOfRounds = 3;
        for (int i = 0; i < numberOfRounds; i++) {
            //forming a question
            final int randomUpBound = 100;
            int firstNum = Engine.random(randomUpBound);
            int secondNum = Engine.random(randomUpBound);
            char[] operators = {'+', '-', '*'};
            char currOperator = operators[Engine.random(operators.length)];
            String expressionToAsk = firstNum + " " + currOperator + " " + secondNum;
            System.out.println("Question: " + expressionToAsk);

            //discovering the right answer
            String rightAnswer;
            if (currOperator == '+') {
                rightAnswer = String.valueOf(firstNum + secondNum);
            } else if (currOperator == '-') {
                rightAnswer = String.valueOf(firstNum - secondNum);
            } else {
                rightAnswer = String.valueOf(firstNum * secondNum);
            }
            //getting the answer, comparing values, announcing results
            resultWin = Engine.getAnswerCheckResult(rightAnswer);
            if (!resultWin) {
                break;
            }
        }
        return resultWin;
    }

    public static boolean gcd() {
        boolean resultWin = true;
        final int numberOfRounds = 3;
        for (int i = 0; i < numberOfRounds; i++) {
            //forming a question
            final int randomUpBound = 100;
            final int toAvoidZero = 1;
            int firstNum = Engine.random(randomUpBound) + toAvoidZero;
            int secondNum = Engine.random(randomUpBound) + toAvoidZero;
            String expressionToAsk = firstNum + " " + secondNum;
            System.out.println("Question: " + expressionToAsk);

            //discovering the right answer
            int minOfTwo = firstNum;
            int maxOfTwo = secondNum;
            if (firstNum > secondNum) {
                minOfTwo = secondNum;
                maxOfTwo = firstNum;
            }
            int gcd = 0;
            int potentialGcd = minOfTwo;
            if (maxOfTwo % minOfTwo == 0) {
                gcd = minOfTwo;
            } else {
                final int makeHalf = 2;
                potentialGcd = minOfTwo / makeHalf;
            }
            while (gcd == 0) {
                if ((minOfTwo % potentialGcd == 0) & (maxOfTwo % potentialGcd == 0)) {
                    gcd = potentialGcd;
                    break;
                } else {
                    potentialGcd -= 1;
                }
            }
            String rightAnswer = String.valueOf(gcd);

            //getting the answer, comparing values, announcing results
            resultWin = Engine.getAnswerCheckResult(rightAnswer);
            if (!resultWin) {
                break;
            }
        }
        return resultWin;
    }

    public static boolean progression() {
        boolean resultWin = true;
        final int numberOfRounds = 3;
        for (int i = 0; i < numberOfRounds; i++) {
            //forming a question
            final int minLengthOfProgression = 5;
            final int maxIncrementOfProgressionLength = 5;
            int randomLengthOfProgression = Engine.random(maxIncrementOfProgressionLength);
            int lengthOfProgression = minLengthOfProgression + randomLengthOfProgression;
            String[] progression = new String[lengthOfProgression];
            final int toAvoidZero = 1;
            final int upperBoundForStart = 15;
            final int upperBoundForStep = 10;
            int startOfProgression = Engine.random(upperBoundForStart) + toAvoidZero;
            int step = Engine.random(upperBoundForStep) + toAvoidZero;
            int previousNumber = startOfProgression;
            progression[0] = String.valueOf(startOfProgression);
            for (int j = 1; j < lengthOfProgression; j++) {
                progression[j] = String.valueOf(previousNumber + step);
                previousNumber += step;
            }
            int twoDotsPlace = Engine.random(lengthOfProgression);
            System.out.print("Question: ");
            for (int k = 0; k < lengthOfProgression; k++) {
                if (k != twoDotsPlace) {
                    System.out.print(progression[k] + " ");
                } else {
                    System.out.print(".. ");
                }
            }
            System.out.print("\n");

            //discovering the right answer
            String rightAnswer = progression[twoDotsPlace];

            //getting the answer, comparing values, announcing results
            resultWin = Engine.getAnswerCheckResult(rightAnswer);
            if (!resultWin) {
                break;
            }
        }
        return resultWin;
    }

    public static boolean prime() {
        boolean resultWin = true;
        final int numberOfRounds = 3;
        for (int i = 0; i < numberOfRounds; i++) {
            //forming a question
            final int randomUpBound = 100;
            int numToAsk = Engine.random(randomUpBound);
            System.out.println("Question: " + numToAsk);

            //discovering the right answer
            String rightAnswer = "yes";
            final int makeHalf = 2;
            int divider = numToAsk / makeHalf;
            for (int j = divider; j > 1; j--) {
                if ((numToAsk == 0) | (numToAsk == 1) | (numToAsk % j == 0)) {
                    rightAnswer = "no";
                    break;
                }
            }

            //getting the answer, comparing values, announcing results
            resultWin = Engine.getAnswerCheckResult(rightAnswer);
            if (!resultWin) {
                break;
            }
        }
        return resultWin;
    }
    public static void resulting(boolean win, String user) {
        if (win) {
            System.out.println("Congratulations, " + user + "!");
        } else {
            System.out.println("Let's try again, " + user + "!");
        }
    }

    public static String inputFromUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
