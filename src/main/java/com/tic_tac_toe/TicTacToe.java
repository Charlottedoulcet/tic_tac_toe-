package com.tic_tac_toe;

import java.util.Scanner;

public class TicTacToe {

    private final Board board;
    private boolean player1Turn;
    private int moves;

    public TicTacToe() {
        this.board = new Board();
        this.player1Turn = true;
        this.moves = 0;
    }

    public void start(Scanner scanner) {
        System.out.println(" Welcome to Tic Tac Toe ");
        board.print();

        while (moves < 9) {
            char currentSymbol = player1Turn ? 'X' : 'O';
            System.out.println("*** Player " + (player1Turn ? "1" : "2") + " turn: " + currentSymbol + " ***");

            makeMove(scanner, currentSymbol);
            board.print();

            if (checkWinner(currentSymbol)) {
                System.out.println("¡Player " + (player1Turn ? "1 " : "2 ")  + currentSymbol + " wins!");
                return;
            }

            player1Turn = !player1Turn;
            moves++;
        }
        System.out.println("Draw. Good game!");
    }

    private void makeMove(Scanner scanner, char symbol) {
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Enter row (0-2): ");
                int row = scanner.nextInt();
                System.out.print("Enter column (0-2): ");
                int col = scanner.nextInt();

                if (board.setMove(row, col, symbol)) {
                    valid = true;
                } else {
                    System.out.println("Invalid move! Space occupied or out of range.");
                }
            } catch (Exception e) {
                System.out.println("Error: Enter valid numbers.");
                scanner.nextLine(); // Limpiar buffer
            }
        }
    }

    private boolean checkWinner(char s) {
        char[][] g = board.getGrid();
        // Filas y Columnas
        for (int i = 0; i < 3; i++) {
            if ((g[i][0] == s && g[i][1] == s && g[i][2] == s)
                    || (g[0][i] == s && g[1][i] == s && g[2][i] == s)) {
                return true;
            }
        }
        // Diagonales
        return (g[0][0] == s && g[1][1] == s && g[2][2] == s)
                || (g[0][2] == s && g[1][1] == s && g[2][0] == s);
    }
}
