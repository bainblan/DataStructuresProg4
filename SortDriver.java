//package cs2720.p4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortDriver {

    public static int[] values;
    public static SortStrategy strategy;
    public static void main(String[] args) throws FileNotFoundException {

        // 1. Print menu of algorithm options
        System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-last (q)");
        System.out.println("quick-sort-rand (r)");

        // 2. Get algorithm letter from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the algorithm: ");
        char choice = input.nextLine().trim().toLowerCase().charAt(0);

        // 3. Read filename from command line
        String filename = args[0];
        File file = new File(filename);

        // 4. Read integers from file into ArrayList
        Scanner fileScanner = new Scanner(file);
        List<Integer> list = new ArrayList<>();
        while (fileScanner.hasNextInt()) {
            list.add(fileScanner.nextInt());
        }
        fileScanner.close();

        // 5. Convert ArrayList to regular array
        values = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            values[i] = list.get(i);
        }
        System.out.println("Nums loaded into array successfully");
        
        // 6. SORT!
        if (choice == 's') {
            sCalled();
        } else if (choice == 'm') {
            mCalled();
        } else if (choice == 'h') {
            hCalled();
        } else if (choice == 'q') {
            qCalled();
        } else {
            rCalled();
        }

        // 7. Print sorted values
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i] + " ");
        }
        int check = values[values.length - 1];
        if (values[0] == 0 && check == 9999) {
            System.out.println("Nums have been sorted!");
            System.out.println("Number of comparisons = " + strategy.getComparisons());
        } else {
            System.out.println("Needs some work");
        }
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