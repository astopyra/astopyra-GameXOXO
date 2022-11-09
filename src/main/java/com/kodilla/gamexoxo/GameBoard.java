package com.kodilla.gamexoxo;

public class GameBoard {



    public void printBoard(BoardState boardState){
        //System.out.println("XOXO");
        for(int i = 0; i < boardState.board.length; i++){
            for (int j = 0; j < boardState.board[i].length; j++) {
                System.out.print("|" + boardState.board[i][j]);
            }
            System.out.println("|");
        }
    }
}
