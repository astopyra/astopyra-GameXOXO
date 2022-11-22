package com.kodilla.gamexoxo;

public class PlayerComputer extends Player{
    private char symbol = 'O';
    public PlayerComputer(String name){
        setName(name);
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}
