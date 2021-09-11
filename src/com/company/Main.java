package com.company;

import com.company.games.MinMax;
import com.company.games.RockPaperScissors;
import com.company.games.SortAndOrder;
import com.company.games.UpAndDown;

import java.util.Scanner;

public class Main {
//    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isPlaying;
        int selectedGame;
        String input;

        System.out.println("\nVälkommen till Det Roliga Spelet!!\n");
        displayOptions(false);


        while (true) {
//            selectedGame = 0;
            input = scanner.nextLine();
            if ("e".equalsIgnoreCase(input)) {
                System.out.println("Vi ses nästa gång!");
//                isPlaying = false;
                break;
            } else {
//                isPlaying = true;
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

            switch (selectedGame) {
                case 1 -> UpAndDown.start();
                case 2 -> MinMax.start();
                case 3 -> RockPaperScissors.start();
                case 4 -> SortAndOrder.start();
            }

            displayOptions(false);

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
