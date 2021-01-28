package com.tp.ttt.models;

public class RandomPlayer implements Player {

    @Override
    public int chooseMove(Board gameBoard) {
        int madeMove = -1;
        boolean isEmpty = false;
        while(!isEmpty){
            madeMove = Rng.nextInt(0, 8);
            if(gameBoard.getGrid()[madeMove].equals(Square.SPACE)){
                isEmpty = true;
            }
        }
        return madeMove;

    }
}
