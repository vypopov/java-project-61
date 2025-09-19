package hexlet.code;

import java.text.MessageFormat;
import java.util.Scanner;

public class Engine {
    private int niceAnswerCnt;
    private static final int winRoundCount = 3;
    private String answerTemplate = "Your answer: {0}";
    private String answer;
    private String wrongAnswerTemplate = "{0} is wrong answer ;(. Correct answer was {1}.";

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
            throw new RuntimeException("Error", e);
        }
    }

    public void checkPlayerAnswer(Player player, String playerAnswer, String correctAnswer) {
        if (playerAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
            setNiceAnswerCnt();
        } else {
            System.out.println(
                    MessageFormat.format(
                            wrongAnswerTemplate,
                            "'" + playerAnswer + "'",
                            "'" + correctAnswer + "'")
            );
            System.out.println("Let's try again, " + player.getName() + "!");
            setNiceAnswerCntDefault();
            System.exit(0);
        }
    }
}
