package com.tic_tac_toe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private final Board board;
    private boolean player1Turn;
    private int moves;
    private final boolean playAgainstCpu;

    public TicTacToe(boolean playAgainstCpu) {
        this.board = new Board();
        this.player1Turn = true;
        this.moves = 0;
        this.playAgainstCpu = playAgainstCpu;
    }

    public void start(Scanner scanner) {
        board.print();

        while (moves < 9) {
            char currentSymbol = player1Turn ? 'X' : 'O';

            if (player1Turn) {
                System.out.println("*** Player 1 turn: X ***");
                makeHumanMove(scanner, currentSymbol);
            } else {
                if (playAgainstCpu) {
                    System.out.println("*** CPU turn: O ***");
                    makeCpuMove(currentSymbol);
                } else {
                    System.out.println("*** Player 2 turn: O ***");
                    makeHumanMove(scanner, currentSymbol);
                }
            }

            board.print();

            if (checkWinner(currentSymbol)) {
                System.out.println((player1Turn ? "Player 1" : "CPU") + " wins!");
                return;
            }

            player1Turn = !player1Turn;
            moves++;
        }
        System.out.println("Draw. Good game!");
    }

    private void makeHumanMove(Scanner scanner, char symbol) {
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
                scanner.nextLine();
            }
        }
    }

    private void makeCpuMove(char symbol) {
        boolean valid = false;

        while (!valid) {
            int row = random.nextInt(3);
            int col = random.nextInt(3);

            if (board.setMove(row, col, symbol)) {
                valid = true;
                System.out.println("CPU played at row " + row + ", column " + col);
            }
        }
    }

    private boolean checkWinner(char s) {
        char[][] g = board.getGrid();
        for (int i = 0; i < 3; i++) {
            if ((g[i][0] == s && g[i][1] == s && g[i][2] == s)
                    || (g[0][i] == s && g[1][i] == s && g[2][i] == s)) {
                return true;
            }
        }
        return (g[0][0] == s && g[1][1] == s && g[2][2] == s)
                || (g[0][2] == s && g[1][1] == s && g[2][0] == s);
    }

    private final Random random = new Random();

}
