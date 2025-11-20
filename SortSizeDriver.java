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

        // 4. Run three trials with new random arrays each time
        String type;
        if (choice == 's') {
            type = "#Selection-sort";
        } else if (choice == 'm') {
            type = "#Merge-sort";
        } else if (choice == 'h') {
            type = "#Heap-sort";
        } else if (choice == 'q') {
            type = "#Quick-sort-last";
        } else if (choice == 'r') {
            type = "#Quick-sort-rand";
        } else {
            System.err.println("Invalid algorithm choice: " + choice);
            input.close();
            return;
        }


        long[] comparisonsResults = new long[3];
        int[] initialArray = new int[size];
        // Generate the initial array ONCE and print it
        for (int i = 0; i < size; i++) {
            initialArray[i] = (int) (Math.random() * 10000);
        }
        System.out.println("Initial unsorted array:");
        for (int i = 0; i < size; i++) {
            System.out.print(initialArray[i] + " ");
        }
        System.out.println();

        // For each trial, copy the initial array and sort
        for (int trial = 0; trial < 3; trial++) {
            values = new int[size];
            System.arraycopy(initialArray, 0, values, 0, size);
            switch (choice) {
                case 's': sCalled(); break;
                case 'm': mCalled(); break;
                case 'h': hCalled(); break;
                case 'q': qCalled(); break;
                case 'r': rCalled(); break;
            }
            comparisonsResults[trial] = strategy.getComparisons();
        }

        // Print results
        System.out.println("================================");
        System.out.println("Algorithm: " + type);
        System.out.println("Array size: " + size);
        for (int trial = 0; trial < 3; trial++) {
            System.out.println("Trial " + (trial+1) + " comparisons: " + comparisonsResults[trial]);
        }
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
