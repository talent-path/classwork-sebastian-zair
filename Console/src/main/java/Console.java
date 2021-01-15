import java.util.Scanner;
public class Console {
    public static void print(String printmsg)
    {
        System.out.println(printmsg);
    }
    public static int readInt(String msg, int min, int max) {
        // Take the int from 'readInt' and determine if it is within the desired min and max range
        // Ask Mr. David if these are the correct instructions
        // Questions:
        // 1.) I am not understanding why "range" needs to be manipulated if we're only determining if it's in range
        // 2.)
        System.out.println("Is the user input in the acceptable range?\n");
        int range = readInt(msg);

        while(range != 0)
        if(range <= max && range >= min) {
            System.out.println("You are in the correct range");
        }
        else {
            System.out.println("You are not in the correct range. Please try again!");
        }

        return range;
    }
    public static int readInt (String msg) {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        int parsedInt = Integer.MIN_VALUE;
        while(!valid) {
            print(msg);
            String userInput = input.nextLine();
            try
            {
                parsedInt = Integer.parseInt(userInput);
                valid = true;
            } catch(NumberFormatException ex) {
                //keep looping
            }
        }
        return parsedInt;
    }

}
