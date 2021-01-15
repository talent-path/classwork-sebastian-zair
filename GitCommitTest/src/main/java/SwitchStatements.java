import java.util.*;
public class SwitchStatements {

    public static void main(String[] args) {
//        String direction1 = "";
//        String direction2 = "";
        Scanner input = new Scanner(System.in);


        System.out.println("Hello, User! Go on and select a path into your wild adventure: ");
        System.out.println("Select a number 1-6 to go on a journey..Enter '0' to exit the journey..");
        String choice = input.nextLine();
        int userChoice = Integer.parseInt(choice);

        while (userChoice != 0) {
            System.out.println("Select a number 1-6 to go on a journey..Enter '0' to exit the journey..");
            if (userChoice == 1) {
                System.out.println("Welcome to route 1, you can 'a' eat an apple, 'b' run from the monster " +
                        "or 'c', look for route 2");
            }
            System.out.println("Enter 'a', 'b', or 'c' now: ");
            char choice2 = input.next().charAt(0);


            switch(choice2) {
                case 'a':
                    System.out.println("By selecting 'a' you have chosen a poisonous apple that will kill you.."); break;

                case 'b':
                    System.out.println("By selecting 'b' you have selected a life of good deeds. Congrats!"); break;

                case 'c':
                    System.out.println("By selecting 'c' you have decided to move onto route 2..unwise..");
            }
// :D
            if(userChoice ==2) {
                System.out.println("Welcome to route 2! I hope this becomes a memborable experience for ya..");
                System.out.println("Enter '6', 7, or 8 to see what lies in this route");

                int choice3 = input.nextInt();

                switch(choice3){
                    case 6:
                        System.out.println("You've picked 6..weird"); break;

                    case 7:
                        System.out.println("Why was 6 afraid of 7..? Because 7 8 9! And the monster will eat YOU..");

                    case 8:
                        System.out.println("8 is the number of a GOAT. RIP Konbe~");
                }

            }
        }

        System.out.println("You're out of the loop. BYE!");
    }
}
