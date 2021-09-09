package com.company.games;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static Scanner scanner = new Scanner(System.in);

    public static void start() {
        System.out.println(
                """
                        Spela sten, sax eller påse!
                                        
                        Regler:
                        Du spelar mot datorn och först till 3 vinster vinner.
                        Sten vinner över sax.
                        Sax vinner över påse.
                        Påse vinner över sten.
                                        
                        Tryck S, X eller P för att välja:
                        S - sten
                        X - sax
                        P - påse
                        """
        );

        play();
    }

    private static void play() {
        int computerScore = 0;
        int playerScore = 0;
        String[] options = {"s", "x", "p"};
        Random random = new Random();


        while (computerScore < 3 && playerScore < 3) {
            System.out.println("Välj sten, sax eller påse...");

            String playerInput = (scanner.nextLine()).toLowerCase();

            String playerMove;
            if ("s".equals(playerInput) || "x".equals(playerInput) || "p".equals(playerInput)) {
                playerMove = selectTool(playerInput);
            } else {
                System.out.println("Ogiltigt val, försök igen");
                continue;
            }

            String computerSelection = options[random.nextInt(3)];

            System.out.println("Du har valt " + playerMove + " och datorn har valt " + selectTool(computerSelection));

            boolean computerWins = computerSelection.equals("s") && playerInput.equals("x")
                    || computerSelection.equals("x") && playerInput.equals("p")
                    || computerSelection.equals("p") && playerInput.equals("s");

            if (computerSelection.equals(playerInput)) {
                System.out.println("Datorn och spelare har gjort samma val.");
            } else if (computerWins) {
                System.out.println("Datorn har vunnit denna omgång!");
                ++computerScore;
            } else {
                System.out.println("Du har vunnit denna omgång!");
                ++playerScore;
            }

            System.out.println("Du har " + playerScore + " poäng och datorn har " + computerScore + " poäng.\n");

        }

        if (computerScore > playerScore)
            System.out.println("Datorn har vunnit spelet!");
        else
            System.out.println("Grattis! Du har vunnit spelet!");

    }

    private static String selectTool(String playerInput) {
        return switch (playerInput) {
            case "s" -> "sten";
            case "x" -> "sax";
            case "p" -> "påse";
            default -> "ogiltigt";
        };
    }

}
