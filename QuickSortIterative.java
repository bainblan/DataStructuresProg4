//package cs2720.p4;

import java.util.ArrayDeque;
import java.util.Deque;

public class QuickSortIterative implements SortStrategy {

	private long comparisons = 0;

	@Override
	public void sort(int[] array) {
		comparisons = 0;
		if (array == null || array.length <= 1) {
			return;
		}

		// Use a stack to store ranges (first, last)
		Deque<int[]> stack = new ArrayDeque<>();
		stack.push(new int[] {0, array.length - 1});

		while (!stack.isEmpty()) {
			int[] range = stack.pop();
			int first = range[0];
			int last = range[1];
			if (first < last) {
				int pivotIndex = partition(array, first, last);
				// push right and left ranges
				if (pivotIndex + 1 < last) {
					stack.push(new int[] {pivotIndex + 1, last});
				}
				if (first < pivotIndex - 1) {
					stack.push(new int[] {first, pivotIndex - 1});
				}
			}
		}
	}

	@Override
	public long getComparisons() {
		return comparisons;
	}

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

	private void swap(int[] values, int a, int b) {
		int tmp = values[a];
		values[a] = values[b];
		values[b] = tmp;
	}
}
