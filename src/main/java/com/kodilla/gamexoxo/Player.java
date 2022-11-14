package com.kodilla.gamexoxo;

import java.util.Scanner;

public class Player {

    Scanner scanner = new Scanner(System.in);
    protected char symbol;
    protected String name;
    protected boolean isWon = false;


    public Player(char symbol){this.symbol = symbol;}

    public void setIsWon(boolean won) {
        isWon = won;
    }

    public void setName(){
        System.out.print("Jak masz na imie: ");
        name = scanner.nextLine();
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public boolean getIsWon() {
        return isWon;
    }
}
