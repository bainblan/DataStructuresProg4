package cs2720.p4;

public class QuickSort implements SortStrategy {

    @Override
    /**
     * Sort the given array using quick sort.
     *
     * @param array the array to sort
     */
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] values, int first, int last) {
        if (first < last) {
            int pivot = partition(values, first, last);
            quickSort(values, first, pivot - 1);
            quickSort(values, pivot + 1, last);
        }
    }

    private int partition(int[] values, int first, int last) {
        /**
         * Partition the subarray values[first..last] around a pivot (last element).
         * Elements <= pivot are moved to the left of the pivot index.
         *
         * @param values the array to partition
         * @param first start index for partition
         * @param last end index for partition (pivot)
         * @return the final pivot index
         */
        int x = values[last];
        int i = first - 1;
        for (int j = first; j < last - 1; j++) {
            if (values[j] <= x) {
                i++;
                int temp = values[i];
                values[i] = values[j];
                values[j] = temp;
            }
        }
        int temp = values[i + 1];
        values[i + 1] = values[last];
        values[last] = temp;
        return i++;
    }
}
