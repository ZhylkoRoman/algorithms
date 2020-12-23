import java.util.Arrays;

public class Main {

    public static final int ARRAY_SIZE = 50_000;
    public static final int START = -1000;
    public static final int END = 1000;

    public static void main(String[] args) {
        int[] firstArray = new int[ARRAY_SIZE];
        ArrayOperation arrayOperation = new ArrayOperation();
        arrayOperation.fillArrayFromInterval(firstArray, START, END);
        int[] secondArray = Arrays.copyOf(firstArray, ARRAY_SIZE);

        long startTimeOfBubbleSort = System.currentTimeMillis();
        arrayOperation.bubbleSort(firstArray);
        long endTimeOfBubbleSort = System.currentTimeMillis();

        long startTimeOfMergeSort = System.currentTimeMillis();
        arrayOperation.mergeSort(secondArray);
        long endTimeOfMergeSort = System.currentTimeMillis();

        //System.out.println(Arrays.toString(firstArray));
        System.out.println("Execution time of bubble sort: " + (endTimeOfBubbleSort - startTimeOfBubbleSort));
        //System.out.println(Arrays.toString(secondArray));
        System.out.println("Execution time of merge sort: " + (endTimeOfMergeSort - startTimeOfMergeSort));
    }

}