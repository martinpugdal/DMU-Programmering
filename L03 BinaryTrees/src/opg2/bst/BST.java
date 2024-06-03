package opg2.bst;

import java.util.ArrayList;

public class BST<E> implements Tree<E> {
    protected TreeNode<E> root;
    protected int size = 0;
    protected java.util.Comparator<E> c;

    /**
     * Create a default BST with a natural order comparator
     */
    public BST() {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
    }

    /**
     * Create a BST with a specified comparator
     */
    public BST(java.util.Comparator<E> c) {
        this.c = c;
    }

    /**
     * Create a binary tree from an array of objects
     */
    public BST(E[] objects) {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    /** Returns true if the element is in the tree */ public boolean search(E e) {
        TreeNode<E> current = root; // Start from the root

        boolean found = false;
        while (current != null && !found) {
            if (c.compare(e, current.element) < 0) {
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                current = current.right;
            } else // element matches current.element
                found = true; // Element is found
        }

        return found;
    }

    @Override
    /** Insert element e into the binary tree
     * Return true if the element is inserted successfully */ public boolean insert(E e) {
        boolean inserted = true;
        if (root == null) root = createNewNode(e); // Create a new root
        else {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null && inserted) if (c.compare(e, current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                parent = current;
                current = current.right;
            } else inserted = false; // Duplicate node not inserted

            // Create the new node and attach it to the parent node
            if (c.compare(e, parent.element) < 0) parent.left = createNewNode(e);
            else parent.right = createNewNode(e);
        }

        size++;
        return inserted; // Element inserted successfully
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    /** Inorder traversal from the root */ public void inorder() {
        TreeNode<E> current = root;
        TreeNode<E> pre;

        while (current != null) {
            if (current.left == null) {
                System.out.print(current.element + " ");
                current = current.right;
            } else {

                // Find the inorder predecessor of current
                pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }

                // Make current as the right child of its inorder predecessor
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    System.out.print(current.element + " ");
                    current = current.right;
                }
            }
        }
    }


    @Override
    /** Postorder traversal from the root */ public void postorder() {
        TreeNode<E> current = root;
        TreeNode<E> pre;

        while (current != null) {
            if (current.right == null) {
                System.out.print(current.element + " ");
                current = current.left;
            } else {
                pre = current.right;
                while (pre.left != null && pre.left != current) {
                    pre = pre.left;
                }

                if (pre.left == null) {
                    pre.left = current;
                    current = current.right;
                } else {
                    pre.left = null;
                    System.out.print(current.element + " ");
                    current = current.left;
                }
            }
        }
    }


    @Override
    /** Preorder traversal from the root */ public void preorder() {
        TreeNode<E> current = root;
        TreeNode<E> pre;

        while (current != null) {
            if (current.left == null) {
                System.out.print(current.element + " ");
                current = current.right;
            } else {
                pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    System.out.print(current.element + " ");
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    current = current.right;
                }
            }
        }
    }

    @Override
    public int height() {
        return height(root, 0);
    }

    private int height(BST.TreeNode<E> node, int height) {
        if (node == null) {
            return height;
        } else {
            return Math.max(height(node.left, height + 1), height(node.right, height + 1));
        }
    }

    @Override
    public int sum() {
        return sum(root);
    }

    private int sum(BST.TreeNode<E> node) {
        if (node == null) {
            return 0;
        } else {
            return (int) node.element + sum(node.left) + sum(node.right);
        }
    }

    @Override
    public TreeNode<E> findMin() {
        for (TreeNode<E> current = root; current != null; current = current.left) {
            if (current.left == null) {
                return current;
            }
        }
        return null;
    }

    @Override
    public TreeNode<E> findMax() {
        for (TreeNode<E> current = root; current != null; current = current.right) {
            if (current.right == null) {
                return current;
            }
        }
        return null;
    }

    @Override
    public E removeMin() {
        if (root == null) {
            return null;
        }

        TreeNode<E> parent = null;
        TreeNode<E> current = root;

        while (current.left != null) {
            parent = current;
            current = current.left;
        }

        if (parent == null) { // The minimum is the root
            root = root.right;
        } else {
            parent.left = current.right;
        }

        size--;
        return current.element;
    }

    @Override
    public E removeMax() {
        if (root == null) {
            return null;
        }

        TreeNode<E> parent = null;
        TreeNode<E> current = root;

        while (current.right != null) {
            parent = current;
            current = current.right;
        }

        if (parent == null) { // The maximum is the root
            root = root.left;
        } else {
            parent.right = current.left;
        }

        size--;
        return current.element;
    }

    @Override
    public ArrayList<E> greaterThan(E element) {
        ArrayList<E> result = new ArrayList<>();
        greaterThan(root, element, result);
        return result;
    }

    private void greaterThan(TreeNode<E> node, E element, ArrayList<E> result) {
        if (node == null) {
            return;
        }

        if (c.compare(node.element, element) > 0) {
            result.add(node.element);
            greaterThan(node.left, element, result);
        }
        greaterThan(node.right, element, result);
    }

    /**
     * This inner class is static, because it does not access
     * any instance members defined in its outer class
     */
    public static class TreeNode<E> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }

        public E getElement() {
            return element;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean isInternal() {
            return !isLeaf();
        }
    }

    @Override
    /** Get the number of nodes in the tree */ public int getSize() {
        return size;
    }

    /**
     * Returns the root of the tree
     */
    public TreeNode<E> getRoot() {
        return root;
    }


    @Override
    /** Delete an element from the binary tree.
     * Return true if the element is deleted successfully
     * Return false if the element is not in the tree */ public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        boolean found = false;
        while (current != null && !found) {
            if (c.compare(e, current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                parent = current;
                current = current.right;
            } else found = true; // Element is in the tree pointed at by current
        }

        if (found) {
            // Case 1: current has no left child
            if (current.left == null) {
                // Connect the parent with the right child of the current node
                if (parent == null) {
                    root = current.right;
                } else {
                    if (c.compare(e, parent.element) < 0) parent.left = current.right;
                    else parent.right = current.right;
                }
            } else {
                // Case 2: The current node has a left child
                // Locate the rightmost node in the left subtree of
                // the current node and also its parent
                TreeNode<E> parentOfRightMost = current;
                TreeNode<E> rightMost = current.left;

                while (rightMost.right != null) {
                    parentOfRightMost = rightMost;
                    rightMost = rightMost.right; // Keep going to the right
                }

                // Replace the element in current by the element in rightMost
                current.element = rightMost.element;

                // Eliminate rightmost node
                if (parentOfRightMost.right == rightMost) parentOfRightMost.right = rightMost.left;
                else
                    // Special case: parentOfRightMost == current
                    parentOfRightMost.left = rightMost.left;
            }
            size--; // Reduce the size of the tree
        }
        return found; // Element deleted successfully
    }
}
