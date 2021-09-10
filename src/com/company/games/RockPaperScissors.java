package com.company.games;

import javax.tools.Tool;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static Scanner scanner = new Scanner(System.in);

    public static void start() {
        instructions();
        play();
    }

    private static void instructions() {
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

    private static void play() {
        int computerScore = 0;
        int playerScore = 0;
        String[] options = {"s", "x", "p"};
        Random random = new Random();


        while (computerScore < 3 && playerScore < 3) {
            System.out.println("Välj sten, sax eller påse...");

            String playerInput = (scanner.nextLine()).toLowerCase();
//            boolean invalidTool = checkInvalidTool(playerInput);

            // converting to enum
            Tool playerChoice;

            try {
                playerChoice = tool(playerInput);
            } catch (RuntimeException ignored) {
                System.out.println("Ogiltigt val, försök igen");
                continue;
            }

//            if (invalidTool)
//                continue;

            String computerInput = options[random.nextInt(3)];
            Tool computerChoice = tool(computerInput);

//            printPlayersChoices(playerInput, computerSelection);

            System.out.println("Du har valt " + playerChoice + " och datorn har valt " + selectTool(computerInput));

            //todo: egen metod
            boolean computerWins = computerInput.equals("s") && playerInput.equals("x")
                    || computerInput.equals("x") && playerInput.equals("p")
                    || computerInput.equals("p") && playerInput.equals("s");

            //todo: egen metod för if-sats
            if (computerInput.equals(playerInput)) {
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

    enum Tool { ROCK, PAPER, SCISSORS }

    //converting guess to a valid tool
    private static Tool tool(String input) {
        return switch (input) {
            case "s" -> Tool.ROCK;
            case "x" -> Tool.SCISSORS;
            case "p" -> Tool.PAPER;
            default -> throw new RuntimeException();
        };
    }

    private static String selectTool(String playerInput) {
        return switch (playerInput) {
            case "s" -> "sten";
            case "x" -> "sax";
            case "p" -> "påse";
            default -> "ogiltigt";
            //String har många flera kombinationer som måste hanteras eller testa att använda en enum
        };
    }

    public static void main(String[] args) {
        play();
    }

}
