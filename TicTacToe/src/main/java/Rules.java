public class Rules {

    // ! QUESTIONS
    // 1.) If I'm returning an element in an array..what does the method type need to be?
    // ~~ CHECK POINTS
    //1.) Display the board -- CHECK
    //2.) Populate the board with user input -- CHECK
    //3.) Populate the board with computer AND user input
    //   - Get the computer to make educated decisions..
    //4.) Determine the amount of rounds you want to be played
    // 5.) Keep track of who wins and who loses


    // TIC-TAC-TOE
    // In the beginning it will be a USER vs COMPUTER
    // The # of games the User would like to play must be accounted for
    // The # of wins, losses, or draws must be accounted for
    // A USER and COMPUTER are not able to overlap answer choices
    // Establish who is 'X' and who is 'O'
    // After an answer is placed there should be a printed grid of the choice that was selected..
    // Use computer/user input to determine which space has been filled
    //     - if a space has been filled it is unavailable to use


    // ADVANCED IDEAS:
    // Give the user and computer 9 variables (elements for the 2D array) to pick from?
    // topLeft, middleLeft, bottomLeft
    // topMiddle, middleMiddle, bottomMiddle
    // topRight, middleRight, bottomRight

    // MORE ADVANCED RULES
    // Make the 2D array a String :o
    // Present an empty array of Strings
    // Change element in array to 1 of the 9 places on the grid
    // Determine which move to select based on the 9 variables (in a switch statement)
    // if space in gameBoard is populated by an X or O give error message saying that move is takin, try again
    // "space" contains an X or O, you must select another space..
    // After a USER/COMPUTER input display the newly updated Table

    //DETERMINE HOW TO SWITCH BETWEEN USER AND COMPUTER
    // if userTurn = true -- input new location on game board
    // if location is populated with an X or O, do not exit while loop and force user to pick another position
    // if userTurn = true then computerTurn = false and vice-versa

    // KEEPING TRACK OF WINS, LOSSES, and DRAWS
    // Win conditions row = match, column = match, topLeft, middleMiddle, and bottomRight = match, OR
    // topRight, middleMiddle, and bottomRight = match with the same characters, then user/computer wins
    // ELSE it is a draw (because there were no matches of 3 in this case..)


    // DAVID'S TIPS
    // 1.) Start at a high level
    // 2.) Slow down and become much more specific

    public static int playTTT() {
        // 1.) Find a board or make a board to play on
       String[][] board = generatorBoard();

        // 2.) Determine who is X and/or O
        boolean userIsX = chooseX();

        boolean isGameOver = false;
        while(!isGameOver) {
            // 3.) Make the first move
            if(userIsX == true){

                int userChoice = getUserChoice(board);
                int row = userChoice /3;
                int col = userChoice % 3;
                board[row][col] = "x";

                // after a move is made, determine if it were a winning or game tying move
                isGameOver = checkWonGame(board);
                if(isGameOver == false) {
                    int computerChoice = getComputerChoice(board);
                     row = computerChoice /3;
                     col = computerChoice %3;
                     board[row][col] = "o";

                    isGameOver = checkWonGame(board);
                     // improve terminology
                }
            }
            else {

                int computerChoice = getComputerChoice(board);
                int row = computerChoice /3;
                int col = computerChoice %3;
                board[row][col] = "x";

                isGameOver = checkWonGame(board);
                if(isGameOver == false) {
                    int userChoice = getUserChoice(board);
                     row = userChoice /3;
                     col = userChoice % 3;
                    board[row][col] = "o";

                    isGameOver = checkWonGame(board);
                }


            }
            // 4.) The opponent retaliates
            // 5.) This continues until a winner, or a draw happens

            // insert user value into an empty space

        }
        // 6.) return whether the user/computer won draw, or lost

        return theResult(board);

    }

    public static boolean chooseX() {
        throw new UnsupportedOperationException();
    }

    public static void xOrO() {
     throw new UnsupportedOperationException();
    }

    public static char userVScomputer() {

    }

    public static char emptySpaces() {
        // method applies AFTER the USER/COMPUTER has made their move to let them know if a space was not available
        String[][] gameBoard = generatorBoard();
        char userInput = 'x';
        boolean emptySpace = false;
        // if a space in a board is equal to a "." then it is an empty space!
        System.out.println("\nPlease enter your next move in an empty space..");
        for(int i = 0; i < 9; i++) {
            if(gameBoard[i].equals('.')) {
                emptySpace = true;
                System.out.println(gameBoard[i][i]);
            }
        }

        //throw new UnsupportedOperationException();
        return userInput;
    }

    public static String[][] generatorBoard() {
        String[][] gameBoard = {
                {".",".","."},
                {".",".","."},
                {".",".","."}
        };

        return gameBoard;
    }

    public static void displayBoard(String[][] array) {
        //System.out.println(gameBoard);
        for (int i = 0; i < 9; i++) {
            int row = i / 3;
            int col = i % 3;

            if (i % 3 == 0) {
                System.out.println();
            }
            System.out.print(array[row][col] + " ");
            // after a move is made, display this method to see the now updated board
        }
    }

    public static int[][] gameBoard(int[][] array) {
        return array;
    }
    public static void possibleMoves() {
        // this will consist of the 9 possible moves you can make
        // topLeft = board[0][0]
        // topMiddle = board[0][1]
        // topRight = board[0][2]
        // middleLeft = board[1][0]
        // middleMiddle = board[1][1]
        // middleRight= board[1][2]
        // bottomLeft = board[2][0]
        // bottomMiddle = board[2][1]
        // bottomRight = board[2][2]
    }
    
    public static void checkEmptySpaces() {
        // if a space does not contain an X or O it is empty..
        // if a space contains an X or O that option should be taken away from the user/computer
    }

    public static void getUserChoice() {
        // will require user input
        // implement a switch case
        // based on the number that is picked..it will enter the move?
        // example: user enters "1" and the case --> topLeft = boardGame[0][0
        throw new UnsupportedOperationException();
    }

    public static void checkWonGame(boolean winningMove) {
        //have the set positions on the baord (9 possibilites)
        // if any of the combinations exist then it will be a win, else it was a draw..
        // You can win by matching row, column, or the 2 diagonal cases (4 ways)
        // (Nested If) if row matches --> winningMove = true;
        // perhaps create a function called "updatedBoard" to represent each move that was made..?
        // run a loop through updatedBoard so if updatedBoard has a match of the 4 cases we can trigger this method?
        throw new UnsupportedOperationException();
    }

    public static void updatedBoard() {
        // this will take the gameboard array of "."'s..
        // once a move is made this board should be updated and displayed..

    }

    public static void getComputerChoice(int move) {
        // computer choice will be randomly generated between 1-9 to abide by the switch case
        // implement a switch case
        // based on the number that is picked..it will enter the move?
        // example: user enters "1" and the case --> topLeft = boardGame[0][0]


        //throw new UnsupportedOperationException();
    }

    public static void theResult() {
        // once checkWonGame determines if there was a win or draw we come here for the result..
        // if there is a winner determine who won
        // the winner gets an increment
        // draw has its own count to increment
        throw new UnsupportedOperationException();
    }
}
