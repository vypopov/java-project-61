package hexlet.code.games;

import hexlet.code.Player;
import hexlet.code.Util;
import hexlet.code.Engine;

public class Calc {
    private static final String TASK = "What is the result of the expression?";
    private static final String OPERATION = "+-*";
    private static final int MIN_BOUND = 1;
    private static final int MAX_BOUND = 100;

    public static void start(Player player) {
        Engine game = new Engine(player);
        game.getTask(TASK);
        while (game.getNiceAnswerCnt() < game.getWinRoundCount()) {
            var currentOperation = OPERATION.charAt(Util.getRandomInRange(MIN_BOUND - 1, OPERATION.length() - 1));
            int numLeft = Util.getRandomInRange(MIN_BOUND, MAX_BOUND);
            int numRight = Util.getRandomInRange(MIN_BOUND, MAX_BOUND);
            String question = String.format("%s %s %s", numLeft, currentOperation, numRight);
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
