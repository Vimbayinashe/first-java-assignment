package com.company.games;

import java.util.Scanner;

public class SortAndOrder {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        System.out.println(
                """
                        
                        Välkommen till Ordning och Reda!
                                        
                        Vänligen skriv in 5 heltal med ett mellanslag mellan varje tal.
                        (t.ex. 5 15 -5 0 23)
                        Tryck ENTER när du är klar.
                        """
        );

        play();

    }

    private static void play() {
        Scanner scanner = new Scanner(System.in);
        boolean invalid;
        boolean sorted;
        int sum = 0;
        int[] numbers = new int[5];

        do {
            invalid = false;
            String input = scanner.nextLine();
            String[] numbersAsStrings = input.split(" ");

            if (numbersAsStrings.length != 5) {
                System.out.println("Vänligen skriv in 5 heltal (med ett mellanrum mellan varje tal).");
                invalid = true;
                continue;
            }

            for (int i = 0; i < numbersAsStrings.length; i++) {
                try {
                    numbers[i] = Integer.parseInt(numbersAsStrings[i]);
                } catch (NumberFormatException ignored) {
                    System.out.println("Vänligen skriv in ENDAST 5 heltal");
                    invalid = true;
                    break;
                }
            }

        } while (invalid);

        sorted = isSorted(numbers);
        sortArrayOfIntegers(numbers);
        sum = sum(numbers);
        printResult(sorted, sum, numbers);

    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number: numbers) {
            sum += number;
        }
        return sum;
    }

    private static void sortArrayOfIntegers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {

            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] > numbers[j]) {
                    int placeholder = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = placeholder;
                }

            }

        }
    }

    private static boolean isSorted(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static void printResult(boolean sorted, int sum, int[] numbers) {
        System.out.println("Min value: " + numbers[0]);
        System.out.println("Min2 value: " + numbers[1]);
        System.out.println("Max2 value: " + numbers[numbers.length - 2]);
        System.out.println("Max value: " + numbers[numbers.length - 1]);
        System.out.println("I ordning: " + sorted);
        System.out.println("Summa: " + sum);
    }
}

