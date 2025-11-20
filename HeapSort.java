//package cs2720.p4;

public class HeapSort implements SortStrategy {

    private long comparisons = 0;

    public long getComparisons() {
        return comparisons;
    }

    @Override
    public void sort(int[] array) {
        // heap sort implementation
        heapSort(array, array.length - 1);
    }

    private void heapSort(int[] values, int numValues) {
        int index;
        int comparisons = 0;
        // Convert array values[0..numValues-1] into a heap
        // (AKA Build-Max-Heap)
        for (index = numValues / 2 - 1; index >= 0; index--) {
            comparisons += reheapDown(values, index, numValues - 1);
        }
        // Sort the array.
        for (index = numValues - 1; index >= 1; index--) {
            swap(values, numValues, index);
            comparisons += reheapDown(values, 0, index - 1);
        }
        System.out.println("HeapSort comparisons: " + comparisons);
    }

    private int reheapDown(int[] values, int root, int bottom) {
        int maxIndex;
        int rightChild;
        int leftChild;
        int comparisons = 0;
        leftChild = root * 2 + 1;
        rightChild = root * 2 + 2;
        // ReheapDown continued
        maxIndex = -1;
        if (leftChild <= bottom) {
            //comparisons++;
            if (values[leftChild] > values[rightChild]) {
                maxIndex = leftChild;
                comparisons++;
            } else {
                maxIndex = rightChild;
            }
            if (values[maxIndex] > values[root]) {
                comparisons++;
                swap(values, maxIndex, root);
                reheapDown(values, maxIndex, bottom);
            }
        }
        return comparisons;
    }

    private void swap(int[] values, int item1, int item2) {
        int temp = values[item1];
        values[item1] = values[item2];
        values[item2] = temp;
    }
}
