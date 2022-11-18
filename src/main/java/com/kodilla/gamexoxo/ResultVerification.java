package com.kodilla.gamexoxo;

import java.util.*;

public class ResultVerification {

    public void gameResult(BoardState boardState, Player player){
        if(checkRows(boardState, player) || checkColumns(boardState, player) || checkAcross(boardState, player)) {
            player.setIsWon(true);
            System.out.println("\nGracz " + player.getName() + " WYGRYWA!!");
        } else if(checkIsDraw(boardState)){
            player.setIsWon(true);
            System.out.println("\nWynik: REMIS");
        }
    }

    private boolean checkRows(BoardState boardState, Player player){
        Map<Integer, Integer> map = new HashMap<>();
        int sum;
        for(int row=0; row< boardState.getBoard().length; row++){
            sum = 0;
            for(int column=0; column<boardState.getBoard()[row].length; column++){
                if(boardState.getBoard()[row][column] == player.getSymbol())
                    sum++;
            }
            map.put(row,sum);
        }
        return map.containsValue(3);
    }

    private boolean checkColumns(BoardState boardState, Player player){
        Map<Integer, Integer> map = new HashMap<>();
        int sum;
        for(int column=0; column<boardState.getBoard()[0].length; column++){
            sum = 0;
            for(int row=0; row< boardState.getBoard().length; row++){
                if(boardState.getBoard()[row][column] == player.getSymbol())
                    sum++;
            }
            map.put(column,sum);
        }
        return map.containsValue(3);
    }

    private boolean checkAcross(BoardState boardState, Player player){
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        //checking first diagonal
        for(int i=0; i<boardState.getBoard().length; i++){
            if(boardState.getBoard()[i][i] == player.getSymbol()){
                sum++;
            }
        }
        map.put(1, sum);
        //checking second diagonal
        sum = 0;
        for(int i=0; i<boardState.getBoard().length; i++){
            if(boardState.getBoard()[i][boardState.getBoard().length-i-1] == player.getSymbol()){
                sum++;
            }
        }
        map.put(2, sum);

        return map.containsValue(3);
    }

     private boolean checkIsDraw(BoardState boardState){
        List<Character> listOfArray = new ArrayList<>();

        for(int row=0; row<boardState.getBoard().length; row++){
            for(int column=0; column<boardState.getBoard().length; column++){
                listOfArray.add(boardState.getBoard()[row][column]);
            }
        }
        return !listOfArray.contains(' ');
    }




}
