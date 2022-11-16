package com.kodilla.gamexoxo;



public class BoardState {
     public char [][] board = new char[3][3];

    public BoardState(){
        for(int i=0; i< board.length; i++){
            for(int j=0; j< board[i].length; j++){
                board[i][j] = ' ';
            }
        }
    }

    public void setBoard(NextMove nextMove, Player player) throws FieldAlreadyTakenException {
        if(board[nextMove.getRowNumber()][nextMove.getColumnNumber()] != ' '){
            throw new FieldAlreadyTakenException("To pole jest juz zajete, wybierz wolne pole");
        }

        board[nextMove.getRowNumber()][nextMove.getColumnNumber()] = player.getSymbol();

    }

    public char[][] getBoard() {
        return board;
    }
}
