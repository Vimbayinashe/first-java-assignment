package com.company.games;

import java.util.Scanner;

public class UpAndDown {

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
        boolean nextWord = true;
        int index = 0;
        String[] words = new String[5];

        while (nextWord) {
            System.out.println("Skriv ett ord...");
            String input = scanner.nextLine();

            if ("END".equals(input))
                nextWord = false;
            else {
                if (index >= words.length)
                    words = grow(words);
                words[index] = input;
                ++index;
            }
        }

        printResult(words);
    }

    private static String[] grow(String[] array) {
        String[] newArray = new String[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
        return array;
    }

    private static void printResult(String[] words) {
        System.out.println("\nDina ord i omvänd ordning:");
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i] != null)
                System.out.println(words[i]);
        }
    }

    public static void main(String[] args) {
        start();
    }

}
