package com.tp.ttt.models;

public class Board {

    Square[] grid = new Square[9];

    public Square[] getGrid() {
        return grid;
    }

    public Board() {
        // when you play tic tac toe the board will start out blank
        // instantiate so that this remains true..

        // empty ttt board
        for (int i = 0; i < grid.length; i++) {
            grid[i] = Square.SPACE;
        }

    }

    public Board(Board that) {

        for (int i = 0; i < grid.length; i++) {
            this.grid[0] = that.grid[0];
        }

    }

    // make a move!
    public Board makeMove(int position) {
        Board nextBoard = new Board(this);

        // update the board with an X or O
        int howManyMarks = 0;

        for(int i = 0; i < grid.length; i++){
            if(grid[i] == Square.X || grid[i] == Square.O){
                howManyMarks++;
            }
        }
        // is it X or Os turn?

        Square selectedMark = Square.SPACE;
        if(howManyMarks % 2 == 0){
          selectedMark = Square.X;

        }
        else{
         selectedMark = Square.O;
        }

        nextBoard.grid[position] = selectedMark;

        return nextBoard;
    }


    public boolean isOver() {
        throw new UnsupportedOperationException();
    }

    public GameDecider getOutcome() {
        throw new UnsupportedOperationException();
    }
}