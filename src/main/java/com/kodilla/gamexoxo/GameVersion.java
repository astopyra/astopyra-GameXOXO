package com.kodilla.gamexoxo;

import java.util.Scanner;

public class GameVersion {
    private int boardSize;
    private int symbolsToWin;
    private int gameVersion = 0;


    public GameVersion(Player player){
        setGameVersion(player);
        setBoardSize();
        setSymbolsToWin();
    }

    private void setBoardSize(){ boardSize = gameVersion == 1 ? 3 : 10; }

    private void setSymbolsToWin(){
        symbolsToWin = gameVersion == 1 ? 3 : 5;
    }

    private void setGameVersion(Player player){
        boolean done = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + player.getName() +
                " wybierz wariant gry:\n1. Gra 3x3\n2. Gra 10x10 do pieciu");

        do {
            try {
                System.out.print("Wybierz 1 lub 2:");
                gameVersion = Integer.parseInt(scanner.nextLine());
                done = true;
            } catch (NumberFormatException e) {
                System.out.println("Podaj cyfre 1 lub 2");
            }
        } while(!done || gameVersion != 1 && gameVersion != 2);

        setBoardSize();
        setSymbolsToWin();
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int getSymbolsToWin() {
        return symbolsToWin;
    }

    public int getGameVersion() {
        return gameVersion;
    }
}
