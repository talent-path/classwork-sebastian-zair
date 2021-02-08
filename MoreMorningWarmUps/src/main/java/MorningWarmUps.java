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
git             orangesLeft--;

        }
        return orangesLeft;
    }
}
