import java.util.Random;

public class QuickSort implements SortStrategy {
    @Override
    public void sort(int[] array) {
        // quick sort implementation
        quickSortLast(array, 0, array.length - 1);
    }

    private final Random rand = new Random();

    private void quickSortLast(int[] values, int first, int last) {
        if (first < last) // general case
        {
            int pivot = partition(values, first, last);
            quickSortLast(values, first, pivot - 1);
            quickSortLast(values, pivot + 1, last);
        }
    }

    private int partition(int[] values, int first, int last) {
        int x = values[last];
        int i = first - 1;
        for (int j = first; j < last - 1; j++) {
            if (values[j] <= x) {
                i++;
                swap(values, i, j);
            }
        }
        swap(values, i + 1, last);
        return i + 1;
    }

    public void quickSortRand(int[] arr, int first, int last) {
        if (first < last) {
            int pivotIndex = randomPartition(arr, first, last);
            quickSortRand(arr, first, pivotIndex - 1);
            quickSortRand(arr, pivotIndex + 1, last);
        }
    }

    private int randomPartition(int[] arr, int first, int last) {
        int randomIndex = first + rand.nextInt(last - first + 1);
        // swap random pivot into last
        swap(arr, randomIndex, last);
        return partition(arr, first, last);
    }

    private void swap(int[] values, int item1, int item2) {
        int temp = values[item1];
        values[item1] = values[item2];
        values[item2] = temp;
    }    
}
