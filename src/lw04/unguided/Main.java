package lw04.unguided;
import java.util.Scanner;

public class Main {
    static void bubbleSort(int[] arr, int fromPass, int toPass) {
        for (int i = fromPass; i < toPass && i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    static void binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        int steps = 0;

        while (low <= high) {
            int mid = (low + high)/2;
            steps++;

            if (arr[mid] == target) {
                System.out.println(target + ": FOUND at index " + mid + " (steps: " + steps + ")");
                return;
            } else if (arr[mid] < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(target + ": NOT FOUND (steps: " + steps + ")");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("parcels.txt"));

        int n = sc.nextInt();
        int[] parcels = new int[n];

        for (int i = 0; i < n; i++) {
            parcels[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] target = new int[m];
        
        for (int i = 0; i < m; i++) {
            target[i] = sc.nextInt();
        }

        bubbleSort(parcels, 0, 2);

        int[] twoSorted = new int[n];
        for (int i = 0; i < n; i++) {
            twoSorted[i] = parcels[i];
        }

        bubbleSort(parcels, 2, n-1);

        System.out.println("=== After 2 Passes ===");
        for (int i = 0; i < n; i++) {
            System.out.print(twoSorted[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        System.out.println();
        System.out.println("=== Fully Sorted ===");
        for (int i = 0; i < n; i++) {
            System.out.print(parcels[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        
        System.out.println();
        System.out.println("=== Search Results ===");
        for (int i = 0; i < m; i++) {
            binarySearch(parcels, target[i]);
        }
    }

}
