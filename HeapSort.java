package cs2720.p4;

public class HeapSort implements SortStrategy {

    @Override
    public void sort(int[] array) {
        // heap sort implementation
        heapSort(array, array.length - 1);
    }

    private void heapSort(int[] values, int numValues) {
        int index;
        // Convert array values[0..numValues-1] into a heap
        // (AKA Build-Max-Heap)
        for (index = numValues / 2 - 1; index >= 0; index--) {
            reheapDown(values, index, numValues - 1);
        }
        // Sort the array.
        for (index = numValues - 1; index >= 1; index--) {
            swap(values, numValues, index);
            reheapDown(values, 0, index - 1);
        }
    }

    private void reheapDown(int[] values, int root, int bottom) {
        int maxIndex;
        int rightChild;
        int leftChild;
        leftChild = root * 2 + 1;
        rightChild = root * 2 + 2;
        // ReheapDown continued
        maxIndex = -1;
        if (leftChild <= bottom) {
            if (values[leftChild] > values[rightChild]) {
                maxIndex = leftChild;
            } else {
                maxIndex = rightChild;
            }
            if (values[maxIndex] > values[root]) {
                swap(values, maxIndex, root);
                reheapDown(values, maxIndex, bottom);
            }
        }
    }

    private void swap(int[] values, int item1, int item2) {
        int temp = values[item1];
        values[item1] = values[item2];
        values[item2] = temp;
    }
}
