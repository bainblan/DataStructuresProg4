//package cs2720.p4;

public class SelectionSort implements SortStrategy {

    private long comparisons = 0;

    public long getComparisons() {
        return comparisons;
    }
    
    @Override
    public void sort(int[] array) {
        // selection sort implementation
        selectionSort(array, array.length);
    }

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
