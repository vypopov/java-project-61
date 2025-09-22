package hexlet.code;

import java.util.Random;

public final class Util {
    private static final Random RAND = new Random();
    private static final int FIRST_PRIME = 2;
    private static final int SECOND_PRIME = 3;
    private static final int STEP_FOR_ODD_CHECK = 2;

    public static int getRandomInRange(int min, int max) {
        return Math.abs(RAND.nextInt((max - min) + 1) + min);
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

    public static int[] getProgression(int start, int size, int step) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = start + step * i;
        }
        return result;
    }

    public static String getStringIntSequence(int[] array, int hidePos, String replString) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == hidePos) {
                sb.append(replString);
            } else {
                sb.append(array[i]);
            }
            if (i < array.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static boolean isPrime(int num) {
        if (num == FIRST_PRIME) {
            return true;
        }
        if (num <= 1 || num % FIRST_PRIME == 0) {
            return false;
        }

        final double sqrtLimit = Math.sqrt(num);
        for (int i = SECOND_PRIME; i <= sqrtLimit; i += STEP_FOR_ODD_CHECK) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
