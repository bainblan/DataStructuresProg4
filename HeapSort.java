
public class HeapSort implements SortStrategy {

    /**
     * Sort the given array using heap sort.
     *
     * @param array the array to sort
     */
    @Override
    public void sort(int[] array) {
        heapSort(array, array.length);
    }

    /**
     * Perform the heap sort algorithm on the given range.
     *
     * @param values    the array containing values to sort
     * @param numValues the number of values (usually array.length - 1)
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
     * Restore heap property by moving the value at root down the heap until
     * the subtree rooted at root satisfies the max-heap property up to bottom.
     *
     * @param values the heap array
     * @param root   the root index to reheap down from
     * @param bottom the last valid index in the heap
     */
    private void reheapDown(int[] values, int root, int bottom) {
        int leftChild = root * 2 + 1;
        int rightChild = root * 2 + 2;
        if (leftChild > bottom)
            return;
        int maxChild = leftChild;

        // If right child exists and is larger, choose it
        if (rightChild <= bottom && values[rightChild] > values[leftChild]) {
            maxChild = rightChild;
        }
        // If child is greater than root, swap and continue
        if (values[maxChild] > values[root]) {
            swap(values, maxChild, root);
            reheapDown(values, maxChild, bottom);
        }
    }

    /**
     * Swap two elements in the array.
     *
     * @param values the array
     * @param item1  index of first item
     * @param item2  index of second item
     */
    private void swap(int[] values, int item1, int item2) {
        int temp = values[item1];
        values[item1] = values[item2];
        values[item2] = temp;
    }
}
