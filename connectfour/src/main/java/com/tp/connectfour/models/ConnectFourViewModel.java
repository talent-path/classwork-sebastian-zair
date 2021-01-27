package com.tp.connectfour.models;

import java.util.List;

public class ConnectFourViewModel {

    private Integer gameId;
    List<Integer> guessCoordinates;
    char[][] gameBoard;

    public Integer getGameId(){
        return gameId;
    }

    public void setGameId(Integer gameId){
        this.gameId = gameId;
    }

    public char[][] getGameBoard(){
        return gameBoard;
    }

    public List<Integer> getGuessCoordinates(){
        return guessCoordinates;
    }

    public void setGuessCoordinates(List<Integer> guessCoordinates) {
        this.guessCoordinates = guessCoordinates;
    }

    public void setGameBoard(char[][] gameBoard) {
        this.gameBoard = gameBoard;
    }
}
