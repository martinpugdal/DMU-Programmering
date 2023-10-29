package queue;

import java.util.NoSuchElementException;

/**
 * An implementation of a queue as a linked list.
 */
public class NodeQueue implements QueueI {

    private Node head;
    private Node tail;
    private int currentSize;

    @Override
    public void enqueue(Object element) {
        Node newNode = new Node(element);

        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        currentSize++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Object removed = head.data;
        head = head.next;
        currentSize--;
        if (isEmpty()) {
            tail = null;
        }

        return removed;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    class Node {

        public Object data;
        public Node next = null;

        public Node(Object data) {
            this.data = data;
        }
    }
}
