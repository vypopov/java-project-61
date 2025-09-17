package hexlet.code.Game;

import hexlet.code.Engine;
import hexlet.code.Player;
import hexlet.code.Util;
import java.text.MessageFormat;

public class Even {

    private static String task = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void start(Player player) {
        Engine game = new Engine(player);
        while (game.getNiceAnswerCnt() < game.getWinRoundCount()) {
            int question = Util.getRandomInRange(1, 100);
            var correctAnswer = question % 2 == 0 ? "yes" : "no";
            game.getTask(task);
            System.out.println("Question: " + question);
            game.setAnswer();
            String playerAnswer = game.getAnswer();
            String answer = MessageFormat.format(game.getAnswerTemplate(), playerAnswer);
            System.out.println(answer);
            game.checkPlayerAnswer(player, playerAnswer, correctAnswer);
        }
        System.out.println("Congratulations," + player.getName() + "!");
    }
}
