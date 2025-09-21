package hexlet.code;

import java.util.Random;

public final class Util {
    private static final Random RAND = new Random();

    public static int getRandomInRange(int min, int max) {
        return RAND.nextInt((max - min) + 1) + min;
    }

    public static int getRandom() {
        return RAND.nextInt();
    }
}
