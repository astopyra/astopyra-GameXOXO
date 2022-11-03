package com.kodilla.gamexoxo;

public class GameBoard {
    private char [][] board = new char[3][7];

    public GameBoard(){
        board = new char[][]{
                {'|', ' ', '|', ' ', '|', ' ', '|'},
                {'|', ' ', '|', ' ', '|', ' ', '|'},
                {'|', ' ', '|', ' ', '|', ' ', '|'}
        };
    }


    public char[][] getBoard() {
        return board;
    }



    public void printBoard(){
        System.out.println("XOXO");
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
