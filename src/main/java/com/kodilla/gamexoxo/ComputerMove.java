package com.kodilla.gamexoxo;

import java.util.Random;

public class ComputerMove extends NextMove {

    public void loadNextMove(){
        Random random = new Random();
        rowNumber = random.nextInt(3);
        columnNumber = random.nextInt(3);
    }

}
