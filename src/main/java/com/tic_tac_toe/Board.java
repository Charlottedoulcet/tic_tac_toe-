package com.tic_tac_toe;

public class Board {

    private final char[][] grid;

    public Board() {
        grid = new char[3][3];
        initialize();
    }

    private void initialize() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = '-';
            }
        }
    }

    public void print() {
        System.out.println("     0     1     2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + "    ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j]);
                if (j < 3) {
                    System.out.print("  |  ");
                }
            }
            System.out.println();
            if (i < 3) {
                System.out.println("    -----------------");
            }
        }
    }

    public boolean setMove(int row, int col, char symbol) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && grid[row][col] == '-') {
            grid[row][col] = symbol;
            return true;
        }
        return false;
    }

    public char[][] getGrid() {
        return grid;
    }
}
