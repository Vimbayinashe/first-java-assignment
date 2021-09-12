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
        int maximum;
        int minimum;
        int nextMaximum;
        int nextMinimum;
        int sum;
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

        maximum = maximum(numbers);
        nextMaximum = nextMaximum(numbers, maximum);
        minimum = minimum(numbers);
        nextMinimum = nextMinimum(numbers, minimum);
        sorted = isSorted(numbers);
        sum = sum(numbers);

        printResults(minimum, nextMinimum, maximum, nextMaximum, sorted, sum);

    }

    private static int maximum(int[] numbers) {
        int maximum = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (maximum < number)
                maximum = number;
        }
        return maximum;
    }

    private static int nextMaximum(int[] numbers, int maximum) {
        int nextMaximum = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (nextMaximum < number && number < maximum)
                nextMaximum = number;
        }
        return nextMaximum;
    }

    private static int minimum(int[] numbers) {
        int minimum = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number < minimum)
                minimum = number;
        }
        return minimum;
    }

    private static int nextMinimum(int[] numbers, int minimum) {
        int nextMinimum = Integer.MAX_VALUE;
        for (int number: numbers) {
            if(minimum < number && number < nextMinimum)
                nextMinimum = number;
        }
        return nextMinimum;
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number: numbers) {
            sum += number;
        }
        return sum;
    }

    private static boolean isSorted(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static void printResults(Object... objects) {
        System.out.println("Minsta talet: " + objects[0]);
        System.out.println("Näst minsta talet: " + objects[1]);
        System.out.println("Största talet: " + objects[2]);
        System.out.println("Näst största talet: " + objects[3]);
        System.out.println("I ordning: " + objects[4]);
        System.out.println("Summa: " + objects[5]);
    }

}

