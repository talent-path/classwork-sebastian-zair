package com.tp.hangman.controllers;

import com.tp.hangman.models.HangmanGame;
import com.tp.hangman.models.HangmanViewModel;
import com.tp.hangman.services.HangmanService;
import com.tp.hangman.services.InvalidGameIdException;
import com.tp.hangman.services.InvalidGuessException;
import com.tp.hangman.services.NullGuessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//this will provide two methods
//getGameById (should show the word with unguessed letters hidden and all guessed letters)
//guessLetter (should take a game and a letter to guess for that game)

// Create
//     POST - inserting NEW data into a system
//          - allows URLs to look much neater as well..
//          - When a user needs to fill in multiple text fields, etc it's putting info into a POST mapping
// Read(read one and read all)
//     GET - retireiving data from a system
// Update
//     PUT - EDITING data already in the system
// Delete
//     DELETE - removing data from a system
@RestController
public class HangmanController {

    //autowired will automatically bring in any
    // "bean" which is defined as a "component"
    // several annotations derive from component
    // including @Service and @Repository
    // but we can also do @Component
    @Autowired
    HangmanService service;

    @GetMapping("/game/{gameId}")
    public HangmanViewModel getGameById(@PathVariable Integer gameId) {

        return service.getGameById(gameId);
    }

    @GetMapping("/game")
    public List<HangmanViewModel> getAllGames(){
        return service.getAllGames();
    }

    // this represents the first line of defense when dealing with user input
    @GetMapping("/game/{gameId}/guess/{guess}")
    public ResponseEntity<HangmanViewModel> guessLetter(@PathVariable String guess, @PathVariable Integer gameId) throws NullGuessException {
       HangmanViewModel toReturn = null;



        try {
           // return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            toReturn = service.makeGuess(gameId, guess);
        } catch (NullGuessException | InvalidGuessException | InvalidGameIdException ex) {
            // handle exception
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());

        }
        return ResponseEntity.ok(service.makeGuess(gameId, guess));

    }

    // POST mapping
    //  it's best to send information in the BODY of the request..
    // in a GET request the expectation is that the data is in the URL (Path variables, etc), and not the body..
    // When we create a post request the data is packaged up into a JSON object typically
    // let's get it
    // USUALLY make use of the BODY of the requeset when sending data opposed to the URL (GET)


    //@PostMapping
    // take in an object, (no path variables)
    // @RequestBody will convert the entire body of the request into 'this thing'
    // So that can't go into the parameter..
    // Instead we have to make a class that'll hold the body and the
    @PostMapping("/guess")
    public ResponseEntity<HangmanViewModel> guessLetter(@RequestBody GuessRequest request) throws NullGuessException {
        HangmanViewModel toReturn = null;



        try {
            // return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            toReturn = service.makeGuess(request.getGameId(), request.getGuess());
        } catch (NullGuessException | InvalidGuessException | InvalidGameIdException ex) {
            // handle exception
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());

        }
        return ResponseEntity.ok(service.makeGuess(request.getGameId(), request.getGuess()));

    }
}
