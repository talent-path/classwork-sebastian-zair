package com.tp.ttt;

import com.tp.ttt.models.Board;
import com.tp.ttt.models.Console;
import com.tp.ttt.models.GameDecider;
import com.tp.ttt.models.Player;

public class App {

    public static void main(String[] args) {
        // set up 2 [layer variables
        Player p1 = choosePlayer();
        Player p2 = choosePlayer();

        Board game = new Board();

        boolean p1Turn = true;

        int location = -1;
        while(!game.isOver()){
            if(p1Turn){
               location = p1.chooseMove(game);

            }
            else{

                location = p2.chooseMove(game);

            }
             p1Turn = !p1Turn;
         game = game.makeMove(location);
        }

        GameDecider outcome = game.getOutcome();
        // for both of them call a method that chooses palyer
        // determine a human or random player
        switch(outcome){
            case P1WINS:
                Console.print("Player 1 has won! :)");
                break;
            case P2WINS:
                Console.print("Player 2 has decided to win..");
                break;
            case DRAW:
                Console.print("I suppose you are equals.");
                break;
        }

    }

    private static Player choosePlayer() {
        Player pickOne = null;

        throw new UnsupportedOperationException();

        return pickOne;
    }


}
