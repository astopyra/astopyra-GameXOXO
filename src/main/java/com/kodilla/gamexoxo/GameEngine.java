package com.kodilla.gamexoxo;

public class GameEngine {

    public void makeMove(NextMove nextMove, BoardState boardState, Player player) {
        boolean done = false;
        do {
            try {
                nextMove.loadNextMove(player);
                boardState.setBoard(nextMove, player);
                done = true;
            } catch (FieldAlreadyTakenException f) {
                System.out.println("Wybierz puste pole");
            }
        } while (!done);

        Board.printBoard(boardState);
    }

    public void makeComputerMove(ComputerMove computerMove, BoardState boardState, Player player){

        boolean done = false;
        do {
            try {
                computerMove.loadNextMove();
                boardState.setBoard(computerMove, player);
                done = true;



            } catch (FieldAlreadyTakenException f) {}
        } while (!done);

        Board.printBoard(boardState);
    }

}
