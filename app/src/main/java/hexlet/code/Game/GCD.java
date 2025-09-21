package hexlet.code.Game;

import hexlet.code.Player;
import hexlet.code.Util;
import hexlet.code.Engine;

public class GCD {
    private static final String TASK = "Find the greatest common divisor of given numbers.";

    public static void start(Player player) {
        Engine game = new Engine(player);
        game.getTask(TASK);
        while (game.getNiceAnswerCnt() < game.getWinRoundCount()) {
            int numLeft = Util.getRandomInRange(0, 100);
            int numRight = Util.getRandomInRange(0, 100);
            int correctAnswer = Util.gcd(numLeft, numRight);
            String question = String.format("%s %s", numLeft, numRight);
            game.gameRulesCheck(player, question, String.valueOf(correctAnswer));
        }
        game.getWinMessage(player);
    }
}
