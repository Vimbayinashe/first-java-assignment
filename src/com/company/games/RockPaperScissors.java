package com.company.games;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        start();
    }

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

    enum Options {ROCK, PAPER, SCISSORS}

    private static void play() {
        int computerScore = 0;
        int playerScore = 0;
        char[] options = {'s', 'x', 'p'};
        Random random = new Random();

        System.out.println("Sten, sax eller påse?");    //todo: remove?

        while (computerScore < 3 || playerScore < 3) {
            //player enters a move
            String playerInput = (scanner.nextLine()).toLowerCase();


            //move is stored or exception handling
            char playerSelection;
            boolean valid = false;

            if ("s".equals(playerInput) || "x".equals(playerInput) || "p".equals(playerInput)) {
                playerSelection = playerInput.charAt(0);
                System.out.println("Spelaren har valt: " + playerSelection);
            } else {
                System.out.println("Ogiltigt val, försök igen");
                continue;
            }

            //computer selects a move
            int randomIndex = random.nextInt(3);
            char computerSelection = options[randomIndex];


            System.out.println("Datorn har valt: " + computerSelection);


            ++playerScore;

            boolean computerWins = computerSelection == 's' && playerSelection == 'x'
                    || computerSelection == 'x' && playerSelection == 'p'
                    || computerSelection == 'p' && playerSelection == 's';
//            boolean playerWins = playerInput.equals("s") &&

            //comparison of computer vs player moves
            if (computerSelection == playerSelection)
                System.out.println("Datorn och spelare har gjort samma val.\n");
            else if (computerWins) {
                System.out.println("Datorn har vunnit denna omgång!\n");
                ++computerScore;
            } else {
                System.out.println("Du har vunnit denna omgång!\n");
                ++playerScore;
            }

            //sout omgångens resultat & poängställningen för båda  & begäran att välja igen

            // if winner gets 1 point

            //repeat play until one has 3 points
        }

        //congrats message to winner


    }

    private static void invalidGuess() {
        System.out.println("Ogiltigt val, försök igen");
        scanner.nextLine();
    }

    /**
     *   Options[] options = {Options.ROCK, Options.PAPER, Options.SCISSORS};
     *         Random random = new Random();
     *
     *         while (computerScore < 3 || playerScore < 3)  {
     *             int randomIndex = random.nextInt(3);
     *
     *             System.out.println("Datorn har gjort sitt val. Det är din tur...");
     *
     *             String playerInput = scanner.nextLine();
     *
     *             if (playerInput.toLowerCase() == "s")
     *
     *             Options playerGuess;
     *
     *
     *
     *             switch (playerInput.toLowerCase()) {
     *                 case "r" -> playerGuess = Options.ROCK;
     *                 case "p" -> playerGuess = Options.PAPER;
     *                 case "s" -> playerGuess = Options.SCISSORS;
     *                 default -> invalidGuess();
     *             };
     *             //todo: how do we handle invalid input
     *
     *         }
     */
}
