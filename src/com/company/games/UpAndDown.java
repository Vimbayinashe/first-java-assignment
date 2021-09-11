package com.company.games;

import java.util.ArrayList;
import java.util.Scanner;

public class UpAndDown {
    //Todo: is the main method needed?

    static Scanner scanner = new Scanner(System.in);

    public static void start() {
        System.out.println(
            """
            
            Välkommen till upp och ner!
            
            Instruktioner:
             - Skriv in ett antal ord och tryck ENTER mellan varje ord.
             - Skriv END när du är klar.
            """
        );

        play();
        
    }

    private static void play() {
        ArrayList<String> words = new ArrayList<String>();
        boolean nextWord = true;        //inputting, typing, addWord, addingWords

        while (nextWord) {
            System.out.println("Skriv ett ord...");
            String input = scanner.nextLine();

            if("END".equals(input))
                nextWord = false;
            else
                words.add(input);
        }

        printResult(words);
    }

    private static void printResult(ArrayList<String> words) {
        System.out.println("\nDina ord i omvänd ordning:");
        for (int i = words.size(); i > 0; i--) {
            System.out.println(words.get(i - 1));
        }
    }

}
