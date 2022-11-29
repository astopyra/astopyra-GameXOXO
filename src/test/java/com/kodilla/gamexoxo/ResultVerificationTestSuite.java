package com.kodilla.gamexoxo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ResultVerificationTestSuite {
    @Mock
    private BoardState boardStateMock;
    @Mock
    private GameVersion versionMock;

    @Test
    void testCheckRow0Wins() {
        //given
        Player player = new Player();
        ResultVerification resultVerification = new ResultVerification();
        char[][] boardRowWin = {{'X', 'X', 'X'},
                                {' ', 'O', ' '},
                                {'O', ' ', ' '}};
        int symbolsToWin = 3;
        when(boardStateMock.getBoard()).thenReturn(boardRowWin);
        when(versionMock.getSymbolsToWin()).thenReturn(symbolsToWin);


        //when
        resultVerification.gameResult(boardStateMock, player, versionMock);

        //then
        Assertions.assertTrue(player.getIsWon());
    }

    @Test
    void testCheckRow1Wins() {
        //given
        Player player = new Player();
        ResultVerification resultVerification = new ResultVerification();
        char[][] boardRowWin = {{'O', ' ', 'O'},
                                {'X', 'X', 'X'},
                                {'O', ' ', ' '}};
        int symbolsToWin = 3;
        when(boardStateMock.getBoard()).thenReturn(boardRowWin);
        when(versionMock.getSymbolsToWin()).thenReturn(symbolsToWin);

        //when
        resultVerification.gameResult(boardStateMock, player, versionMock);

        //then
        Assertions.assertTrue(player.getIsWon());
    }

    @Test
    void testCheckRow2Wins() {
        //given
        Player player = new Player();
        ResultVerification resultVerification = new ResultVerification();
        char[][] boardRowWin = {{'O', ' ', ' '},
                                {' ', 'O', ' '},
                                {'X', 'X', 'X'}};
        int symbolsToWin = 3;
        when(boardStateMock.getBoard()).thenReturn(boardRowWin);
        when(versionMock.getSymbolsToWin()).thenReturn(symbolsToWin);

        //when
        resultVerification.gameResult(boardStateMock, player, versionMock);

        //then
        Assertions.assertTrue(player.getIsWon());
    }

    @Test
    void testCheckColumn0Wins() {
        //given
        Player player = new Player();
        ResultVerification resultVerification = new ResultVerification();
        char[][] boardColumnWin = {{'X', 'X', 'O'},
                                   {'X', 'O', ' '},
                                   {'X', 'O', ' '}};
        int symbolsToWin = 3;
        when(boardStateMock.getBoard()).thenReturn(boardColumnWin);
        when(versionMock.getSymbolsToWin()).thenReturn(symbolsToWin);

        //when
        resultVerification.gameResult(boardStateMock, player, versionMock);

        //then
        Assertions.assertTrue(player.getIsWon());
    }

    @Test
    void testCheckColumn1Wins() {
        //given
        Player player = new Player();
        ResultVerification resultVerification = new ResultVerification();
        char[][] boardColumnWin = {{'O', 'X', 'O'},
                                   {' ', 'X', ' '},
                                   {'O', 'X', ' '}};
        int symbolsToWin = 3;
        when(boardStateMock.getBoard()).thenReturn(boardColumnWin);
        when(versionMock.getSymbolsToWin()).thenReturn(symbolsToWin);

        //when
        resultVerification.gameResult(boardStateMock, player, versionMock);

        //then
        Assertions.assertTrue(player.getIsWon());
    }

    @Test
    void testCheckColumn2Wins() {
        //given
        Player player = new Player();
        ResultVerification resultVerification = new ResultVerification();
        char[][] boardColumnWin = {{'X', 'O', 'X'},
                                   {' ', 'O', 'X'},
                                   {'O', ' ', 'X'}};
        int symbolsToWin = 3;
        when(boardStateMock.getBoard()).thenReturn(boardColumnWin);
        when(versionMock.getSymbolsToWin()).thenReturn(symbolsToWin);

        //when
        resultVerification.gameResult(boardStateMock, player, versionMock);

        //then
        Assertions.assertTrue(player.getIsWon());
    }

    @Test
    void testCheckAcross1Wins() {
        //given
        Player player = new Player();
        ResultVerification resultVerification = new ResultVerification();
        char[][] boardAcross1Win = {{'X', 'O', 'X'},
                                    {' ', 'X', 'O'},
                                    {'O', ' ', 'X'}};
        int symbolsToWin = 3;
        when(boardStateMock.getBoard()).thenReturn(boardAcross1Win);
        when(versionMock.getSymbolsToWin()).thenReturn(symbolsToWin);

        //when
        resultVerification.gameResult(boardStateMock, player, versionMock);

        //then
        Assertions.assertTrue(player.getIsWon());
    }

    @Test
    void testCheckAcross2Wins() {
        //given
        Player player = new Player();
        ResultVerification resultVerification = new ResultVerification();
        char[][] boardAcrossWin = {{' ', 'O', 'X'},
                                   {' ', 'X', ' '},
                                   {'X', 'O', ' '}};
        int symbolsToWin = 3;
        when(boardStateMock.getBoard()).thenReturn(boardAcrossWin);
        when(versionMock.getSymbolsToWin()).thenReturn(symbolsToWin);

        //when
        resultVerification.gameResult(boardStateMock, player, versionMock);

        //then
        Assertions.assertTrue(player.getIsWon());
    }

    @Test
    void testFieldAlreadyTakenException(){
        //given
        Player player = new Player();
        NextMove nextMove = new NextMove();
        BoardState boardState = new BoardState();

        //when
        nextMove.setRowNumber(0);
        nextMove.setColumnNumber(1);

        //then
        assertDoesNotThrow(() -> boardState.setBoardPlayer(nextMove));
    }

}
