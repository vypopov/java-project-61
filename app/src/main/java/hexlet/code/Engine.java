package hexlet.code;

import java.util.Scanner;

public final class Engine {
    private int niceAnswerCnt;
    private static final int WINROUNDCOUNT = 3;
    private final String answerTemplate = "Your answer: %s%n";
    private String answer;
    private final String wrongAnswerTemplate = "'%s' is wrong answer ;(. Correct answer was '%s'.%n";
    private final String congratulationsTemplate = "Congratulations, %s!%n";
    private final String questionTemplate = "Question: %s%n";

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
        return WINROUNDCOUNT;
    }

    public void getTask(String task) {
        System.out.println(task);
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

    public void getQuestion(String params) {
        System.out.printf(questionTemplate, params);
    }

    public void checkPlayerAnswer(Player player, String playerAnswer, String correctAnswer) {
        if (playerAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
            setNiceAnswerCnt();
        } else {
            System.out.printf(wrongAnswerTemplate, playerAnswer, correctAnswer);
            System.out.printf("Let's try again, %s!%n", player.getName());
            setNiceAnswerCntDefault();
            System.exit(0);
        }
    }

    public void gameRulesCheck(Player player, String question, String correctAnswer) {
        getQuestion(question);
        setAnswer();
        System.out.printf(getAnswerTemplate(), getAnswer());
        checkPlayerAnswer(player, getAnswer(), correctAnswer);
    }
    public void getWinMessage(Player player) {
        System.out.printf(congratulationsTemplate, player.getName());
    }
}
