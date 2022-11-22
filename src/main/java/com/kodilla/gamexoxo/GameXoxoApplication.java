package com.kodilla.gamexoxo;

public class GameXoxoApplication {

    public static void main(String[] args) {
        BoardState boardState = new BoardState();
        NextMove nextMove = new NextMove();
        ComputerMove computerMove = new ComputerMove();
        ResultVerification resultVerification = new ResultVerification();
        GameEngine gameEngine = new GameEngine();

        Player player1 = new Player();
        PlayerComputer player2 = new PlayerComputer("Computer");

        System.out.print("Player 1 ");
        player1.setName();

        GameVersion version = new GameVersion();
        version.setGameVersion(player1);

        do {
            gameEngine.makeMove(nextMove, boardState, version);
            resultVerification.gameResult(boardState, player1, version);

            if(player1.getIsWon())
                //??
                break;

            gameEngine.makeComputerMove(computerMove, boardState, version);
            resultVerification.gameResult(boardState, player2, version);
        } while (!player1.getIsWon() && !player2.getIsWon());


    }
}
