package com.tic_tac_toe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            TicTacToe game = new TicTacToe();
            game.start(scanner);
        }
    }
}