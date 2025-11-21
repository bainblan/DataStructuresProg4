/**
 * MergeSort implementation of {@link SortStrategy}.
 * Counts comparisons performed while merging.
 */
public class MergeSort implements SortStrategy {

    private long comparisons = 0;

    /**
     * Returns the number of element comparisons performed by the last sort.
     *
     * @return comparison count
     */
    public long getComparisons() {
        return comparisons;
    }

    /**
     * Sorts the provided array using merge sort and resets the comparison counter.
     *
     * @param array the array to sort
     */
    @Override
    public void sort(int[] array) {
        comparisons = 0;
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * Recursive merge sort on subarray arr[left..right].
     *
     * @param arr the array being sorted
     * @param left left index of subarray
     * @param right right index of subarray
     */
    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    /**
     * Merges two sorted halves of arr[left..mid] and arr[mid+1..right].
     * Increments the comparison counter once per element comparison.
     *
     * @param arr the array containing the subarrays
     * @param left left index of first half
     * @param mid end index of first half
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
