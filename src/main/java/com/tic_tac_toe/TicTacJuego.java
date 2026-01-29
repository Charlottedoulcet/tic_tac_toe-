package com.tic_tac_toe;

import java.util.Scanner;

public class TicTacJuego {
    private final Board board;
    private final Scanner scanner;

    private boolean turnoJugador1;
    private int turno;
    private boolean ganador;

    public TicTacJuego() {
        board = new Board();
        scanner = new Scanner(System.in);
        turnoJugador1 = true;
        turno = 1;
        ganador = false;
    }

    public void jugar() {
        System.out.println("Welcome to Tic Tac Toe");
        board.print();

        do {
            mostrarTurno(turnoJugador1);

            char simbolo = turnoJugador1 ? 'X' : 'O';
            tomarCoordenadasYColocar(simbolo);

            ganador = board.hasWinner(simbolo);

            board.print();

            if (!ganador) {
                turnoJugador1 = !turnoJugador1;
            }

            turno++;
        } while (turno <= 9 && !ganador);

        if (!ganador) {
            System.out.println("Es un empate");
        } else if (turnoJugador1) {
            System.out.println("Gana jugador 1 'X'");
        } else {
            System.out.println("Gana jugador 2 'O'");
        }

        scanner.close();
    }

    private void tomarCoordenadasYColocar(char simbolo) {
        boolean jugadaIncorrecta = true;

        while (jugadaIncorrecta) {
            int fila = pedirNumeroEnRango("Ingrese la fila (0-2): ", 0, 2);
            int columna = pedirNumeroEnRango("Ingrese la columna (0-2): ", 0, 2);

            if (board.placeMark(fila, columna, simbolo)) {
                jugadaIncorrecta = false;
            } else {
                System.out.println("Ingresa de nuevo, espacio ocupado o inválido");
            }
        }
    }

    private int pedirNumeroEnRango(String mensaje, int min, int max) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.print(mensaje);
            }
            valor = scanner.nextInt();
            if (valor >= min && valor <= max)
                return valor;
        }
    }

    private void mostrarTurno(boolean turnoJugador1) {
        if (turnoJugador1) {
            System.out.println("El turno es del jugador 1");
        } else {
            System.out.println("El turno es del jugador 2");
        }
    }
}
