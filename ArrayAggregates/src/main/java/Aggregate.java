public class Aggregate {

    public static int min(int[] arr) {
        int min = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }
    public static int max(int[] arr) {
        int max =0;
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public static double average(int[] arr) {
        double average = 0;
        double sum =0;
       // double sum = sum()
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        average = sum/arr.length;
        return average;
    }
    public static double standardDeviation(int[] arr) {
        // (num - avg)^2 + itself over the course of the array will get you your answer :}
        //double standev = 0;
        double prelude =0;
        double mainCourse =0;
        double average = 0;
        double sum =0;
        double squaredNumber = 0;
        // double sum = sum()
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        average = sum/arr.length;
        // SQUARE THE NUMBER = (number, what you're squaring it by)
        for(int i = 0; i <arr.length; i++){
            squaredNumber =Math.pow(arr[i] - average, 2);
            mainCourse += squaredNumber;
        }
        double newNumber = mainCourse/arr.length;
        double YAY = Math.sqrt(newNumber);
        return YAY;
    }
}
