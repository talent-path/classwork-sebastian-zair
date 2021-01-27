package com.tp.diceroller.controllers;

import com.tp.diceroller.services.RNG;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiceController {
    // First controller!
    // speak to the outside world

    // Most common request is a GET
    // When a browser goes to a URL you're creating a GET :o

    //Handler for our GET request:
    @GetMapping("/helloworld")
    public String helloWorld(){
        return "hello world";
    }

    @GetMapping("/sixsides")
    public int sixSides(){
        return RNG.rollDice(6);
    }

    @GetMapping("/twentysides")
    public int twentySides(){
        return RNG.rollDice(20);
    }

    @GetMapping("/nsides")
    public int nSides(Integer num){
        return RNG.rollDice(num);
    }

    @GetMapping("/nsides/{num}")
    public int nSidesPathVariable(@PathVariable Integer num){ // look into the path
        return RNG.rollDice(num);
    }
}
