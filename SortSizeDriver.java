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
        } else if (choice == 'i') {
            type = "#Quick-sort-iterative";
        } else {
            System.err.println("Invalid algorithm choice: " + choice);
            input.close();
            return;
        }


        long[] comparisonsResults = new long[30];
        // For each trial, generate a new array, print it, and sort
        for (int trial = 0; trial < 30; trial++) {
            values = new int[size];
            for (int i = 0; i < size; i++) {
                values[i] = (int) (Math.random() * 10000);
            }
            // System.out.println("Initial unsorted array for trial " + (trial+1) + ":");
            // for (int i = 0; i < size; i++) {
            //     System.out.print(values[i] + " ");
            // }
            System.out.println();
            switch (choice) {
                case 's': sCalled(); break;
                case 'm': mCalled(); break;
                case 'h': hCalled(); break;
                case 'q': qCalled(); break;
                case 'r': rCalled(); break;
                case 'i': iCalled(); break;
            }
            comparisonsResults[trial] = strategy.getComparisons();
        }

        // Print results
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

    private static void iCalled() {
        strategy = new QuickSortIterative();
        strategy.sort(values);
    }
}
