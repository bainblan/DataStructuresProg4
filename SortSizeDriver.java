import java.util.Scanner;

public class SortSizeDriver {
    public static int[] values;
    public static SortStrategy strategy;

    public static void main(String[] args) {
        // 1. Print menu of algorithm options
        System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-last (q)");
        System.out.println("quick-sort-rand (r)");

        // 2. Get algorithm letter from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the algorithm: ");
        char choice = input.nextLine().trim().toLowerCase().charAt(0);

        // 3. Read size from user
        System.out.print("Enter size of array to sort: ");
        int size = input.nextInt();

        // 4. Generate array of given size with random integers
        values = new int[size];
        for (int i = 0; i < size; i++) {
            values[i] = (int) (Math.random() * 10000); // Random integers between 0 and 9999
        }

        // 5. SORT!
        String type;
        if (choice == 's') {
            sCalled();
            type = "#Selection-sort";
        } else if (choice == 'm') {
            mCalled();
            type = "#Merge-sort";
        } else if (choice == 'h') {
            hCalled();
            type = "#Heap-sort";
        } else if (choice == 'q') {
            qCalled();
            type = "#Quick-sort-last";
        } else if (choice == 'r') {
            rCalled();
            type = "#Quick-sort-rand";
        } else {
            System.err.println("Invalid algorithm choice: " + choice);
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();

        // 6. Print results
        System.out.println("================================");
        System.out.println("Algorithm: " + type);
        System.out.println("Array size: " + size);
        System.out.println("Comparisons: " + strategy.getComparisons());
        System.out.println("================================");

        input.close();

    }

    private static void sCalled() {
        strategy = new SelectionSort();
        strategy.sort(values);
    }

    private static void mCalled() {
        strategy = new MergeSort();
        strategy.sort(values);
    }

    private static void hCalled() {
        strategy = new HeapSort();
        strategy.sort(values);
    }

    private static void qCalled() {
        strategy = new QuickSortLast();
        strategy.sort(values);
    }

    private static void rCalled() {
        strategy = new QuickSortRandom();
        strategy.sort(values);
    }
}
