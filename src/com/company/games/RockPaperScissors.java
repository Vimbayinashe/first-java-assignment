package com.company.games;

import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        start();
    }

    static Scanner scanner = new Scanner(System.in);

    public static void start() {
        System.out.println(
                """
                Spela sten, sax eller påse!
                
                Regler:
                Du spelar mot datorn och först till 3 vinster vinner.
                Sten vinner över sax.
                Sax vinner över påse.
                Påse vinner över sten.
                                
                Tryck S, X eller P för att välja:
                S - sten
                X - sax
                P - påse
                """
        );

//        play();
    }
}
