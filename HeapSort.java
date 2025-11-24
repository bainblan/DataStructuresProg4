/**
 * HeapSort implementation of {@link SortStrategy}.
 * Tracks element comparisons performed during heap operations.
 */
public class HeapSort implements SortStrategy {

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
     * Sorts the provided array in-place using heap sort and resets the comparison counter.
     *
     * @param array the array to sort
     */
    @Override
    public void sort(int[] array) {
        comparisons = 0;
        heapSort(array, array.length);
    }

    /**
     * Builds a heap from the array and performs the sort.
     *
     * @param values the array to sort
     * @param numValues number of valid elements in the array
     */
    private void heapSort(int[] values, int numValues) {
        for (int i = numValues / 2 - 1; i >= 0; i--) {
            reheapDown(values, i, numValues - 1);
        }
        for (int end = numValues - 1; end > 0; end--) {
            swap(values, 0, end);
            reheapDown(values, 0, end - 1);
        }
    }

    /**
     * Restores the heap property for the subtree rooted at {@code root} up to {@code bottom}.
     * Counts comparisons between children and between child and root.
     *
     * @param values heap array
     * @param root index of the subtree root
     * @param bottom last index in the heap region
     */
    private void reheapDown(int[] values, int root, int bottom) {
        int left = root * 2 + 1;
        int right = root * 2 + 2;

        if (left > bottom)
            return;

        int maxChild = left;
        if (right <= bottom) {
            comparisons++;
            if (values[right] > values[left]) {
                maxChild = right;
            }
        }
        comparisons++;
        if (values[maxChild] > values[root]) {
            swap(values, maxChild, root);
            reheapDown(values, maxChild, bottom);
        }
    }

    /**
     * Swaps two elements in the array.
     *
     * @param values the array
     * @param item1 index of first element
     * @param item2 index of second element
     */
    private void swap(int[] values, int item1, int item2) {
        int temp = values[item1];
        values[item1] = values[item2];
        values[item2] = temp;
    }
}