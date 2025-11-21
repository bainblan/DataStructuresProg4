import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Command-line driver that reads integers from a file, runs a selected sorting
 * algorithm, and prints the sorted result and comparison count.
 */
public class SortDriver {

    public static int[] values;
    public static SortStrategy strategy;

    /**
     * Main entry point. Prompts the user for algorithm and input file if not
     * provided on the command line, runs the sort, and prints results.
     *
     * @param args optional command-line arguments (first argument may be filename)
     * @throws FileNotFoundException if the provided file cannot be found
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-last (q)");
        System.out.println("quick-sort-rand (r) quick-sort-iterative (i)");

        Scanner input = new Scanner(System.in);
        try {
            char choice = promptAlgorithm(input);
            String filename = getFilename(args, input);
            File file = new File(filename);
            if (!file.exists()) {
                System.err.println("File not found: " + filename);
                return;
            }

            values = readValuesFromFile(file);
            String type = selectAndRun(choice);

            for (int i = 0; i < values.length; i++) {
                System.out.print(values[i] + " ");
            }
            int check = values[values.length - 1];
            if (values[0] == 0 && check == 9999) {
                System.out.println(type + " comparisons: " + strategy.getComparisons());
            } else {
                System.out.println("Needs some work");
            }
        } finally {
            input.close();
        }
    }

    private static char promptAlgorithm(Scanner input) {
        System.out.print("Enter the algorithm: ");
        return input.nextLine().trim().toLowerCase().charAt(0);
    }

    private static String getFilename(String[] args, Scanner input) {
        if (args != null && args.length >= 1) {
            return args[0];
        }
        System.out.print("Enter filename (e.g., random.txt): ");
        return input.nextLine().trim();
    }

    private static int[] readValuesFromFile(File file) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(file);
        List<Integer> list = new ArrayList<>();
        while (fileScanner.hasNextInt()) {
            list.add(fileScanner.nextInt());
        }
        fileScanner.close();
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private static String selectAndRun(char choice) {
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
            type = "#quick-sort-last";
        } else if (choice == 'i') {
            iCalled();
            type = "#quick-sort-iterative";
        } else {
            rCalled();
            type = "#quick-sort-rand";
        }
        return type;
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