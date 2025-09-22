package hexlet.code.games;

import hexlet.code.Player;
import hexlet.code.Util;
import hexlet.code.Engine;

public class GCD {
    private static final String TASK = "Find the greatest common divisor of given numbers.";
    private static final int MIN_BOUND_FOR_RANDOM = 1;
    private static final int MAX_BOUND_FOR_RANDOM = 100;


    public static void start(Player player) {
        Engine game = new Engine(player);
        game.getTask(TASK);
        while (game.getNiceAnswerCnt() < game.getWinRoundCount()) {
            int numLeft = Util.getRandomInRange(MIN_BOUND_FOR_RANDOM, MAX_BOUND_FOR_RANDOM);
            int numRight = Util.getRandomInRange(MIN_BOUND_FOR_RANDOM, MAX_BOUND_FOR_RANDOM);
            int correctAnswer = Util.gcd(numLeft, numRight);
            String question = String.format("%s %s", numLeft, numRight);
            game.gameRulesCheck(player, question, String.valueOf(correctAnswer));
        }
        game.getWinMessage(player);
    }
}
