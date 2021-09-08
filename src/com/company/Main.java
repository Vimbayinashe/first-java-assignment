package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String gameOptions = """           
                Vänligen skriv ett nummer för att välja ett spel eller tryck "e" för att avsluta.
                1. Upp och Ner
                2. Min Max
                3. Sten Sax Påse
                4. Ordning och reda
                e. Avsluta
                """;

        System.out.println("\nVälkommen till Det Roliga Spelet!!\n");
        System.out.println(gameOptions);

        String input = scanner.nextLine();

        int selectedGame = 0;

        if ("e".equals(input.toLowerCase())) {
            System.out.println("Vi ses nästa gång!");
        } else {
            try {
                selectedGame = Integer.parseInt(input);
            } catch (NumberFormatException ignored) {
                System.out.println("Ogiltigt val, försök igen!\n");
                System.out.println(gameOptions);
            }
        }

        //use switch for both scenarios
        //handle 4 valid numbers

        //handle invalid number -> 0 or greater than 4  => request correct input

        
//        switch (input) {
//            case Integer.parseInt(input) -> System.out.println("integer");
//        }
    }
}
