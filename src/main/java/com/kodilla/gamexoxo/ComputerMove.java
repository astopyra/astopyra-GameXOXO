package com.kodilla.gamexoxo;

import java.util.Random;

public class ComputerMove extends NextMove{

    public void loadNextMove(GameVersion version){
        Random random = new Random();
        setRowNumber(random.nextInt(version.getBoardSize()));
        setColumnNumber(random.nextInt(version.getBoardSize()));
    }

}
