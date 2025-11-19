import java.util.Random;

public class QuickSortRandom implements SortStrategy {

    private long comparisons = 0;

    public long getComparisons() {
        return comparisons;
    }

    @Override
    /**
     * Sort the given array using quick sort.
     *
     * @param array the array to sort
     */
    public void sort(int[] array) {
        // quick sort implementation
        quickSortRand(array, 0, array.length - 1);
    }

    private final Random rand = new Random();

    public void quickSortRand(int[] arr, int first, int last) {
        if (first < last) {
            int pivotIndex = randomPartition(arr, first, last);
            quickSortRand(arr, first, pivotIndex - 1);
            quickSortRand(arr, pivotIndex + 1, last);
        }
    }

    private int randomPartition(int[] arr, int first, int last) {
        int randomIndex = first + rand.nextInt(last - first + 1);
        // swap random pivot into last
        swap(arr, randomIndex, last);
        return partition(arr, first, last);
    }

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

    private void swap(int[] values, int item1, int item2) {
        int temp = values[item1];
        values[item1] = values[item2];
        values[item2] = temp;
    }
}
