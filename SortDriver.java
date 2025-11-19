
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

        // 3. Decide strategy (placeholder — real sorting happens elsewhere)
        String algoName = switch (choice) {
            case 's' ->
                "Selection-sort";
            case 'm' ->
                "Merge-sort";
            case 'h' ->
                "Heap-sort";
            case 'q' ->
                "Quick-sort-last";
            case 'r' ->
                "Quick-sort-rand";
            default ->
                "Unknown";
        };

        // 4. Read filename from command line
        String filename = args[0];
        File file = new File(filename);

        // 5. Read integers from file into ArrayList
        Scanner fileScanner = new Scanner(file);
        List<Integer> list = new ArrayList<>();
        while (fileScanner.hasNextInt()) {
            list.add(fileScanner.nextInt());
        }
        fileScanner.close();
        // 6. Convert ArrayList to regular array
        int[] values = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            values[i] = list.get(i);
        }
        System.out.println("Nums loaded into array successfully");
        // 7. SORT!
        SortStrategy strategy = new HeapSort();
        strategy.sort(values);
        // 8. Print sorted values
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i] + " ");
        }
        int check = values[values.length - 1];
        if (values[0] == 0 && check == 9999) {
            System.out.println("Nums have been sorted!");
        } else {
            System.out.println("Needs some work");
        }
        
    }
}
