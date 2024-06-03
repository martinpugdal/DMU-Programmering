package opg4;

import opg4.bst.BST;

public class App {
    public static void main(String[] args) {

        BST bst = new BST<>();

        // Insert elements
        // root
        bst.insert(45);

        // siblings of root
        bst.insert(22);
        bst.insert(77);

        // children of 22, left tree
        bst.insert(11);
        bst.insert(30);
        bst.insert(15);
        bst.insert(25);

        // children of 77, right tree
        bst.insert(90);
        bst.insert(88);

        System.out.println("Number of leaves: " + bst.numberOfLeaves());
        System.out.println("Height of node: " + bst.heightNodeCount(1));
    }
}