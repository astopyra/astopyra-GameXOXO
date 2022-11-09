package com.kodilla.gamexoxo;

public class GameState {

    public boolean player1Turn = false;
    char sign = 'X';



    public boolean checkResult(BoardState boardState, UserCommands userCommands){
        boolean win = false;

        if((boardState.board[userCommands.getRowNumber()][0] == boardState.board[userCommands.getRowNumber()][1] &&
            boardState.board[userCommands.getRowNumber()][0] == boardState.board[userCommands.getRowNumber()][2]) ||
           (boardState.board[0][userCommands.getColumnNumber()] == boardState.board[1][userCommands.getColumnNumber()] &&
            boardState.board[0][userCommands.getColumnNumber()] == boardState.board[2][userCommands.getColumnNumber()]) ||
           ( boardState.board[1][1] != ' ' && boardState.board[0][0] == boardState.board[1][1] &&
                   boardState.board[0][0] == boardState.board[2][2]) ||
           (boardState.board[1][1] != ' ' && boardState.board[0][2] == boardState.board[1][1] &&
                   boardState.board[1][1] == boardState.board[2][0])
        ){
            win = true;
        }
        return win;
    }

    public void setTurn(UserCommands userCommands){
        player1Turn = !player1Turn;
        sign = player1Turn ? 'X' : 'O';
        if(player1Turn){
            System.out.println(userCommands.getNamePlayer1() + " twoj ruch");
        }else{
            System.out.println(userCommands.getNamePlayer2() + " twoj ruch");
        }
    }


}
