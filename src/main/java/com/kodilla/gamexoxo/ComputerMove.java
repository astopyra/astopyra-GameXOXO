package com.kodilla.gamexoxo;

import java.util.Random;

public class ComputerMove extends NextMove{

    public void loadNextMove(){
        Random random = new Random();
        setRowNumber(random.nextInt(3));
        setColumnNumber(random.nextInt(3));
    }

}
