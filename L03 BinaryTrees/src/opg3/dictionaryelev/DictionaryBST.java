package opg3.dictionaryelev;

import java.util.List;

public class DictionaryBST<K extends Comparable<K>, V> implements
        Dictionary<K, V> {

    private Node root;

    public DictionaryBST() {
        root = null;
    }

    @Override
    public V get(K key) {
        Node node = find(key);
        return (node == null) ? null : node.value;
    }

    private Node find(K key) {
        Node current = root;
        boolean found = false;
        while (!found && current != null) {
            int d = current.key.compareTo(key);
            if (d == 0) {
                found = true;
            } else if (d < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (found) {
            return current;
        } else {
            return null;
        }

    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public V put(K key, V value) {
        if (root == null) {
            root = new Node(key, value);
            return null;
        } else {
            return put(root, key, value);
        }
    }

    private V put(Node node, K key, V value) {
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            if (node.left == null) {
                node.left = new Node(key, value);
                return null;
            } else {
                return put(node.left, key, value);
            }
        } else if (cmp > 0) {
            if (node.right == null) {
                node.right = new Node(key, value);
                return null;
            } else {
                return put(node.right, key, value);
            }
        } else {
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }
    }

    @Override
    public V remove(K key) {
        //TODO
        return null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }

    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
