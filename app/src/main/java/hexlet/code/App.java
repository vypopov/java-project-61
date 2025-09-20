package hexlet.code;


import hexlet.code.Game.Even;
import hexlet.code.Game.Calc;

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
                0 - Exit
                """;
        System.out.println(startMsg);
        var usrChose = sc.nextLine();
        System.out.println("Your choice:" + usrChose);
        switch (usrChose) {
            case "1":
                Cli.start(player);
                break;
            case "2":
                Even.start(player);
                break;
            case "3":
                Calc.start(player);
                break;
            default:
                System.out.println("You must chose games(1-3) or quit(0)!");
                break;
        }

    }
}
