package com.kodilla.gamexoxo;

import java.util.*;

public class ResultVerification {

    public void gameResult(BoardState boardState, Player player, GameVersion version){
        if(checkRows(boardState, player, version) || checkColumns(boardState, player, version) || checkAcross(boardState, player, version)) {
            player.setIsWon(true);
            System.out.println("\nGracz " + player.getName() + " WYGRYWA!!");
        } else if(checkIsDraw(boardState)){
            player.setIsWon(true);
            System.out.println("\nWynik: REMIS");
        }
    }

    private boolean checkRows(BoardState boardState, Player player, GameVersion version){
        Map<Integer, Integer> map = new HashMap<>();
        int sum;
        for(int row=0; row< boardState.getBoard().length; row++){
            sum = 0;
            for(int column=0; column<boardState.getBoard()[row].length; column++){
                if(boardState.getBoard()[row][column] == player.getSymbol()){
                    sum++;
                    if (sum == version.getSymbolsToWin()) {
                        break;
                    }
                } else {
                    sum = 0;
                }
            }
            map.put(row,sum);
        }
        return map.containsValue(version.getSymbolsToWin());
    }

    private boolean checkColumns(BoardState boardState, Player player, GameVersion version){
        Map<Integer, Integer> map = new HashMap<>();
        int sum;
        for(int column=0; column<boardState.getBoard()[0].length; column++){
            sum = 0;
            for(int row=0; row< boardState.getBoard().length; row++){
                if(boardState.getBoard()[row][column] == player.getSymbol()){
                    sum++;
                    if (sum == version.getSymbolsToWin()) {
                        break;
                    }
                } else {
                    sum = 0;
                }
            }
            map.put(column,sum);
        }
        return map.containsValue(version.getSymbolsToWin());
    }

    private boolean checkAcross(BoardState boardState, Player player, GameVersion version){
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        //checking right to left bottom diagonals
        for( int k = 0 ; k < boardState.getBoard().length ; k++ ) {
            sum = 0;
            for( int j = 0 ; j <= k ; j++ ) {
                int i = k - j;
                try {
                    if (boardState.getBoard()[i][j] == player.getSymbol()) {
                        sum++;
                        if (sum == version.getSymbolsToWin()) {
                            break;
                        }
                    } else {
                        sum = 0;
                    }
                } catch(ArrayIndexOutOfBoundsException e){}
            }
            set.add(sum);
        }

        for( int k = boardState.getBoard().length - 2 ; k >= 0 ; k-- ) {
            sum = 0;
            for (int j = 0; j <= k; j++) {
                int i = k - j;
                try {
                    if (boardState.getBoard()[boardState.getBoard().length - j - 1][boardState.getBoard().length - i - 1] == player.getSymbol()) {
                        sum++;
                        if (sum == version.getSymbolsToWin()) {
                            break;
                        }
                    } else {
                        set.add(sum);
                        sum = 0;
                    }
                } catch(ArrayIndexOutOfBoundsException e){}
            }
            set.add(sum);
        }
        //checking left to right bottom diagonals
        for(int i=boardState.getBoard().length-1; i>0; i-- ){
            int x=i;
            for(int j=0; x< boardState.getBoard().length; j++,x++){
                try {
                    if (boardState.getBoard()[x][j] == player.getSymbol()) {
                        sum++;
                        if (sum == version.getSymbolsToWin()) {
                            break;
                        }
                    } else {
                        set.add(sum);
                        sum = 0;
                    }
                } catch(ArrayIndexOutOfBoundsException e){}
            }
            set.add(sum);
        }

        for(int i=0; i< boardState.getBoard().length; i++){
            int j=0;
            for(int y=i; y<boardState.getBoard().length;j++, y++){
                try {
                    if (boardState.getBoard()[j][y] == player.getSymbol()) {
                        sum++;
                        if (sum == version.getSymbolsToWin()) {
                            break;
                        }
                    } else {
                        set.add(sum);
                        sum = 0;
                    }
                } catch(ArrayIndexOutOfBoundsException e){}
            }
            set.add(sum);
        }

        return set.contains(version.getSymbolsToWin());
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
