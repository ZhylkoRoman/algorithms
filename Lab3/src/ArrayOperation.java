public class ArrayOperation {

    public int[] fillArrayFromInterval(int[] array, int start, int end) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (end - start + 1)) + start;
        }
        return array;
    }

    public int countEvenNumbers(int[] array) {
        int count = 0;
        for (int value : array) {
            if (value % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
