import java.util.Arrays;

public class Main {
    public static final int START = 0;
    public static final int END = 100;
    public static final int ARRAY_SIZE = 10_000_000;
    public static final int KEY = 15;

    public static void main(String[] args) {
        int[] array = new int[ARRAY_SIZE];
        ArrayOperation arrayOperation = new ArrayOperation();
        arrayOperation.fillArrayFromInterval(array, START, END);

        Arrays.sort(array);
        long startTime = System.nanoTime();
        int keyPosition = arrayOperation.dichotomousSearch(array, KEY);
        long endTime = System.nanoTime();
        System.out.println(keyPosition != -1 ? "Key position: " + keyPosition : "There's no such key in array");
        System.out.println("Execution time: " + (endTime - startTime) + " nanos");
    }
}