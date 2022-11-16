package com.kodilla.gamexoxo;

public class GameXoxoApplication {

    public static void main(String[] args) throws FieldAlreadyTakenException {
        BoardState boardState = new BoardState();
        NextMove nextMove = new NextMove();
        ComputerMove computerMove = new ComputerMove();
        ResultVerification resultVerification = new ResultVerification();

        Player player1 = new Player('X');
        PlayerComputer player2 = new PlayerComputer('O', "Computer");

        System.out.print("Player 1 ");
        player1.setName();

        boolean player1Turn = true;

        do {

            if (player1Turn) {
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

                GameBoard.printBoard(boardState.board);

                resultVerification.checkIsDraw(boardState);
                resultVerification.checkRows(boardState, player1);
                resultVerification.checkColumns(boardState, player1);
                resultVerification.checkAcross(boardState, player1);
                resultVerification.gameResult(player1);

                player1Turn = !player1Turn;

            } else{
                boolean done = false;
                do {
                    try {
                        //nextMove.loadNextMove(player2);
                        computerMove.loadNextMove();
                        boardState.setBoard(computerMove, player2);
                        done = true;
                    } catch (FieldAlreadyTakenException f) {
                        //System.out.println("Wybierz puste pole");
                    }
                } while (!done);

                GameBoard.printBoard(boardState.board);

                resultVerification.checkIsDraw(boardState);
                resultVerification.checkRows(boardState, player2);
                resultVerification.checkColumns(boardState, player2);
                resultVerification.checkAcross(boardState, player2);
                resultVerification.gameResult(player2);


                player1Turn = !player1Turn;
            }

        } while (!player1.getIsWon() && !player2.getIsWon());


    }
}
