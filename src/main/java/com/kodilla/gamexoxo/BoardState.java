package com.kodilla.gamexoxo;



public class BoardState {
     private char [][] board = new char[10][10];

    public BoardState(){
        for(int i=0; i< board.length; i++){
            for(int j=0; j< board[i].length; j++){
                board[i][j] = ' ';
            }
        }
    }

    public void setBoardPlayer(NextMove nextMove) throws FieldAlreadyTakenException {
        if(board[nextMove.getRowNumber()][nextMove.getColumnNumber()] != ' '){
            throw new FieldAlreadyTakenException("To pole jest juz zajete, wybierz wolne pole");
        }

        board[nextMove.getRowNumber()][nextMove.getColumnNumber()] = 'X';
    }

    public void setBoardComputer(NextMove nextMove) throws FieldAlreadyTakenException {
        if(board[nextMove.getRowNumber()][nextMove.getColumnNumber()] != ' '){
            throw new FieldAlreadyTakenException("To pole jest juz zajete, wybierz wolne pole");
        }

        board[nextMove.getRowNumber()][nextMove.getColumnNumber()] = 'O';
    }

    public void printBoard(GameVersion version){
        for(int row=0; row < version.getBoardSize(); row++){
            for (int column = 0; column < version.getBoardSize(); column++) {
                System.out.print("|" + board[row][column]);
            }
            System.out.println("|");
        }
    }

    public char[][] getBoard() {
        return board;
    }
}
