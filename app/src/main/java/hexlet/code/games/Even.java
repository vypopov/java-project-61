package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Player;
import hexlet.code.Util;

public class Even {

    private final static String TASK = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN_BOUND_FOR_RANDOM = 1;
    private static final int MAX_BOUND_FOR_RANDOM = 100;


    public static void start(Player player) {
        Engine game = new Engine(player);
        game.getTask(TASK);
        while (game.getNiceAnswerCnt() < game.getWinRoundCount()) {
            int question = Util.getRandomInRange(MIN_BOUND_FOR_RANDOM, MAX_BOUND_FOR_RANDOM);
            var correctAnswer = question % 2 == 0 ? "yes" : "no";
            game.gameRulesCheck(player, String.valueOf(question), String.valueOf(correctAnswer));
        }
        game.getWinMessage(player);
    }
}
