import java.util.Scanner;

/**
 * Driver to run sorting algorithms on arrays of a specified size and report
 * comparisons statistics across multiple trials.
 */
public class SortSizeDriver {
    public static int[] values;
    public static SortStrategy strategy;

    /**
     * Prompts the user for algorithm and array size, runs multiple trials,
     * and prints per-trial comparisons and the average.
     */
    public static void main(String[] args) {
        System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-last (q)");
        System.out.println("quick-sort-rand (r)");

        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter the algorithm: ");
            char choice = input.nextLine().trim().toLowerCase().charAt(0);

            System.out.print("Enter size of array to sort: ");
            int size = input.nextInt();

            runTrials(choice, size);
        } finally {
            input.close();
        }

    }

    private static void runTrials(char choice, int size) {
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
        } else if (choice == 'i') {
            type = "#Quick-sort-iterative";
        } else {
            System.err.println("Invalid algorithm choice: " + choice);
            return;
        }

        long[] comparisonsResults = new long[30];
        for (int trial = 0; trial < 30; trial++) {
            values = new int[size];
            for (int i = 0; i < size; i++) {
                values[i] = (int) (Math.random() * 10000);
            }
            switch (choice) {
                case 's': sCalled(); break;
                case 'm': mCalled(); break;
                case 'h': hCalled(); break;
                case 'q': qCalled(); break;
                case 'r': rCalled(); break;
                case 'i': iCalled(); break;
            }
            // Print the entire sorted array for this trial before printing comparisons
            for (int i = 0; i < values.length; i++) {
                System.out.print(values[i] + " ");
            }
            System.out.println();

            comparisonsResults[trial] = strategy.getComparisons();
        }

        System.out.println("================================");
        System.out.println("Algorithm: " + type);
        System.out.println("Array size: " + size);
        long sum = 0;
        for (int trial = 0; trial < 30; trial++) {
            System.out.println(comparisonsResults[trial]);
            sum += comparisonsResults[trial];
        }
        double avg = sum / 30.0;
        System.out.println("Average comparisons: " + avg);
        System.out.println("================================");
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

    private static void iCalled() {
        strategy = new QuickSortIterative();
        strategy.sort(values);
    }
}
