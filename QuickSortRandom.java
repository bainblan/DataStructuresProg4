import java.util.Random;

/**
 * QuickSort implementation that chooses a random pivot for each partition.
 * Tracks comparisons performed during partitioning.
 */
public class QuickSortRandom implements SortStrategy {

    private final Random rand = new Random();

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
     * Sorts the provided array using randomized quicksort and resets the comparison counter.
     *
     * @param array the array to sort
     */
    @Override
    public void sort(int[] array) {
        comparisons = 0;
        quickSortRand(array, 0, array.length - 1);
    }

    /**
     * Recursive randomized quicksort on subarray arr[first..last].
     */
    public void quickSortRand(int[] arr, int first, int last) {
        if (first < last) {
            int pivotIndex = randomPartition(arr, first, last);
            quickSortRand(arr, first, pivotIndex - 1);
            quickSortRand(arr, pivotIndex + 1, last);
        }
    }

    /**
     * Picks a random pivot in the range, swaps it to the end, and partitions.
     */
    private int randomPartition(int[] arr, int first, int last) {
        int randomIndex = first + rand.nextInt(last - first + 1);
        swap(arr, randomIndex, last);
        return partition(arr, first, last);
    }

    /**
     * Partitions arr[first..last] using the last element as pivot and returns pivot index.
     * Increments comparison counter once per compared element.
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
