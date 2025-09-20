package hexlet.code.Game;

import hexlet.code.Player;
import hexlet.code.Util;
import hexlet.code.Engine;

import java.text.MessageFormat;


public class Calc {
    private static String task = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static String oper = "+-*";

    public static void start(Player player) {
        Engine game = new Engine(player);
        game.getTask(task);
        while (game.getNiceAnswerCnt() < game.getWinRoundCount()) {
            var currOper = oper.charAt(Util.getRandomInRange(0, oper.length() - 1));
            int numLeft = Util.getRandomInRange(0, 100);
            int numRight = Util.getRandomInRange(0, 100);
            String quetion = "Question: " + numLeft + currOper + numRight;
            int correctAnswer = 0;
            switch (currOper) {
                case '+':
                    correctAnswer = numLeft + numRight;
                    break;
                case '-':
                    correctAnswer = numLeft - numRight;
                    break;
                case '*':
                    correctAnswer = numLeft * numRight;
                    break;
                default:
                    System.out.println("Invalid operation!");
                    break;
            }
            System.out.println(quetion);
            game.setAnswer();
            String playerAnswer = game.getAnswer();
            String answer = MessageFormat.format(game.getAnswerTemplate(), playerAnswer);
            System.out.println(answer);
            game.checkPlayerAnswer(player, playerAnswer, String.valueOf(correctAnswer));
        }
        System.out.println("Congratulations," + player.getName() + "!");
    }
}
