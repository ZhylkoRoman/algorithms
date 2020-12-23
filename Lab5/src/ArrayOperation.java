public class ArrayOperation {

    public int interpolationSearch(int[] arr, int key){
        return recursiveInterpolationSearch(arr, key, 0, arr.length - 1);
    }

    public int[] fillArrayFromInterval(int[] array, int start, int end) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (end - start + 1)) + start;
        }
        return array;
    }


    public int recursiveInterpolationSearch(int[] arr, int key, int left, int right) {
        if (arr[left] == key)
            return left;
        else if (left == right || arr[left] == arr[right])
            return -1;

        int index = left + (key - arr[left]) * (right - left) / (arr[right] - arr[left]);

        if (arr[index] == key)
            return index;
        else if (arr[left] < key)
            return recursiveInterpolationSearch(arr, key, index + 1, right);
        else
            return recursiveInterpolationSearch(arr, key, left, index - 1);
    }

}
