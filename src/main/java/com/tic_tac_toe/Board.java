package com.tic_tac_toe;

public class Board {
    private final char[][] board;

    public Board() {
        board = new char[3][3];
        reset();
    }

    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void print() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean placeMark(int fila, int columna, char mark) {
        if (!isInRange(fila, columna))
            return false;
        if (board[fila][columna] != '-')
            return false;
        board[fila][columna] = mark;
        return true;
    }

    public boolean hasWinner(char mark) {
        return (board[0][0] == mark && board[0][1] == mark && board[0][2] == mark)
                || (board[1][0] == mark && board[1][1] == mark && board[1][2] == mark)
                || (board[2][0] == mark && board[2][1] == mark && board[2][2] == mark)
                || (board[0][0] == mark && board[1][0] == mark && board[2][0] == mark)
                || (board[0][1] == mark && board[1][1] == mark && board[2][1] == mark)
                || (board[0][2] == mark && board[1][2] == mark && board[2][2] == mark)
                || (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark)
                || (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark);
    }

    private boolean isInRange(int fila, int columna) {
        return fila >= 0 && fila <= 2 && columna >= 0 && columna <= 2;
    }
}
