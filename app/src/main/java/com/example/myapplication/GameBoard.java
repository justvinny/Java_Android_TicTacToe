package com.example.myapplication;

import java.util.Arrays;

public class GameBoard {
    private char[] gameBoard;

    public GameBoard() {
        this.gameBoard = new char[9];
        Arrays.fill(gameBoard, ' ');
    }

    public char[] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(int tile, char mark) {
        this.gameBoard[tile] =  mark;
    }

    public void clearGameBoard() {
        for (int i = 0; i < 9; i++) {
            this.gameBoard[i] = ' ';
        }
    }
}
