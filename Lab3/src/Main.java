public class Main {
    public static final int ARRAY_SIZE = 10_000_000;
    public static final int START = -10_000;
    public static final int END = 10_000;

    public static void main(String[] args) {
        ArrayOperation arrayOperation = new ArrayOperation();
        int[] array = new int[ARRAY_SIZE];
        array = arrayOperation.fillArrayFromInterval(array, START, END);

        long startTime = System.currentTimeMillis();
        int evenNumberAmount = arrayOperation.countEvenNumbers(array);
        long endTime = System.currentTimeMillis();
        System.out.println(evenNumberAmount + " even numbers, " + (ARRAY_SIZE - evenNumberAmount) + " odd numbers.");
        System.out.println("Execution time: " + (endTime - startTime));
    }
}
