package com.kodilla.gamexoxo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.kodilla.gamexoxo.ResultVerification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ResultVerificationTestSuite {
    @Mock
    private BoardState boardStateMock;

    @Test
    void testCheckRow0Wins() {
        //given
        Player player = new Player('X');
        ResultVerification resultVerification = new ResultVerification();
        char[][] boardRowWin = {{'X', 'X', 'X'}, {' ', 'O', ' '}, {'O', ' ', ' '}};
        when(boardStateMock.getBoard()).thenReturn(boardRowWin);

        //when
        resultVerification.gameResult(boardStateMock, player);

        //then
        Assertions.assertTrue(player.getIsWon());
    }

    @Test
    void testCheckRow1Wins() {
        //given
        Player player = new Player('O');
        ResultVerification resultVerification = new ResultVerification();
        char[][] boardRowWin = {{'X', ' ', 'X'}, {'O', 'O', 'O'}, {'X', ' ', ' '}};
        when(boardStateMock.getBoard()).thenReturn(boardRowWin);

        //when
        resultVerification.gameResult(boardStateMock, player);

        //then
        Assertions.assertTrue(player.getIsWon());
    }

    @Test
    void testCheckRow2Wins() {
        //given
        Player player = new Player('X');
        ResultVerification resultVerification = new ResultVerification();
        char[][] boardRowWin = {{'O', ' ', ' '}, {' ', 'O', ' '}, {'X', 'X', 'X'}};
        when(boardStateMock.getBoard()).thenReturn(boardRowWin);

        //when
        resultVerification.gameResult(boardStateMock, player);

        //then
        Assertions.assertTrue(player.getIsWon());
    }

    @Test
    void testCheckColumn0Wins() {
        //given
        Player player = new Player('O');
        ResultVerification resultVerification = new ResultVerification();
        char[][] boardColumnWin = {{'O', 'O', 'X'}, {'O', 'X', ' '}, {'O', 'X', ' '}};
        when(boardStateMock.getBoard()).thenReturn(boardColumnWin);

        //when
        resultVerification.gameResult(boardStateMock, player);

        //then
        Assertions.assertTrue(player.getIsWon());
    }

    @Test
    void testCheckColumn1Wins() {
        //given
        Player player = new Player('O');
        ResultVerification resultVerification = new ResultVerification();
        char[][] boardColumnWin = {{'X', 'O', 'X'}, {' ', 'O', ' '}, {'X', 'O', ' '}};
        when(boardStateMock.getBoard()).thenReturn(boardColumnWin);

        //when
        resultVerification.gameResult(boardStateMock, player);

        //then
        Assertions.assertTrue(player.getIsWon());
    }

    @Test
    void testCheckColumn2Wins() {
        //given
        Player player = new Player('X');
        ResultVerification resultVerification = new ResultVerification();
        char[][] boardColumnWin = {{'X', 'O', 'X'}, {' ', 'O', 'X'}, {'O', ' ', 'X'}};
        when(boardStateMock.getBoard()).thenReturn(boardColumnWin);

        //when
        resultVerification.gameResult(boardStateMock, player);

        //then
        Assertions.assertTrue(player.getIsWon());
    }

    @Test
    void testCheckAcross1Wins() {
        //given
        Player player = new Player('O');
        ResultVerification resultVerification = new ResultVerification();
        char[][] boardAcross1Win = {{'O', 'X', 'O'}, {' ', 'O', 'X'}, {'X', ' ', 'O'}};
        when(boardStateMock.getBoard()).thenReturn(boardAcross1Win);

        //when
        resultVerification.gameResult(boardStateMock, player);

        //then
        Assertions.assertTrue(player.getIsWon());
    }

    @Test
    void testCheckAcross2Wins() {
        //given
        Player player = new Player('X');
        ResultVerification resultVerification = new ResultVerification();
        char[][] boardAcrossWin = {{' ', 'O', 'X'}, {' ', 'X', ' '}, {'X', 'O', ' '}};
        when(boardStateMock.getBoard()).thenReturn(boardAcrossWin);

        //when
        resultVerification.gameResult(boardStateMock, player);

        //then
        Assertions.assertTrue(player.getIsWon());
    }

    @Test
    void testFieldAlreadyTakenException(){
        //given
        Player player = new Player('X');
        NextMove nextMove = new NextMove();
        BoardState boardState = new BoardState();

        //when
        nextMove.setRowNumber(0);
        nextMove.setColumnNumber(1);

        //then
        assertDoesNotThrow(() -> boardState.setBoard(nextMove, player));
    }

}
