package com.kodilla.gamexoxo;

public class Board {

    public static void printBoard(BoardState boardState){
        System.out.println("_______");
        for(int i = 0; i < boardState.getBoard().length; i++){
            for (int j = 0; j < boardState.getBoard()[i].length; j++) {
                System.out.print("|" + boardState.getBoard()[i][j]);
            }
            System.out.println("|");
        }
    }
}
