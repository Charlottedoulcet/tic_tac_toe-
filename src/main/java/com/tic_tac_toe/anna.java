package com.tic_tac_toe;

import java.util.Scanner;

public class anna {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(" Welcome to Tic Tac Toe ");

            // 1. Inicializar el tablero
            char[][] board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = '-';
                }
            }

            printBoard(board);

            // Configuración inicial del juego
            boolean turnoJugador1 = true;
            int turno = 1;
            boolean ganador = false;

            // Loop del juego
            do {
                mostrarTurno(turnoJugador1);
                
                // Tomar coordenadas (pasamos el scanner para no crear múltiples instancias)
                tomarCoordenadas(board, turnoJugador1, scanner);
                
                // Comprobar si alguien ganó
                ganador = comprobarFinJuego(board, turnoJugador1);
                
                // Imprimir el tablero después de la jugada
                printBoard(board);

                if (ganador) {
                    if (turnoJugador1) {
                        System.out.println("¡Gana jugador 1 'X'!");
                    } else {
                        System.out.println("¡Gana jugador 2 'O'!");
                    }
                } else {
                    // Cambiar el turno solo si no hay ganador
                    turnoJugador1 = !turnoJugador1;
                    turno++;
                }

            } while (turno <= 9 && !ganador);

            // Si terminan los turnos y no hay ganador
            if (!ganador) {
                System.out.println("Es un empate. ¡Buen juego!");
            }
        }
    }

    // Lógica para comprobar victoria
    public static boolean comprobarFinJuego(char[][] board, boolean turnoJugador1) {
        char simbolo = turnoJugador1 ? 'X' : 'O';

        // Comprobar filas y columnas
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == simbolo && board[i][1] == simbolo && board[i][2] == simbolo) || // Filas
                (board[0][i] == simbolo && board[1][i] == simbolo && board[2][i] == simbolo)) { // Columnas
                return true;
            }
        }
        // Comprobar diagonales

        return (board[0][0] == simbolo && board[1][1] == simbolo && board[2][2] == simbolo) ||
                (board[0][2] == simbolo && board[1][1] == simbolo && board[2][0] == simbolo);
    }

    // Lógica para pedir coordenadas y validar
    public static void tomarCoordenadas(char[][] board, boolean turnoJugador1, Scanner scanner) {
        int fila, columna;
        boolean jugadaValida = false;

        do {
            try {
                System.out.print("Ingrese fila (0, 1, 2): ");
                fila = scanner.nextInt();
                System.out.print("Ingrese columna (0, 1, 2): ");
                columna = scanner.nextInt();

                if (fila >= 0 && fila <= 2 && columna >= 0 && columna <= 2) {
                    if (board[fila][columna] == '-') {
                        board[fila][columna] = turnoJugador1 ? 'X' : 'O';
                        jugadaValida = true;
                    } else {
                        System.out.println("¡Ese espacio ya está ocupado! Intenta de nuevo.");
                    }
                } else {
                    System.out.println("Coordenadas fuera de rango. Deben ser 0, 1 o 2.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor usa números.");
                scanner.nextLine(); // Limpiar el buffer del scanner
            }
        } while (!jugadaValida);
    }

    public static void mostrarTurno(boolean turnoJugador1) {
        String jugador = turnoJugador1 ? "Jugador 1 (X)" : "Jugador 2 (O)";
        System.out.println("\n--- Turno de: " + jugador + " ---");
    }

    public static void printBoard(char[][] board) {
        System.out.println("\n  0 1 2"); // Números de guía para columnas
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " "); // Número de guía para filas
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
        System.out.println();
    }
}