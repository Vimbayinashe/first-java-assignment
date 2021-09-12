package com.company.games;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static Scanner scanner = new Scanner(System.in);

    public static void start() {
        printInstructions();
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
            Tool playerChoice;

            try {
                playerChoice = selectTool(playerInput);
            } catch (RuntimeException ignored) {
                System.out.println("Ogiltigt val, försök igen!");
                continue;
            }

            String computerInput = options[random.nextInt(3)];
            Tool computerChoice = selectTool(computerInput);

            boolean computerWins = computerWins(computerChoice, playerChoice);
            boolean draw = computerChoice.equals(playerChoice);

            if (computerWins)
                ++computerScore;
            else
                ++playerScore;

            printChoices(playerChoice, computerChoice);
            printCurrentResult(computerWins, draw);
            printPoints(computerScore, playerScore);

        }

        printFinalResult(computerScore, playerScore);

    }

    enum Tool { ROCK, PAPER, SCISSORS }

    private static Tool selectTool(String input) {
        return switch (input) {
            case "s" -> Tool.ROCK;
            case "x" -> Tool.SCISSORS;
            case "p" -> Tool.PAPER;
            default -> throw new RuntimeException();
        };
    }

    private static boolean computerWins(Tool computerChoice, Tool playerChoice) {
        return computerChoice.equals(Tool.ROCK) && playerChoice.equals(Tool.SCISSORS) ||
                computerChoice.equals(Tool.SCISSORS) && playerChoice.equals(Tool.PAPER) ||
                computerChoice.equals(Tool.PAPER) && playerChoice.equals(Tool.ROCK);
    }

    private static String toolInSwedish(Tool tool) {
        return switch (tool) {
            case ROCK -> "sten";
            case SCISSORS -> "sax";
            case PAPER -> "påse";
        };
    }

    private static void printChoices(Tool playerChoice, Tool computerChoice) {
        System.out.println(
                "Du har valt " + toolInSwedish(playerChoice) +
                " och datorn har valt " + toolInSwedish(computerChoice) + "."
        );
    }

    private static void printCurrentResult(boolean computerWins, boolean draw) {
        if (draw) {
            System.out.println("Datorn och spelare har gjort samma val.");
        } else if (computerWins) {
            System.out.println("Datorn har vunnit denna omgång!");

        } else {
            System.out.println("Du har vunnit denna omgång!");
        }
    }

    private static void printPoints(int computerScore, int playerScore) {
        System.out.println("Du har " + playerScore + " poäng och datorn har " + computerScore + " poäng.\n");
    }

    private static void printFinalResult(int computerScore, int playerScore) {
        if (computerScore > playerScore)
            System.out.println("Datorn har vunnit spelet!");
        else
            System.out.println("Grattis! Du har vunnit spelet!");
    }

    private static void printInstructions() {
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
    }

    public static void main(String[] args) {
        start();
    }

}
