package lw06.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        String line = read.nextLine();
        String[] values = line.split(" ");
        int target = read.nextInt();

        BinarySearchTree bst = new BinarySearchTree();
        
        for (String v : values) {
            int data = Integer.parseInt(v);
            bst.insert(data);
        }

        System.out.print("Preorder: ");
        bst.preOrder();

        System.out.print("Inorder: ");
        bst.inOrder();

        System.out.print("Postorder: ");
        bst.postOrder();

        System.out.println("Search " + target + ": " + bst.search(target));
        System.out.println("Nodes: " + bst.countNodes());
        System.out.println("Leaves: " + bst.countLeaves());

        read.close();
    }
}