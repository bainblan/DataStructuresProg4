import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortDriver {

    public static void main(String[] args) throws FileNotFoundException {

        // 4. Print menu of algorithm options
        System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-last (q)");
        System.out.println("quick-sort-rand (r)");

        // 4. Get algorithm letter from the user
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

        // 4. Put numbers in array
        int[] array = new int[10000];
        try {
            int index = 0;
            while (fileScanner.hasNextInt()) {
                array[index++] = fileScanner.nextInt();
            }
            fileScanner.close();
            System.out.println("Nums loaded into array successfully");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds");
        }

    }
}
