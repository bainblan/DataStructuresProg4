/**
 * Selection sort implementation that counts element comparisons.
 */
public class SelectionSort implements SortStrategy {

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
     * Sorts the provided array using selection sort and resets the comparison counter.
     *
     * @param array the array to sort
     */
    @Override
    public void sort(int[] array) {
        comparisons = 0;
        selectionSort(array, array.length);
    }

    /**
     * Returns the index of the minimum element in values[start..end].
     * Increments the comparison counter once per compared element.
     */
    private int minIndex(int[] values, int start, int end) {
        int indexOfMin = start;
        for (int index = start + 1; index <= end; index++) {
            comparisons++;
            if (values[index] < values[indexOfMin]) {
                indexOfMin = index;
            }
        }
        return indexOfMin;
    }

    /**
     * Performs selection sort on the array.
     */
    private void selectionSort(int[] values, int numValues) {
        int endIndex = numValues - 1;
        for (int current = 0; current < endIndex; current++) {
            int minIndex = minIndex(values, current, endIndex);
            int temp = values[current];
            values[current] = values[minIndex];
            values[minIndex] = temp;
        }
    }
}
