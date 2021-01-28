package com.tp.ttt.models;

public class HumanPlayer implements Player{

    @Override
    public int chooseMove(Board gameBoard) {
        int madeMove = -1;
        boolean isEmpty = false;
        while(!isEmpty){
            madeMove = Console.readInt("Choose your move by entering a number 0-8", 0, 8);
            if(gameBoard.getGrid()[madeMove].equals(Square.SPACE)){
                isEmpty = true;
            }
        }
        return madeMove;
      //  int madeMove = Console.readInt("Choose your move by entering a number 0-8", 0, 8);

        // check for marks


    }
}
