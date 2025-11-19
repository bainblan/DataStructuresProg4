
public class MergeSort implements SortStrategy {

    private long comparisons = 0;

    public long getComparisons() {
        return comparisons;
    }

    /**
     * Sort the given array using merge sort.
     *
     * @param array the array to sort
     */
    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * Recursively sort the portion of the array between left and right.
     *
     * @param arr   the array to sort
     * @param left  left index of the range to sort
     * @param right right index of the range to sort
     */
    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right)
            return;

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    /**
     * Merge two sorted subarrays [left..mid] and [mid+1..right] into arr.
     *
     * @param arr   the array containing the halves to merge
     * @param left  left index of first half
     * @param mid   end index of first half
     * @param right end index of second half
     */
    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        
        while (i <= mid && j <= right) {
            comparisons++;
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (int t = 0; t < temp.length; t++) {
            arr[left + t] = temp[t];
        }
    }
}
