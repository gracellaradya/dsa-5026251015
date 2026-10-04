package lw03.prelab;

import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        List<String> playlist = new LinkedList<>();
        int total = 0;

        while(sc.hasNext()) {
            String command = sc.next();
            if (command.equals("ADD")) {
                String song = sc.nextLine().trim();
                playlist.add(song);
                total++;
            } else if (command.equals("INSERT")) {
                int index = sc.nextInt();
                String song = sc.nextLine().trim();
                playlist.add(index, song);
                total++;
            } else if (command.equals("REMOVE")) {
                String song = sc.nextLine().trim();
                playlist.remove(song);
                total--;
            }
        }

        System.out.println("=== Problem 1 ===");
        System.out.println("Total songs: " + total);
        int number = 1;
        for(String s : playlist) {
            System.out.println(number + ": " + s);
            number++;
        }

        Scanner scan = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Set <String> participants = new LinkedHashSet<>();
        int duplicate = 0;
        int unique = 0;

        while (scan.hasNext()) {
            String name = scan.next();
            if (participants.contains(name)) {
                duplicate++;
            } else {
                participants.add(name);
                unique++;
            }
        }

        System.out.println();
        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + unique);
        int nomor = 1;
        for (String c : participants) {
            System.out.println(nomor + ". " + c);
            nomor++;
        }
        System.out.println("Duplicate registrations: " + duplicate);

        Scanner s = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failed = 0;

        while (s.hasNext()) {
            String type = s.next();
            String product = s.next();
            int quantity = s.nextInt();

            if (type.equals("ADD")) {
                if (inventory.containsKey(product)) {
                    int currentStock = inventory.get(product);
                    inventory.put(product, currentStock + quantity);
                } else {
                    inventory.put(product, quantity);
                }
            } else {
                if (inventory.containsKey(product) && inventory.get(product) >= quantity) {
                    int currentStock = inventory.get(product);
                    inventory.put(product, currentStock - quantity);
                } else {
                    failed++;
                }
            }
        }

        System.out.println();
        System.out.println("=== Problem 3 ===");
        for (String i : inventory.keySet()) {
            System.out.println(i + ": " + inventory.get(i));
        }
        System.out.println("Failed sales: " + failed);


    }
}
