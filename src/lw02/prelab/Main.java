package lw02.prelab;

import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("transactions.txt"));
        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customer = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failedTransactions = new Stack<>();

        while (sc.hasNext()) {
            String name = sc.next();
            String type = sc.next();
            String amount = sc.next();

            String[] data = {name, type, amount};
            transactions.add(data);

             boolean customerExist = false;
             for (String[] cust : customer) {
                if (cust[0].equals(name)) {
                    customerExist = true;
                    break;
            }
        }

            if (!customerExist) {
                String [] newCust = {name, "0"};
                customer.add(newCust);
            }
        }
        sc.close();

        for (String[] custQueue : transactions) {
            queue.add(custQueue);
        }

        while (!queue.isEmpty()) {
            String[] custQueue = queue.poll();

            String name = custQueue[0];
            String type = custQueue[1];
            int amount = Integer.parseInt(custQueue[2]);

            for (String[] cust : customer) {
                if (cust[0].equals(name)) {
                    int currentBalance = Integer.parseInt(cust[1]);

                    if (type.equals("DEPOSIT")) {
                        currentBalance += amount;
                        cust[1] = String.valueOf(currentBalance);
                    } else if (type.equals("WITHDRAW")) {
                        if (currentBalance >= amount) {
                            currentBalance -= amount;
                            cust[1] = String.valueOf(currentBalance);
                        } else {
                            failedTransactions.push(custQueue);
                        }
                    }
                    break;
                }
            }
        }

            System.out.println("=== Final Balances ===");
            for (String[] cust : customer) {
                System.out.println(cust[0] + " : " + cust[1]);
            }

            System.out.println();
            System.out.println("=== Failed Transactions ===");
            while (!failedTransactions.isEmpty()) {
                String [] failed = failedTransactions.pop();
                System.out.println(failed[0] + " " + failed[1] + " " + failed[2]);

            }
        }
    }