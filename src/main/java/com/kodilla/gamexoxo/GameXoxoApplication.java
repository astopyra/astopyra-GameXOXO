package com.kodilla.gamexoxo;

public class GameXoxoApplication {

    public static void main(String[] args) throws FieldAlreadyTakenException {
        BoardState boardState = new BoardState();
        NextMove nextMove = new NextMove();
        ResultVerification resultVerification = new ResultVerification();

        Player player1 = new Player('X');
        Player player2 = new Player('O');

        System.out.print("Player 1 ");
        player1.setName();
        System.out.print("Player 2 ");
        player2.setName();

        int counter = 0;
        boolean player1Turn = true;

    do {

        if (player1Turn) {
            GameBoard.printBoard(boardState.board);

            boolean done = false;
            do {
                try {
                    nextMove.loadNextMove(player1);
                    boardState.setBoard(nextMove, player1);
                    done = true;
                } catch (FieldAlreadyTakenException f) {
                    System.out.println("Wybierz puste pole");
                }
            } while (!done);

            resultVerification.checkRows(boardState, player1);
            resultVerification.checkColumns(boardState, player1);
            resultVerification.checkAcross(boardState, player1);
            resultVerification.gameResult(player1);

            System.out.println("player 1 won?" + player1.getIsWon());

            player1Turn = !player1Turn;
            counter++;
        } else{
            GameBoard.printBoard(boardState.board);

            boolean done = false;
            do {
                try {
                    nextMove.loadNextMove(player2);
                    boardState.setBoard(nextMove, player2);
                    done = true;
                } catch (FieldAlreadyTakenException f) {
                    System.out.println("Wybierz puste pole");
                }
            } while (!done);

            resultVerification.checkRows(boardState, player2);
            resultVerification.checkColumns(boardState, player2);
            resultVerification.checkAcross(boardState, player2);
            resultVerification.gameResult(player2);

            player1Turn = !player1Turn;
            counter++;
        }

    } while ((counter < 9) && !player1.getIsWon() && !player2.getIsWon());

        if(counter == 9 && !player1.getIsWon() && !player2.getIsWon()){
            System.out.println("\nREMIS");
        }



    }
}
