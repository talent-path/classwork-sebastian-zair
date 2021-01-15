import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String userInput = input.nextLine();

        String[][] boardName = Rules.generatorBoard();

        //int randomNumber = 1 + (int)(Math.random() * 9); -- random generator between 1-9 for computer
        //gameBoard2 [0][1] = "HI IM PAUL!"; -- user input

        Rules.displayBoard(boardName);
        //System.out.println("\n"+randomNumber);

        boolean isEmpty = false;
        if(!boardName[0][1].equals('X') || !boardName[0][1].equals('O')){
            isEmpty = true;
            if(isEmpty) {
                // the user can put something in this location..
                System.out.println("\nPlease enter a move for the top middle space:");
                boardName[0][1] = userInput;
                if(!userInput.equals('X') || !userInput.equals('O')) {
                    System.out.println("Please enter an X or O..don't be difficult..");
                    boardName[0][1] = userInput;
                }
                Rules.displayBoard(boardName);
            }
        }

            }
        }


