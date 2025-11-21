/**
 * QuickSort implementation choosing the last element as pivot.
 * Counts comparisons performed during partitioning.
 */
public class QuickSortLast implements SortStrategy {

    private long comparisons = 0;

    /**
     * Returns the number of comparisons performed by the last sort.
     *
     * @return comparison count
     */
    public long getComparisons() {
        return comparisons;
    }

    /**
     * Sorts the provided array using recursive quicksort (last-element pivot).
     * Resets the comparison counter prior to sorting.
     *
     * @param array the array to sort
     */
    @Override
    public void sort(int[] array) {
        comparisons = 0;
        quickSortLast(array, 0, array.length - 1);
    }

    /**
     * Recursive quicksort on subarray values[first..last].
     */
    private void quickSortLast(int[] values, int first, int last) {
        if (first < last) {
            int pivot = partition(values, first, last);
            quickSortLast(values, first, pivot - 1);
            quickSortLast(values, pivot + 1, last);
        }
    }

    /**
     * Partitions arr[first..last] using the last element as pivot and returns pivot index.
     * Increments the comparison counter once per compared element.
     */
    private int partition(int[] arr, int first, int last) {
        int pivot = arr[last];
        int i = first - 1;
        for (int j = first; j < last; j++) {
            comparisons++;
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, last);
        return i + 1;
    }

    /**
     * Swaps two elements in the array.
     */
    private void swap(int[] values, int item1, int item2) {
        int temp = values[item1];
        values[item1] = values[item2];
        values[item2] = temp;
    }
}
