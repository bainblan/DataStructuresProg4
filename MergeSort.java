public class MergeSort implements SortStrategy {

    private long comparisons = 0;

    public long getComparisons() {
        return comparisons;
    }

    @Override
    public void sort(int[] array) {
        // merge sort implementation
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;   // base case
        }
        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);       // sort left half
        mergeSort(arr, mid + 1, right);  // sort right half
        merge(arr, left, mid, right);    // merge halves
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;      // left pointer
        int j = mid + 1;   // right pointer
        int k = 0;         // temp index

        // merge while both halves have elements
        while (i <= mid && j <= right) {
            comparisons++;
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // copy remaining left side
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // copy remaining right side
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // copy merged array back into original
        for (int t = 0; t < temp.length; t++) {
            arr[left + t] = temp[t];
        }
    }
}
