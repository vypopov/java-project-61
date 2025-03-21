package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void start(Player player) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            player.setName(sc.nextLine());
            System.out.println("Hello, "
                    + player.getName() + "!");
            sc.close();
        } else {
            System.out.println("No name entered!");
        }
    }
}