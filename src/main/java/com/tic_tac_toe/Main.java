package com.tic_tac_toe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("🎮 WELCOME TO TIC TAC TOE 🎮");
            System.out.println("Choose game mode:");
            System.out.println("1 - Player vs Player");
            System.out.println("2 - Player vs CPU");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();

            boolean playAgainstCpu = (choice == 2);

            TicTacToe game = new TicTacToe(playAgainstCpu);
            game.start(scanner);
        }
    }
}
