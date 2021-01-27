package com.tp.hangman.services;

public class NullGuessException extends Exception{

    // Exceptions extend from Exception like Animals extends from Object
    // provide 2 constructors
    // All exceptions chewcked or not are throwables

    public NullGuessException(String message) {
        super(message);//pass message to base class
    }

    public NullGuessException(String message, Throwable innerException){
        super(message, innerException); // there are getters in the Exception class that let us pull these details!
        // Exceptions provide a lot of useful methods
        // We get these because we extend from Exception!
        // So how do we use the NullGuess Exception?
        // Go bac to service class..
    }// Java has checked exceptions meaning the compiler will require a try-catch

}
