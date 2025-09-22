package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Player;
import hexlet.code.Util;

public class Progression {
    private static final String TASK = "What number is missing in the progression?";
    private static final int MIN_BOUND_FOR_RANDOM = 1;
    private static final int MAX_BOUND_FOR_RANDOM = 100;
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;

    public static void start(Player player) {
        Engine game = new Engine(player);
        game.getTask(TASK);
        while (game.getNiceAnswerCnt() < game.getWinRoundCount()) {
            var size = Util.getRandomInRange(MIN_LENGTH, MAX_LENGTH);
            var start = Util.getRandomInRange(MIN_BOUND_FOR_RANDOM, MAX_BOUND_FOR_RANDOM);
            var step = Util.getRandomInRange(MIN_BOUND_FOR_RANDOM, MAX_BOUND_FOR_RANDOM);
            int[] arr = Util.getProgression(start, size, step);
            var hide = Util.getRandomInRange(MIN_BOUND_FOR_RANDOM - 1, size - 1);
            var correctAnswer = arr[hide];
            var question = Util.getStringIntSequence(arr, correctAnswer, "..");
            game.gameRulesCheck(player, question, String.valueOf(correctAnswer));
        }
        game.getWinMessage(player);
    }
}
