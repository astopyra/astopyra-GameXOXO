package com.kodilla.gamexoxo;

import java.util.*;

public class ResultVerification {

    boolean isThreeInRow = false;
    boolean isThreeInColumn = false;
    boolean isThreeAcross = false;
    boolean draw = false;


    public void gameResult(Player player){
        if(isThreeInRow || isThreeInColumn || isThreeAcross) {
            player.setIsWon(true);
            System.out.println("\nGracz " + player.getName() + " WYGRYWA!!");
        } else if(draw){
            player.setIsWon(true);
            System.out.println("\nWynik: REMIS");
        }
    }

    public void checkRows(BoardState boardState, Player player){
        Map<Integer, Integer> map = new HashMap<>();
        int sum;
        for(int row=0; row< boardState.board.length; row++){
            sum = 0;
            for(int column=0; column<boardState.board[row].length; column++){
                if(boardState.board[row][column] == player.getSymbol())
                    sum++;
            }
            map.put(row,sum);
        }
        isThreeInRow = map.containsValue(3);
    }

    public void checkColumns(BoardState boardState, Player player){
        Map<Integer, Integer> map = new HashMap<>();
        int sum;
        for(int column=0; column<boardState.board[0].length; column++){
            sum = 0;
            for(int row=0; row< boardState.board.length; row++){
                if(boardState.board[row][column] == player.getSymbol())
                    sum++;
            }
            map.put(column,sum);
        }
        isThreeInColumn = map.containsValue(3);
    }

    public void checkAcross(BoardState boardState, Player player){

        if(( boardState.board[1][1] == player.getSymbol() && boardState.board[0][0] == boardState.board[1][1] &&
                boardState.board[0][0] == boardState.board[2][2]) ||
                (boardState.board[1][1] == player.getSymbol() && boardState.board[0][2] == boardState.board[1][1] &&
                        boardState.board[1][1] == boardState.board[2][0])){
            isThreeAcross = true;
        }

    }

    public void checkIsDraw(BoardState boardState){
        List<Character> listOfArray = new ArrayList<>();

        for(int row=0; row<boardState.board.length; row++){
            for(int column=0; column<boardState.board.length; column++){
                listOfArray.add(boardState.board[row][column]);
            }
        }
        draw = !listOfArray.contains(' ');
    }

    public boolean getIsThreeInRow() {
        return isThreeInRow;
    }

    public boolean getIsThreeInColumn() {
        return isThreeInColumn;
    }

    public boolean getIsThreeAcross() {
        return isThreeAcross;
    }

    public boolean getIsDraw() {
        return draw;
    }
}
