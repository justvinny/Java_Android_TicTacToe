package com.example.myapplication;

public class Game {
    private GameBoard gameBoard;
    private char winner;
    private int xScore;
    private int oScore;

    public Game() {
        this.gameBoard = new GameBoard();
        this.winner = ' ';
        this.xScore = 0;
        this.oScore = 0;
    }

    public boolean checkForWinner() {
        return this.checkHorizontalWinner() ||
                this.checkVerticalWinner() ||
                this.checkDiagonalWinner();
    }

    public boolean checkHorizontalWinner() {
        for (int i = 0; i < 9; i += 3) {
            if (this.gameBoard.getGameBoard()[i] != ' ') {
                if (this.gameBoard.getGameBoard()[i] == this.gameBoard.getGameBoard()[i + 1] &&
                        this.gameBoard.getGameBoard()[i] == this.gameBoard.getGameBoard()[i + 2]) {
                    this.winner = this.gameBoard.getGameBoard()[i];
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkVerticalWinner() {
        for (int i = 0; i < 3; i ++) {
            if (this.gameBoard.getGameBoard()[i] != ' ') {
                if (this.gameBoard.getGameBoard()[i] == this.gameBoard.getGameBoard()[i + 3] &&
                        this.gameBoard.getGameBoard()[i] == this.gameBoard.getGameBoard()[i + 6]) {
                    this.winner = this.gameBoard.getGameBoard()[i];
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkDiagonalWinner() {
        int firstIndex = 0;
        int lastIndex = 8;

        for (int i = 0; i < 2; i++) {
            if (this.gameBoard.getGameBoard()[firstIndex] != ' ') {
                if (this.gameBoard.getGameBoard()[firstIndex] == this.gameBoard.getGameBoard()[4] &&
                        this.gameBoard.getGameBoard()[firstIndex] == this.gameBoard.getGameBoard()[lastIndex]) {
                    this.winner = this.gameBoard.getGameBoard()[firstIndex];
                    return true;
                }
            }

            firstIndex = 2;
            lastIndex = 6;
        }

        return false;
    }

    public void incrementScore() {
        if (this.winner == 'x') {
            this.xScore++;
        } else if (this.winner == 'o') {
            this.oScore++;
        }
    }


    public void setMarkForTurn(int tileNumber, char mark) {
        this.gameBoard.getGameBoard()[tileNumber] = mark;
    }

    public void resetGame() {
        this.gameBoard.clearGameBoard();
        this.winner = ' ';
    }

    public char getWinner() {
        return winner;
    }

    public int getOScore() {
        return oScore;
    }

    public int getXScore() {
        return xScore;
    }
}
