package hexlet.code.Game;

import hexlet.code.Player;
import hexlet.code.Util;
import hexlet.code.Engine;

public class Calc {
    private static final String TASK = "What is the result of the expression?";
    private static final String OPERATION = "+-*";

    public static void start(Player player) {
        Engine game = new Engine(player);
        game.getTask(TASK);
        while (game.getNiceAnswerCnt() < game.getWinRoundCount()) {
            var currentOperation = OPERATION.charAt(Util.getRandomInRange(0, OPERATION.length() - 1));
            int numLeft = Util.getRandomInRange(0, 100);
            int numRight = Util.getRandomInRange(0, 100);
            String question = "" + numLeft + currentOperation + numRight;
            int correctAnswer = switch (currentOperation) {
                case '+' -> numLeft + numRight;
                case '-' -> numLeft - numRight;
                case '*' -> numLeft * numRight;
                default -> throw new UnsupportedOperationException("Invalid operation.");
            };
            game.gameRulesCheck(player, question, String.valueOf(correctAnswer));
        }
        game.getWinMessage(player);
    }
}
