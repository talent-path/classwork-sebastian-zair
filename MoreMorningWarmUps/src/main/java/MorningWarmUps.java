public class MorningWarmUps {
    public static void main(String[] args) {
        int num = 56;
        int orangesLeft = minDays(num);
        System.out.println(orangesLeft);
    }

    public static int minDays(int n) {

        // You can eat 1 orange
        // if the amount of oranges that are n is divisible by 2 then you can only eat n/2 oranges.. which means half.
        // If the amount of oranges that are n is divisible by 3 then you can only eat 2/3 of the oranges..

        // return the MINIMUM number of days to eat 'n' oranges..
        // AKA what's the quickest number of days needed to eat all given oranges

        int  numOfDays;
        int orangesLeft = n;
        int orange = 1;
        while(orangesLeft != 0) {
            if( n%2 != 0 && n%3 != 0){

                orangesLeft -= orange;

            }

            else if(orangesLeft%2 == 0){
                orangesLeft = n/2;
            }
            else{
                orangesLeft = 2 * (n%3);
            }
            orangesLeft--;

        }
        return orangesLeft;
    }

    public boolean validTicTacToe(String[] board) {

        int oCount = 0;
        int xCount = 0;
        String converted1 = board[0];
        String converted2 = board[1];
        String converted3 = board[2];

        for(int i = 0; i < board.length; i++){
            if(converted1.charAt(i) == 'O'){
                oCount++;
            }
            if(converted2.charAt(i) == 'O'){
                oCount++;
            }
            if(converted3.charAt(i) == 'O'){
                oCount++;
            }
        }
        for(int i = 0; i < board.length; i++){
            if(converted1.charAt(i) == 'X'){
                xCount++;
            }
            if(converted2.charAt(i) == 'X'){
                xCount++;
            }
            if(converted3.charAt(i) == 'X'){
                xCount++;
            }
        }
        if(oCount > xCount){
            return false;
        }

        if(xCount + 2 > oCount){
            return false;
        }

        return true;
    }

    public int islandPerimeter(int[][] grid) {

        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                if(grid[i][j] == 1){
                    if(j-1 == -1 || grid[i][j-1] == 0) // check the left side
                        count++;
                    if(i-1 == -1 || grid[i-1][j] == 0)  // check the top side
                        count++;
                    if(j+1 == col || grid[i][j+1] == 0)   // check the right side
                        count++;
                    if(i+1 == row || grid[i+1][j] == 0)  // check the down side
                        count++;
                }

        return count;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) return true;

        for(int i=0; i<flowerbed.length; i++){
            if(flowerbed[i]==0 && (i==0 || flowerbed[i-1]==0) &&
                    (i==flowerbed.length-1 || flowerbed[i+1]==0)){
                n--;
                flowerbed[i] = 1;
                if(n==0) return true;
            }
        }

        return false;
    }
}
