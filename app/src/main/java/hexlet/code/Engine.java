package hexlet.code;

import java.text.MessageFormat;
import java.util.Scanner;

public class Engine {
    private int niceAnswerCnt;
    private final int winRoundCount = 3;
    private String answerTemplate = "Your answer: {0}";
    private String answer;

    public Engine(Player player) {
        niceAnswerCnt = 0;
        Cli.start(player);
    }

    public void setNiceAnswerCntDefault() {
        this.niceAnswerCnt = 0;
    }

    public void setNiceAnswerCnt() {
        this.niceAnswerCnt++;
    }
    public int getNiceAnswerCnt() {
        return this.niceAnswerCnt;
    }

    public int getWinRoundCount() {
        return this.winRoundCount;
    }

    public String getTask(String task) {
        return task;
    }

    public String getAnswerTemplate() {
        return this.answerTemplate;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer() {
        Scanner sc = new Scanner(System.in);
        try {
            if (sc.hasNextLine()) {
                this.answer = sc.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Input error: " + e.getMessage());
        }
    }

    public void checkPlayerAnswer(Player player, String playerAnswer, String correctAnswer, String wrongAnswerMessage) {
        if (playerAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
            setNiceAnswerCnt();
        } else {
            System.out.println(MessageFormat.format(wrongAnswerMessage, playerAnswer, correctAnswer, player.getName()));
            setNiceAnswerCntDefault();
            System.exit(0);
        }
    }
}
