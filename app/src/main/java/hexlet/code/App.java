package hexlet.code;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Player player = new Player("Start new game");
        Scanner sc = new Scanner(System.in);
        String startMsg = """
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                0 - Exit
                """;
        System.out.println(startMsg);
        System.out.println("Your choice:");
        var usrChose = sc.nextLine();
        switch (usrChose) {
            case "1":
                Cli.start(player);
                break;
            case "2":
                break;
            default:
                System.out.println("You must chose games(1-3) or quit(0)!");
                break;
        }

    }
}
