package com.kodilla.gamexoxo;

public class GameXoxoApplication {

    public static void main(String[] args) {
        BoardState boardState = new BoardState();
        NextMove nextMove = new NextMove();
        ComputerMove computerMove = new ComputerMove();
        ResultVerification resultVerification = new ResultVerification();
        GameEngine gameEngine = new GameEngine();

        Player player1 = new Player('X');
        PlayerComputer player2 = new PlayerComputer('O', "Computer");

        System.out.print("Player 1 ");
        player1.setName();

        do {
            gameEngine.makeMove(nextMove, boardState, player1);
            resultVerification.gameResult(boardState, player1);

            if(player1.getIsWon())
                break;                   //??

            gameEngine.makeComputerMove(computerMove, boardState, player2);
            resultVerification.gameResult(boardState, player2);
        } while (!player1.getIsWon() && !player2.getIsWon());


    }
}
