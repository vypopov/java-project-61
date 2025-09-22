package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Player;
import hexlet.code.Util;

public class Even {

    private static String task = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void start(Player player) {
        Engine game = new Engine(player);
        game.getTask(task);
        while (game.getNiceAnswerCnt() < game.getWinRoundCount()) {
            int question = Util.getRandomInRange(1, 100);
            var correctAnswer = question % 2 == 0 ? "yes" : "no";
            game.gameRulesCheck(player, String.valueOf(question), String.valueOf(correctAnswer));
        }
        game.getWinMessage(player);
    }
}
