import javax.swing.tree.TreeNode;
import java.util.*;
public class App {

    public static void main(String[] args) {

        int[] arr= {-1, 0, 2, 3, 6, 8, 9, 13, 17};
        int target = 9;

        System.out.println(search(arr, target));
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
        for (int row = 0; valid && row < 9; row++) {
            for (int col = 0; valid && col < 9; col++) {
                if (board[row][col] != '.') {
                    // check current row
                    //the current row
                    //the current nox of 3x3
                    int bocTopR = row / 3 * 3; // row divided by 3
                    int boxLeftC = col / 3 * 3;


                    for (int i = 0; valid && i < 9; i++) {
                        int boxR = bocTopR + i / 3;
                        int boxC = boxLeftC + i % 3;


                        // thrree spots to checl
                        //[row][i]
                        //[i][col]
                        //[boxR][boxC]
                        // need to make sure we're not looking
                        // at the current square

                        if ((row != boxR|| col != boxC) && (board[row][col] == board[boxR][boxC]))
                            valid = false;
                        if (row != i && board[row][col] == board[i][col])
                            valid = false;
                        if (col != row && board[row][col] == board[row][i])
                            valid = false;


                    }
                    // calculate for upper left corner of each 3x3 box
                    // utilized a spreadsheet to calculate for this
                }
            }
            return valid;
        }
        return valid;
    }

    public void solveSudoku(char[][] board) {

        // He said it was going to be a 'guess and check'
        // would need to use recursion
        if (isValidSudoku(board)) {
            // if an element in a row != '.' we need to input a number
            // if that number exists on the same row or column try another number
            // if that number exists within the same 3x3 box try another number
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (board[row].equals('.')) {
                        board[row] = board[row];
                        if (board[row] == board[row]) {
                            board[row] = board[row + 1];
                        }
                    }
                    if (board[col].equals('.')) {
                        board[col] = board[col];
                        if (board[col] == board[col]) {
                            board[col] = board[col + 1];
                        }

                    }
                }
            }
            // by the end of this class then a problem like this should be simple..



        }
    }


     // Definition for a binary tree node.
     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        public int rangeSumBST(TreeNode root, int low, int high) {


            // So we'll use RNG class for that low and high...
            // within the root -
            // grab elements between low and high inclusive
            // sum the elements between low and high inclusive
            // return the sum

            int sum = 0;
            if(root == null) return 0;

            if(low <= root.val && root.val <= high){
                sum = root.val;

            }
            return sum;
        }

        public class ListNode {

        int val;
        ListNode next;

     ListNode() {

     }
     ListNode(int val) {
         this.val = val; }

     ListNode(int val, ListNode next) {
         this.val = val;
         this.next = next; }
  }

        public ListNode reverseList(ListNode head) {
        // a linked list will hold the value in the next position of itself
            // now do that in reverse! :D

            ListNode behind = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode temp = curr.next;
                curr.next = behind;
                behind = curr;
                curr = temp;
            }
            return behind;



        }
    }

    public static int search(int[] nums, int target) {


        // the array you get is in order and ascending
        // target represents the number we're supposed to find
        // return type of int, meaning the index we find based on the target is what should be returned..
//
//        int index = -1;
//
//        int i = 0;
//        while(nums[i] != target){
//            if(nums[i] != target){
//                nums[i]
//            }
//        }
//
//        //return -1;
        throw new UnsupportedOperationException();
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
         val = x;
          next = null;
      }
  }


        public boolean hasCycle(ListNode head) {

        // if there are to be no duplicates we can use a data structure..
            // after researching a Set prevents duplicates.
            // Create a Set of ListNode to use a hash set of the visible node
            Set<ListNode> visibleNode = new HashSet<>();

            //while the head node is not null, we'll check if the visible node contains the head node
            // null would mean we've reached the end of the list
            // if true return true
            while (head != null) {
                if (visibleNode.contains(head)) {
                    return true;
                }
                // if the if-condition is not met we add the head to the visible node Set and
                // continue this process until we reach the end of the list "null"
                visibleNode.add(head);
                head = head.next;
            }
            return false;
        }

    public ListNode swapPairs(ListNode head) {

        // return the head.
        // if head = {} return {}
        // if head.size = 1, return [1];

        ListNode tempNode = new ListNode(0);
        tempNode.next = head;
        ListNode currentNode = tempNode;
        while(currentNode.next!= null && currentNode.next.next != null){
            ListNode first_Node = currentNode.next;
            ListNode second_Node = currentNode.next.next;
            first_Node.next = second_Node.next;
            currentNode.next =  second_Node;
            currentNode.next.next =  first_Node;
            currentNode = currentNode.next.next;

        }
        return tempNode.next;
    }
    }


