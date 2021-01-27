package com.tp.hangman.services;

public class InvalidGuessException extends Exception{

    // the more specific you are with your exceptions, the better
    // ie. a whole logging system could be in place so you'd need much more specific exceptions for these issues...

    public InvalidGuessException(String message){
        super(message);
    }
    public InvalidGuessException(String message, Throwable innerException){
        super(message, innerException);
    }
}
