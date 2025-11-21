import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Iterative implementation of QuickSort using an explicit stack.
 * Uses the last element as the pivot for partitioning.
 */
public class QuickSortIterative implements SortStrategy {

	private long comparisons = 0;

	/**
	 * Sorts the provided array in-place using an iterative quicksort algorithm.
	 * This method resets the internal comparison counter before sorting.
	 *
	 * @param array the array to sort; if null or length &lt;= 1 the method returns immediately
	 */
	@Override
	public void sort(int[] array) {
		comparisons = 0;
		if (array == null || array.length <= 1) {
			return;
		}

		Deque<int[]> stack = new ArrayDeque<>();
		stack.push(new int[] {0, array.length - 1});

		while (!stack.isEmpty()) {
			int[] range = stack.pop();
			int first = range[0];
			int last = range[1];
			if (first < last) {
				int pivotIndex = partition(array, first, last);
				if (pivotIndex + 1 < last) {
					stack.push(new int[] {pivotIndex + 1, last});
				}
				if (first < pivotIndex - 1) {
					stack.push(new int[] {first, pivotIndex - 1});
				}
			}
		}
	}

	/**
	 * Returns the number of element comparisons performed during the last sort.
	 *
	 * @return the comparison count
	 */
	@Override
	public long getComparisons() {
		return comparisons;
	}

	/**
	 * Partitions the subarray arr[first..last] using the last element as pivot.
	 * Increments the comparison counter once per element comparison.
	 *
	 * @param arr the array containing the subarray to partition
	 * @param first index of the first element in the subarray
	 * @param last index of the last element in the subarray (pivot)
	 * @return the final pivot index
	 */
	private int partition(int[] arr, int first, int last) {
		int pivot = arr[last];
		int i = first - 1;
		for (int j = first; j < last; j++) {
			comparisons++;
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, last);
		return i + 1;
	}

	/**
	 * Swaps two elements in the given array.
	 *
	 * @param values the array containing elements to swap
	 * @param a index of the first element
	 * @param b index of the second element
	 */
	private void swap(int[] values, int a, int b) {
		int tmp = values[a];
		values[a] = values[b];
		values[b] = tmp;
	}
}
