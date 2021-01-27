package com.tp.hangman.controllers;

public class GuessRequest {
    // We want this to have Integer, gameId
    private Integer gameId;
    private String guess;



    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }


}
