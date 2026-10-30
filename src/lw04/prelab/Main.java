package lw04.prelab;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int size = sc.nextInt();
        int[] values = new int[size];

        for (int i = 0; i < size; i++) {
            values[i] = sc.nextInt();
        }

        int total = sc.nextInt();
        int[] target = new int[total];

        for (int i = 0; i < total; i++) {
            target[i] = sc.nextInt();
        }

        int mid = (size + 1) / 2;
        for (int i = 1; i < mid; i++) {
            int key = values[i];
            int j = i - 1;
            while (j >= 0 && key > values[j]) {
                values[j+1] = values[j];
                j--;
            }
            values[j+1] = key;
        }

        for (int x : values) {
            System.out.print(x + " ");
        }
        System.out.println();

        for (int j = 0; j < target.length; j++) {
            boolean found = false;
            int index = 0;
            for (int i = 0; i < values.length; i++) {
                if (values[i] == target[j]) {
                    found = true;
                    index = i;
                    break;
                } 
            }
            
            if (found) {
                System.out.println(target[j] + ": FOUND at index " + index);
            } else {
                System.out.println(target[j] + ": NOT FOUND");
            }
        } 
    }
}

