package com.tp.connectfour.exceptions;

public class NullGuessException extends Exception {

    public NullGuessException( String message ){
        super( message );
    }

    public NullGuessException( String message, Throwable innerException ){
        super( message, innerException );
    }

}
