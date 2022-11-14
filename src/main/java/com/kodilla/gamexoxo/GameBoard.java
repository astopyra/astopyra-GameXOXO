package com.kodilla.gamexoxo;

public class GameBoard {



    public static void printBoard(char [][] board){
        System.out.println("_______");
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
        }
    }
}
