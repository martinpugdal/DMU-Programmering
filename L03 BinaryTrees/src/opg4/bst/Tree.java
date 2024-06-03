package opg4.bst;

import java.util.ArrayList;

public interface Tree<E> {
    /**
     * Return true if the element is in the tree
     */
    public boolean search(E e);

    /**
     * Insert element e into the binary tree
     * Return true if the element is inserted successfully
     */
    public boolean insert(E e);

    /**
     * Delete the specified element from the tree
     * Return true if the element is deleted successfully
     */
    public boolean delete(E e);

    /**
     * Get the number of elements in the tree
     */
    public int getSize();

    /**
     * Inorder traversal from the root
     */
    public default void inorder() {
    }

    /**
     * Postorder traversal from the root
     */
    public default void postorder() {
    }

    /**
     * Preorder traversal from the root
     */
    public default void preorder() {
    }

    // @Override /** Return true if the tree is empty */
    public default boolean isEmpty() {
        return this.getSize() == 0;
    }


    //-------------------------------------------------------------
    public int height();

    public int sum();

    public BST.TreeNode<E> findMin();

    public BST.TreeNode<E> findMax();

    public E removeMin();

    public E removeMax();

    public ArrayList<E> greaterThan(E element);

    public int numberOfLeaves();

    public int heightNodeCount(int targetHeight);
}