package com.tic_tac_toe;

public class Board {

public static  String[] [] tablero ={
    {"1","2","3"},
    {"4","5","6"},
    {"7","8","9"},
 };
    
  
  public static void main (String [] arg){
    System.out.println(Board.tablero);
  
  for (int i=0; i<=2; i++){
    System.out.println(("_____________"));
    System.out.print("| ");
    for (int j=0; j<=2; j++){
        System.out.print(Board.tablero [i][j] + " |");
        
    }
    System.out.println();
  }
  }
  }



