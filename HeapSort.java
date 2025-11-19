
public class HeapSort implements SortStrategy {

    /**
     * Sort the given array using heap sort.
     *
     * @param array the array to sort
     */
    @Override
    public void sort(int[] array) {
        heapSort(array, array.length - 1);
    }

    /**
     * Perform the heap sort algorithm on the given range.
     *
     * @param values the array containing values to sort
     * @param numValues the number of values (usually array.length - 1)
     */
    private void heapSort(int[] values, int numValues) {
        int index;
        for (index = numValues / 2 - 1; index >= 0; index--) {
            reheapDown(values, index, numValues - 1);
        }
        for (index = numValues - 1; index >= 1; index--) {
            swap(values, numValues - 1, index);
            reheapDown(values, 0, index - 1);
        }
    }

    /**
     * Restore heap property by moving the value at root down the heap until
     * the subtree rooted at root satisfies the max-heap property up to bottom.
     *
     * @param values the heap array
     * @param root the root index to reheap down from
     * @param bottom the last valid index in the heap
     */
    private void reheapDown(int[] values, int root, int bottom) {
        int maxIndex;
        int rightChild;
        int leftChild;
        leftChild = root * 2 + 1;
        rightChild = root * 2 + 2;
        maxIndex = -1;
        if (leftChild <= bottom) {
            if (rightChild <= bottom && values[leftChild] > values[rightChild]) {
                maxIndex = leftChild;
            } else if (rightChild <= bottom) {
                maxIndex = rightChild;
            } else {
                maxIndex = leftChild;
            }
            if (values[maxIndex] > values[root]) {
                swap(values, maxIndex, root);
                reheapDown(values, maxIndex, bottom);
            }
        }
    }

    /**
     * Swap two elements in the array.
     *
     * @param values the array
     * @param item1 index of first item
     * @param item2 index of second item
     */
    private void swap(int[] values, int item1, int item2) {
        int temp = values[item1];
        values[item1] = values[item2];
        values[item2] = temp;
    }
}
