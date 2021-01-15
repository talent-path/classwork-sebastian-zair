public class App {
    public static void main(String[] args) {
        int[] array = {3, 4, 17, 2, 8, 9};

        int minValue = Aggregate.min(array); // 2
        int maxValue = Aggregate.max(array); // 17
        int sumValue = Aggregate.sum(array); // 43
        double avgValue = Aggregate.average(array); // 7.1666666667
        double stdValue = Aggregate.standardDeviation(array); // 5.0799
        System.out.println(minValue);
        System.out.println(maxValue);
        System.out.println(sumValue);
        System.out.println(avgValue);
        System.out.println(stdValue);
    }
}
