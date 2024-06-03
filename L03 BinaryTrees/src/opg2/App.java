package opg2;

import opg2.bst.BST;

import java.util.List;

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


        System.out.print("Preorder: ");
        bst.preorder();
        System.out.println();


        System.out.print("Inorder: ");
        bst.inorder();
        System.out.println();


        System.out.print("Postorder: ");
        bst.postorder();

        System.out.println();

        System.out.println("Is leaf: " + bst.getRoot().isLeaf());
        System.out.println("Is internal: " + bst.getRoot().isInternal());

        System.out.println("Height: " + bst.height());

        System.out.println("Size: " + bst.sum());

        System.out.println("Min: " + bst.findMin().getElement());
        System.out.println("Max: " + bst.findMax().getElement());

        bst.removeMax();
        System.out.print("Inorder: ");
        bst.inorder();
        System.out.println();

        bst.removeMin();
        System.out.print("Inorder: ");
        bst.inorder();
        System.out.println();

        List list = bst.greaterThan(22);
        System.out.println("Greater than 22: " + list);
    }
}