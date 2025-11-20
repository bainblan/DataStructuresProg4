//package cs2720.p4;

public class HeapSort implements SortStrategy {

    private long comparisons = 0;

    public long getComparisons() {
        return comparisons;
    }

    @Override
    public void sort(int[] array) {
        // heap sort implementation
        heapSort(array, array.length);
    }

    private void heapSort(int[] values, int numValues) {
        // Convert array values[0..numValues-1] into a heap
        // (AKA Build-Max-Heap)
        for (int i = numValues / 2 - 1; i >= 0; i--) {
            reheapDown(values, i, numValues - 1);
        }
        // Sort the array.
        for (int end = numValues - 1; end > 0; end--) {
            swap(values, 0, end);
            reheapDown(values, 0, end - 1);
        }
    }

    private void reheapDown(int[] values, int root, int bottom) {
        int left = root * 2 + 1;
        int right = root * 2 + 2;

        if (left > bottom)
            return;

        int maxChild = left;
        // Compare left vs right
        if (right <= bottom) {
            comparisons++; // COUNT
            if (values[right] > values[left]) {
                maxChild = right;
            }
        }
        // Compare child vs root
        if (values[maxChild] > values[root]) {
            swap(values, maxChild, root);
            reheapDown(values, maxChild, bottom);
        }
    }

    private void swap(int[] values, int item1, int item2) {
        int temp = values[item1];
        values[item1] = values[item2];
        values[item2] = temp;
    }
}
