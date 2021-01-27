import java.util.*;
public class App {

    public static void main(String[] args) {

        char[][] twoD = {
                {'9', '.', '.', '.', '.', '.', '7', '.', '.',
                        '.', '.', '3', '.', '.', '.', '.', '3', '.',
                        '.', '4', '.', '.', '.', '.', '.', '.', '9',
                        '.', '.', '.', '.', '5', '.', '.', '.', '.',
                        '.', '.', '.', '.', '.', '.', '.', '.', '.',
                        '4', '.', '6', '.', '.', '7', '.', '.', '1',
                        '.', '5', '.', '.', '.', '.', '.', '8', '.',
                        '.', '.', '.', '.', '.', '.', '.', '.', '3',}
        };

        System.out.println(isValidSudoku(twoD));
    }

    public static boolean noTripples(int[] arr) {
        // return true if the same element is not in the array 3 times
        // consecutively!

        boolean defNoTripples = false;
        for (int i = 0; i < arr.length; i++) {

            if (arr.length < 3) {
                return false;
            } else if (arr[i] != arr[i + 1] && arr[i] != arr[i + 2]) {
                defNoTripples = true;
                break;
            } else {
                return false;
            }
        }
        return defNoTripples;


    }

    // newest method
    public static int[] addBigSum(int[] left, int[] right) {

        //left = new int[100];
        //right = new int[100];
        int[] arraySum = new int[101]; // ask if this is what is meant

        // populate left array randomly 0-9
        for (int i = 0; i < left.length; i++) {
            left[i] = (int) (Math.random() * 9);
            System.out.println(left[i]);
        }

        // populate right array randomly 0-9
        for (int i = 0; i < right.length; i++) {
            right[i] = (int) (Math.random() * 9);
            System.out.println(right[i]);
        }

        if (left[left.length - 1] + right[right.length - 1] > 9) {
            arraySum = new int[left.length + 1];
            for (int i = 0; i < arraySum.length; i++) {
                arraySum[i] = left[i] + right[i];
            }
            arraySum[arraySum.length - 1] = left[left.length - 1] + right[right.length - 1] % 10;
        }


        return arraySum;
    }

    public static Map<String, List<String>> groupByFirstTwoLetters(String[] toGroup) {

        // Plan:
        // The element(s) in the String array > 3 length has their first 2 characters substringed
        // Those first 2 chars in the String = Map KEY
        // The entire element = the Value

        ArrayList<String> newList = new ArrayList<>();
        newList.add("Bob");
        newList.add("Bobby");
        newList.add("Robert");
        newList.add("Roberto");
        newList.add("Alice");
        newList.add("Alecia");

        toGroup = newList.toArray(new String[0]);

        for (int i = 0; i < toGroup.length; i++) {
            //Map<String, List<String>> map = new Map<>();
            String prefix = toGroup[i].substring(0, 2);
            String value = toGroup[i];
            // map.put(prefix, value);
        }
        throw new UnsupportedOperationException();
    }

    public static int longestChain(long num) {
        int count = 0;
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
                count++;
            } else {
                if (num % 2 != 0) {
                    num = (num * 3) + 1;
                    count++;
                }
            }
        }
        return count;
    }

    public static int reversedDigit(int num) {
        // think on how to flip a number without using a String..
        // however could we also use an array..?
        // first of all if the num == length of 1 then return 1?

        if (num / 10 < 10) {
            return 1;
        }
        List<Integer> holdNum = new ArrayList<Integer>();

        int i = 0;
        while (i < num) {
            int remainNum = num % 10;
            remainNum /= 10;
            holdNum.add(remainNum);
            i++;
        }
        System.out.println(holdNum);
        return 0;
    }

    public static int lengthOfLongestSubstring(String s) {
        //if a String doesn't repeat, count
        // if a String repeats, repeat count
        // if the char in the Str is different then count..
        // ..bbbbbb = 1 as an answer..?
        // if it's blank then 0..

        int count = 0;
        if (s.length() < 3) {
            return 1;
        }

        for (int i = 0; i <= s.length(); i++) {
            char c = s.charAt(0);
            char c2 = s.charAt(i + 1);
            if (c == c2) {
                String newString = s.substring(c, c2);
                count = 0;
            }

            count++;
        }
        return count;
    }

    public static boolean isPerfect(int num) {
        // a perfect number is the num * 2..
        // HOWEVER..it also must be num * 2 IF nums factors add up to be so..
        // So every number that num can be divided by must add up to be DOUBLE the original num
        // Let's get on it!

        // I think a while loop would be great for this since we don't really know how many times
        // we'll need to iterate?
        // while variable != num, divide num/variable.  if num/variable == 0..
        // ..int add += num/variable
        // if(add == num * 2) return true; else false
        // Basically if you can find a way to grab the divisors of the number you enter then you win
        // So how do we find the divisor? That's where it'll get tricky..

        // OOOO WAIT!! A number can't be divisble by a number that's > half of the number SOO..
        // I can start at half of the number and THEN go down from there in a for loop instead!!

        //int i = 1;
        int half = num / 2;
        int add = 1;
        int proof = 0;
        for (int i = 1; i <= half; i++) {
            if ((num / i) % 2 == 0 || (num / i) % 3 == 0 || (num / i) % 5 == 0) {
                proof = num / i;
                add += proof;
            }
        }
        if (add == num * 2) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isValidSudoku(char[][] board) {


        // Create a 9x9 2d array.. (board)
        // What's the easiest thing to write first? The marks for the board
        // Can I make an ENUM for this? Probably..not what Leetcode is expecting..
        // Determine if 2D Array 9x9, or if 1D array of 81 elements
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; i++) {
//                System.out.println(board[i][j]);
//            }
//        }
//        // iterate through to account for boxes of 3x3
//        for (int row = 0; row < 3; row++) {
//            for (int col = 0; col < 3; col++) {
//                if (board[row] == board[col] ||
//                        board[row] == board[row] ||
//                        board[col] == board[col]) {
//                    return false;
//                } else {
//                    return true;
//                }
//            }
//
//        }
//
//        // we check if a possible number is already in a row
//        for (int row = 0; row < 9; row++) {
//            if (board[row].equals('.')) {
//                return false;
//            }
//
//        }
//
//        // check possibility for column
//        for (int col = 0; col < 9; col++) {
//            if (board[col].equals('.')) {
//                return false;
//            }
//
//        }
//
//        // iterate through entire grid
//        for (int row = 0; row < 9; row++) {
//            for (int col = 0; col < 9; col++) {
//                if (board[row] == board[col] ||
//                        board[row] == board[row] ||
//                        board[col] == board[col]) {
//                    return false;
//                } else {
//                    return true;
//                }
//            }
//
//        }
//
//        return false;
//    }

        boolean valid = true; // because we're checking if it's NOT valid'

        //iterate through entire cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    // check current row
                    //the current row
                    //the current nox of 3x3
                    int bocTopR = row / 3 * 3; // row divided by 3
                    int boxLeftC = col / 3 * 3;


                    for (int i = 0; i < 9; i++) {
                        int boxR = bocTopR + i / 3;
                        int boxC = boxLeftC + i % 3;


                        // thrree spots to checl
                        //[row][i]
                        //[i][col]
                        //[boxR][boxC]
                        // need to make sure we're not looking
                        // at the current square

                        if (i != col && board[row][i] == board[row][col]) {
                            valid = false;
                        }
                        if (i != row && board[i][col] == board[row][col]) {
                            valid = false;
                        }
                        if ((boxR != row || boxC != col) && (board[boxR][boxC] == board[row][col])) {
                            valid = false;
                        }
                    }
                    // calculate for upper left corner of each 3x3 box
                    // utilized a spreadsheet to calculate for this
                }
            }
        }
        return valid;
    }


}