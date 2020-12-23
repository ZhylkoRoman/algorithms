public class ArrayOperation {
    public int[] fillArrayFromInterval(int[] array, int start, int end) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (end - start + 1)) + start;
        }
        return array;
    }

    public int dichotomousSearch(int[] numbers, int key) {
        int left = 0;
        int right = numbers.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (numbers[mid] == key) {
                return mid;
            }
            if (numbers[mid] < key) {
                left = mid + 1;
            }
            if (numbers[mid] > key) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
