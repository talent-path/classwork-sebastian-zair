public class App {

    public static void main(String[] args) {

        int[] array = {8, 2, 5, 5, 5, 6};
        int[] array2 = {2, 6,6,6};
        int[] array3 = {1, 2, 3, 4, 5, 6};
        System.out.println(noTripples(array));
        System.out.println(noTripples(array2));
        System.out.println(noTripples(array3));
    }

    public static boolean noTripples(int[] arr) {
        // return true if the same element is not in the array 3 times
        // consecutively!

        boolean defNoTripples = false;
        for(int i = 0; i < arr.length; i++) {

            if(arr.length < 3) {
                return false;
            }
            else if(arr[i] != arr[i + 1] && arr[i] != arr[i+2]) {
                defNoTripples =  true;
                break;
            }
            else {
                return false;
            }
        }
        return defNoTripples;


    }

    }
