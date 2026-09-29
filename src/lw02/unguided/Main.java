package lw02.unguided;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("orders.txt"));

        LinkedList<String[]> orders = new LinkedList<>();
        while(sc.hasNextLine()) {
            String name = sc.next();
            String sideDish = sc.next();
            String drink = sc.next();
            String table = sc.next();

            String[] data = {name, sideDish, drink, table};
            orders.add(data);
        }

        LinkedList<String[]> food = new LinkedList<>();
        String[] bakso = {"Bakso", "2"};
        String[] sate = {"Sate", "1"};
        String[] soto = {"Soto", "2"};
        food.add(bakso);
        food.add(sate);
        food.add(soto);

        LinkedList<String[]> drinks = new LinkedList<>();
        String[] esTeh = {"EsTeh", "4"};
        String[] esJeruk = {"EsJeruk", "2"};
        drinks.add(esTeh);
        drinks.add(esJeruk);

        Queue<String[]> process = new LinkedList<>(orders);
        LinkedList<String[]> success = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        while (!process.isEmpty()) {
            String[] data = process.poll();
            String name = data[0];
            String sideDish = data[1];
            String drink = data[2];
            String table = data[3];

            boolean foodAvail = true;
            boolean drinkAvail = true;

            if(!sideDish.equals("-")) {
                for (String[] s : food) {
                    if(s[0].equals(sideDish)) {
                        int currentFood = Integer.parseInt(s[1]);
                        if (currentFood == 0) {
                            foodAvail = false;
                        }
                    }
                }
            }

            if(!drink.equals("-")) {
                for (String[] s : drinks) {
                    if(s[0].equals(drink)) {
                        int currentDrink = Integer.parseInt(s[1]);
                        if (currentDrink == 0) {
                            drinkAvail = false;
                        }
                    }
                }
            }

            if(foodAvail && drinkAvail) {
                if(!sideDish.equals("-")) {
                    for (String[] s : food) {
                        if(s[0].equals(sideDish)) {
                            int currentFood = Integer.parseInt(s[1]);
                            currentFood -= 1;
                            s[1] = Integer.toString(currentFood);
                        }
                    }
                }

                if(!drink.equals("-")) {
                    for (String[] s : drinks) {
                        if(s[0].equals(drink)) {
                            int currentDrink = Integer.parseInt(s[1]);
                            currentDrink -= 1;
                            s[1] = Integer.toString(currentDrink);
                        }
                    }
                }

                success.add(data);
            } else {
                failed.push(data);
            }
        }

        
        System.out.println("=== Successfully Processed Orders ===");
        for (String[] s : success) {
            System.out.println(s[0] + " " + s[1] + " " + s[2] + " " + s[3]);
        }

        System.out.println();
        System.out.println("=== Remaining Food Stock ===");
        for (String[] f : food) {
            System.out.println(f[0] + " : " + f[1]);
        }

        System.out.println();
        System.out.println("=== Remaining Drink Stock ===");
        for (String[] d : drinks) {
            System.out.println(d[0] + " : " + d[1]);
        }

        System.out.println();
        System.out.println("=== Failed Orders ===");
        while(!failed.isEmpty()) {
            String[] f = failed.pop();
            System.out.println(f[0] + " " + f[1] + " " + f[2] + " " + f[3]);
        }

    
    }

}
    

