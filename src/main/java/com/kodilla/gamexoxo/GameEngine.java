package com.kodilla.gamexoxo;

public class GameEngine {

    public void makeMove(NextMove nextMove, BoardState boardState, GameVersion version) {
        boolean done = false;
        do {
            try {
                nextMove.loadNextMove(version);
                boardState.setBoardPlayer(nextMove);
                done = true;
            } catch (FieldAlreadyTakenException f) {
                System.out.println("Wybierz puste pole");
            }
        } while (!done);

        boardState.printBoard(version);
    }

    public void makeComputerMove(ComputerMove computerMove, BoardState boardState, GameVersion version){

        boolean done = false;
        do {
            try {
                computerMove.loadNextMove(version);
                boardState.setBoardComputer(computerMove);
                done = true;
            } catch (FieldAlreadyTakenException f) {}
        } while (!done);

        System.out.println("Ruch komputera");
        boardState.printBoard(version);
    }

}
