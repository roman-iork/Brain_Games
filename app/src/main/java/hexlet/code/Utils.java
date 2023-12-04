package hexlet.code;

import java.util.Random;

public class Utils {

    public static int getRandomInt(int lowerBound, int upperBound) {
        Random generator = new Random();
        return generator.nextInt(lowerBound, upperBound);
    }

    public static int getRandomInt(int upperBound) {
        return getRandomInt(0, upperBound);
    }
}
