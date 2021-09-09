package com.company;

import com.company.games.MinMax;
import com.company.games.RockPaperScissors;
import com.company.games.SortAndOrder;
import com.company.games.UpAndDown;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean invalidGame;
        int selectedGame;
        String input;

        System.out.println("\nVälkommen till Det Roliga Spelet!!\n");
        displayOptions(false);


        do {
            selectedGame = 0;
            input = scanner.nextLine();
            if ("e".equalsIgnoreCase(input)) {
                invalidGame = false;
                System.out.println("Vi ses nästa gång!");
            } else {
                try {
                    invalidGame = false;
                    selectedGame = Integer.parseInt(input);
                } catch (NumberFormatException ignored) {
                    displayOptions(true);
                    invalidGame = true;
                }
            }
            if (selectedGame > 4 || "0".equals(input)) {
                invalidGame = true;
                displayOptions(true);
            }

        } while (invalidGame);


        switch (selectedGame) {
            case 1 -> UpAndDown.start();
            case 2 -> MinMax.start();
            case 3 -> RockPaperScissors.start();
            case 4 -> SortAndOrder.start();
        }

        //Todo: när körningen är klar ska menyn åter skrivas ut på skärmen så att ett nytt val kan göras => alltså
        // spelet avslutas när man tryckt "e"

        // place entire game in a separate method ?
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
}
