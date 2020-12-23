public class ArrayOperation {
    public int[] fillArrayFromInterval(int[] array, int start, int end) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (end - start + 1)) + start;
        }
        return array;
    }

    public int[] bubbleSort(int[] array) {
        int tmp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    public void mergeSort(int[] array) {
        if (array.length < 2) return;

        int[] left = new int[array.length / 2];
        int[] right = new int[array.length - left.length];

        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, left.length, right, 0, right.length);

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    public void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}
