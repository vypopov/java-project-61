package hexlet.code;


import hexlet.code.Game.Even;
import hexlet.code.Game.Calc;
import hexlet.code.Game.GCD;
import hexlet.code.Game.Progression;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Player player = new Player("");
        Scanner sc = new Scanner(System.in);
        String startMsg = """
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                0 - Exit
                """;
        System.out.println(startMsg);
        var usrChose = sc.nextLine();
        System.out.printf("Your choice: %s%n", usrChose);
        switch (usrChose) {
            case "1" -> Cli.start(player);
            case "2" -> Even.start(player);
            case "3" -> Calc.start(player);
            case "4" -> GCD.start(player);
            case "5" -> Progression.start(player);
            case "0" -> {
                System.out.println("Exit...");
                System.exit(0);
            }
            default -> throw new UnsupportedOperationException("Invalid operation.");
        }
    }
}
