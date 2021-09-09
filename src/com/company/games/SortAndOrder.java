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
        //läsa in en sträng som innehåller 5 tal
        Scanner scanner = new Scanner(System.in);
        boolean invalid;
        boolean sorted = true;
        int maximum = Integer.MIN_VALUE;
        int maximum2 = Integer.MIN_VALUE + 1;
        int minimum = Integer.MAX_VALUE;
        int minimum2 = Integer.MAX_VALUE - 1;
        int sum  = 0;
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

//        minimum = numbers[0];
//        nextMaximum = numbers[0];


        //LOOP - place numbers in order
        for (int i = 0; i < numbers.length; i++) {


            System.out.println(numbers[i]);
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            //where numbers not sorted: sorted = false
            if (numbers[i] > numbers[i + 1]) {
                sorted = false;
                break;
            }
        }


//        for (int number : numbers) {
//            System.out.println(number);
//        }

        System.out.println("Min value: " + minimum);
        System.out.println("Min2 value: " + minimum2);
        System.out.println("Max value: " + maximum);
        System.out.println("Max2 value: " + maximum2);
        System.out.println("I ordning: " + sorted);
        System.out.println("Summa: " + sum);

        // hitta & printa summa

    }
}

/**
 * for (int j = 1; j < numbers.length - 1; j++) {
 * int placeholder;
 * if (i == j)
 *                     continue;
 * if (numbers[i] > numbers[j]) {
 * placeholder = numbers[i];
 * numbers[i] = numbers[j];
 * numbers[j] = placeholder;
 * sorted = false; //todo: sorted here or below?
 * }
 * }
 * <p>
 * if (numbers[i] < minimum2)
 * minimum2 = numbers[i];
 * <p>
 * if (minimum2 < minimum) {
 * int placeholder = minimum;
 * minimum = minimum2;
 * minimum2 = placeholder;
 * }
 * <p>
 * if (numbers[i] > maximum2)
 * maximum2 = numbers[i];
 * <p>
 * if (maximum2 > maximum) {
 * int placeholder = maximum;
 * maximum = maximum2;
 * maximum2 = placeholder;
 * }
 */

/**
 * if (numbers[i] < minimum2)
 *                 minimum2 = numbers[i];
 *
 *             if (minimum2 < minimum) {
 *                 int placeholder = minimum;
 *                 minimum = minimum2;
 *                 minimum2 = placeholder;
 *             }
 *
 *             if (numbers[i] > maximum2)
 *                 maximum2 = numbers[i];
 *
 *             if (maximum2 > maximum) {
 *                 int placeholder = maximum;
 *                 maximum = maximum2;
 *                 maximum2 = placeholder;
 *             }
 */

/**
 * Third attempt:
 *
 *  for (int number : numbers) {
 * //            sum += number;
 * //            if (number < minimum)
 * //                minimum = number;
 * //            if (number > maximum)
 * //                maximum = number;
 * //            if(number > maximum2 && number < maximum)
 * //                maximum2 = number;
 * //            if(number < minimum2 && number > minimum)
 * //                minimum2 = number;
 * //        }
 */
