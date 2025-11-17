public class QuickSort implements SortStrategy {
    @Override
    public void sort(int[] array) {
        // quick sort implementation
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] values, int first, int last) {
        if (first < last) // general case
        {
            int pivot = partition(values, first, last);
            quickSort(values, first, pivot - 1);
            quickSort(values, pivot + 1, last);
        }
    }

    private int partition(int[] values, int first, int last) {
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
        int temp = values[i+1];
        values[i+1] = values[last]; 
        values[last] = temp;
        return i++;
    }
}
