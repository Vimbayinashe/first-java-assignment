package com.company;

import com.company.games.MinMax;
import com.company.games.RockPaperScissors;
import com.company.games.SortAndOrder;
import com.company.games.UpAndDown;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int selectedGame;
        String input;
        System.out.println("\nVälkommen till Det Roliga Spelet!!\n");
        displayOptions(false);

        while (true) {
            input = scanner.nextLine();
            if ("e".equalsIgnoreCase(input)) {
                break;
            } else {
                try {
                    selectedGame = Integer.parseInt(input);
                } catch (NumberFormatException ignored) {
                    displayOptions(true);
                    continue;
                }
            }
            if (selectedGame > 4 || "0".equals(input)) {
                displayOptions(true);
                continue;
            }

            playGame(selectedGame);
            displayOptions(false);
        }

    }

    public static void displayOptions(boolean invalid) {
        if (invalid)
            System.out.println("Ogiltigt val, försök igen!\n");
        System.out.println(
                """           
                                                
                        Vänligen skriv ett nummer för att välja ett spel eller tryck "e" för att avsluta.
                        1. Upp och Ner
                        2. Min Max
                        3. Sten Sax Påse
                        4. Ordning och reda
                        e. Avsluta
                        """
        );
    }

    private static void playGame(int selectedGame) {
        switch (selectedGame) {
            case 1 -> UpAndDown.start();
            case 2 -> MinMax.start();
            case 3 -> RockPaperScissors.start();
            case 4 -> SortAndOrder.start();
        }
    }
}
