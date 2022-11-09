package com.kodilla.gamexoxo;

public class GameXoxoApplication {

    public static void main(String[] args) throws FieldAlreadyTakenException {

    GameBoard gameBoard = new GameBoard();
    UserCommands userCommands = new UserCommands();
    BoardState boardState = new BoardState();
    GameState gameState = new GameState();

    int counter = 0;
    boolean win = false;

    userCommands.setNames();

    do {
        System.out.println("_______");
        gameBoard.printBoard(boardState);

        gameState.setTurn(userCommands);

        boolean done = false;
        do {
            try {
                userCommands.nextMove();
                boardState.setBoard(userCommands, gameState);
                done = true;
            } catch (FieldAlreadyTakenException f) {
                System.out.println("Wybierz puste pole");
            }
        } while(!done);

        win = gameState.checkResult(boardState, userCommands);
        if (win){
            System.out.println("\nWYGRANA!");
            gameBoard.printBoard(boardState);

            if(gameState.player1Turn){
                System.out.println(userCommands.getNamePlayer1() + " wygrywa!");
            }else{
                System.out.println(userCommands.getNamePlayer2() + " wygrywa!");
            }
        }


        counter++;
    } while ((counter < 9) && !win );


    //draw
        if(counter == 9 && !win){
            System.out.println("\nREMIS");
        }


    }
}
