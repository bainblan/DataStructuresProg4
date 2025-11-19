
public class SelectionSort implements SortStrategy {

    @Override
    /**
     * Sort the given array using selection sort.
     *
     * @param array the array to sort
     */
    public void sort(int[] array) {
        selectionSort(array, array.length - 1);
    }

    private long comparisons = 0;
    
    public long getComparisons() {
        return comparisons;
    }

    /**
     * Find the index of the minimum element in values between start and end (inclusive).
     *
     * @param values the array to search
     * @param start start index (inclusive)
     * @param end end index (inclusive)
     * @return index of the minimum element
     */
    private int minIndex(int[] values, int start, int end) {
        int indexOfMin = start;
        for (int index = start + 1; index <= end; index++) {
            if (values[index] < values[indexOfMin]) {
                indexOfMin = index;
            }
        }
        return indexOfMin;
    }

    /**
     * Perform selection sort on the given range of the array.
     *
     * @param values the array to sort
     * @param numValues the number of values (usually array.length - 1)
     */
    private void selectionSort(int[] values, int numValues) {
        int endIndex = numValues;
        for (int current = 0; current < endIndex; current++) {
            int minIdx = minIndex(values, current, endIndex);
            int temp = values[current];
            values[current] = values[minIdx];
            values[minIdx] = temp;
        }
    }
}
