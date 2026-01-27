package com.tic_tac_toe;

// FLOWCHART:
// Mensaje de bienvenida.
// Explicar reglas del juego
// Preguntar si quiere iniciar la partida
// Jugador X vs Bot O
// Preguntar dónde 
// Verificar si la posición está válida (si está dentro de las posiciones disponibles)
// Verificar si la posición está vacía
// Si está ocupado mensaje de elegir nueva posición
// Validar jugada y mostrarla
// Verificar vitoria o empate en función de las posiciones
// Mensaje de vitoria o empate
// Reiniciar o salir de la sesión


// Classes:

// 1. Board
//  - atributos:
//  int columns
//  int rows
// lectura en diagonal
// String array 2D[][]

// 2. Bot
// - atributos:
// enum (X, O, VACIO)

// 3. GamePlay
// - atributos:
// posición casillas
// - métodos:
// imprimir tablero
// Iniciar juego()
// llamar jugadores
// decidir vitoria o empate

// // 5. main
// renderiza todo. limpio

// STATUS:
// EMPTY
// X
// O

// Instructions board:
// para imprimir un ejemplo de las posiciones del tablero

public class Board {
  int rows;
  int columns;
  public static String[][] board;

  public Board() {
    // this.rows = rows;
    // this.columns = columns;
    // this.board = new String[rows][columns];
    System.out.println("    0   1   2 ");
    System.out.println("0 | _ | _ | _ |");
    System.out.println("1 | _ | _ | _ |");
    System.out.println("2 | _ | _ | _ |");
  }
}

// public static int final FIELD_SIZE = 3;
// board = new char[FIELD_SIZE][FIELD_SIZE];
// for (int i = 0; i < board.length; i++) {
// for (int j = 0; j < board[i].length; j++) {
// Board[i][j] = " ";

// }
// }