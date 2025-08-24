package hexlet.code.Game;

import hexlet.code.Engine;
import hexlet.code.Player;
import hexlet.code.Util;
import java.text.MessageFormat;

public class Even {
    private static final String  WRONGANSWER_TEMPLATE = """
        '{0}' is wrong answer ;(. Correct answer was '{1}'.
        Let's try again, {2}!""";
    private static String task = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void start(Player player) {
        int question = Util.getRandomInRange(1, 100);
        var correctAnswer = question % 2 == 0 ? "yes" : "no";
        Engine game = new Engine(player);
        game.getTask(task);
        System.out.println("Question: " + question);
        game.setAnswer();
        String playerAnswer = game.getAnswer();
        String answer = MessageFormat.format(game.getAnswerTemplate(), playerAnswer);
        System.out.println(answer);

        game.checkPlayerAnswer(player, playerAnswer, correctAnswer, WRONGANSWER_TEMPLATE);
    }
}
