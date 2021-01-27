package com.tp.connectfour.models;

import java.util.ArrayList;
import java.util.List;

public class ConnectFourGame {

    private Integer gameId;
    private Integer chosenCol;
    private List<Integer> guessedCol;
    private char[][] gameBoard;

    public Integer getGameId() {
        return gameId;
    }

    public Integer getChosenCol() {
        return chosenCol;
    }

    public List<Integer> getGuessedCol() {
        return guessedCol;
    }



    public ConnectFourGame(Integer gameId){
        this.gameId = gameId;
        //this.chosenCol = chosenCol;
        guessedCol = new ArrayList<>();
        gameBoard = new[6][7];

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                gameBoard[i][j] = '*';
            }
        }
    }


}
