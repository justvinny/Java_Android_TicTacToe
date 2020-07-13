package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private HashMap<Integer, Button> tiles = new HashMap<>();
    private Game game;
    private int turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storeGameTiles(this.tiles);
        this.game = new Game();
        this.turn = 0;
    }

    public void storeGameTiles(HashMap<Integer, Button> tiles) {
        for (int i = 1; i <= 9; i++) {
            int tile = getResources().getIdentifier("button" + i, "id", getPackageName());
            tiles.put(i, (Button) findViewById(tile));
        }
    }

    public void tilePressed(View view) {
        Button tile = (Button) view;
        int tileNumber = 0;

        for (int i = 1; i <= 9; i++) {
            if (this.tiles.get(i).equals(tile)) {
                tileNumber = i - 1;
            }
        }

        if (this.turn < 9) {
            if (turn % 2 == 0) {
                tile.setText("X");
                this.game.setMarkForTurn(tileNumber, 'x');
            } else {
                tile.setText("O");
                this.game.setMarkForTurn(tileNumber, 'o');
            }

            this.turn++;
        }

        this.hasWinner();
    }

    public void hasWinner() {
        if (this.game.checkForWinner()) {
            this.game.incrementScore();
            this.disableTiles();
            this.showWinner();
            this.setScores();
        }

    }

    public void disableTiles() {
        for (Button tile : tiles.values()) {
            tile.setEnabled(false);
        }
    }

    public void showWinner() {
        TextView winnerTextView = (TextView) findViewById(R.id.textView_winner);
        String winMessage = "Player " + this.game.getWinner() + " won!";
        winnerTextView.setText(winMessage);
    }

    public void setScores() {
        TextView xScore = (TextView) findViewById(R.id.textView_o_score);
        String xMessage = "Player X Score: " + this.game.getXScore();
        xScore.setText(xMessage);

        TextView oScore = (TextView) findViewById(R.id.textView_x_score);
        String oMessage = "Player O Score: " + this.game.getOScore();
        oScore.setText(oMessage);
    }

    public void playAgain(View view) {
        this.enableTiles();
        this.resetTilesBlank();
        this.clearWinnerMessage();
        this.game.resetGame();
        this.turn = 0;
    }

    public void enableTiles() {
        for (Button tile : tiles.values()) {
            tile.setEnabled(true);
        }
    }

    public void resetTilesBlank() {
        for (Button tile : tiles.values()) {
            tile.setText(getResources().getString(R.string.blank_mark));
        }
    }

    public void clearWinnerMessage() {
        TextView winnerTextView = (TextView) findViewById(R.id.textView_winner);
        winnerTextView.setText("");
    }

}