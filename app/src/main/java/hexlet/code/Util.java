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

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
