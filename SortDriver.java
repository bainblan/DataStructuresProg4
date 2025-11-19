import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SortDriver {

    public static void main(String[] args) throws FileNotFoundException {

        // 1. Print menu of algorithm options
        System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-last (q)");
        System.out.println("quick-sort-rand (r)");

        // 2. Get algorithm letter from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the algorithm: ");
        char choice = input.nextLine().trim().toLowerCase().charAt(0);

        // 5. Decide strategy (placeholder — real sorting happens elsewhere)
        String algoName = switch (choice) {
            case 's' -> "Selection-sort";
            case 'm' -> "Merge-sort";
            case 'h' -> "Heap-sort";
            case 'q' -> "Quick-sort-last";
            case 'r' -> "Quick-sort-rand";
            default -> "Unknown";
        };

        // 1. Read filename from command line
        String filename = args[0];
        File file = new File(filename);

        // 2. Read integers from file
        Scanner fileScanner = new Scanner(file);
        List<Integer> list = new ArrayList<>();
        while (fileScanner.hasNextInt()) {
            list.add(fileScanner.nextInt());
        }
        fileScanner.close();
        int[] values = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            values[i] = list.get(i);
        }
        System.out.println("Nums loaded into array successfully");
        SortStrategy strategy = new MergeSort();
        strategy.sort(values);
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i] + " ");
        }
        System.out.println("Nums have been sorted!");
    }
}
