package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Player;
import hexlet.code.Util;

public class Prime {
    private static final String TASK = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_BOUND_FOR_RANDOM = 1;
    private static final int MAX_BOUND_FOR_RANDOM = 1000;

    public static void start(Player player) {
        Engine game = new Engine(player);
        game.getTask(TASK);
        while (game.getNiceAnswerCnt() < game.getWinRoundCount()) {
            int question = Util.getRandomInRange(MIN_BOUND_FOR_RANDOM, MAX_BOUND_FOR_RANDOM);
            var correctAnswer = Util.isPrime(question) ? "yes" : "no";
            game.gameRulesCheck(player, String.valueOf(question), correctAnswer);
        }
        game.getWinMessage(player);
    }
}
