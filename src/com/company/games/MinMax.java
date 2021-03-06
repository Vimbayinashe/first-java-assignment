package com.company.games;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MinMax {

    static Scanner scanner = new Scanner(System.in);

    public static void start() {
        printInstructions();
        play();
    }

    private static void play() {
        int[] numbers = new int[5];
        int count = 0;
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;

        while (count < 5) {
            try {
                int input = scanner.nextInt();
                numbers[count] = input;
                ++count;
            } catch (InputMismatchException ignored) {
                System.out.println("Vänligen skriv in ett heltal.");
                scanner.nextLine();
            }
        }

        for (int number : numbers) {
            if (number < minimum)
                minimum = number;
            if (number > maximum)
                maximum = number;
        }

        printResult(maximum, minimum);

    }

    private static void printResult(int maximum, int minimum) {
        System.out.println("Min value: " + minimum);
        System.out.println("Max value: " + maximum);
    }

    private static void printInstructions() {
        System.out.println(
                """
                
                Välkommen till Min Max!
                Vänligen skriv in 5 heltal (tryck ENTER efter varje tal).
                """
        );
    }

    public static void main(String[] args) {
        start();
    }
}
