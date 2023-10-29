package deque;

import java.util.NoSuchElementException;

public class CircularArrayDeque implements DequeI {
    private Object[] elements;
    private int currentSize;
    private int head;
    private int tail;


    public CircularArrayDeque(int size) {
        elements = new Object[size];
        currentSize = 0;
        head = 0;
        tail = 0;
    }


    @Override
    public void addFirst(Object element) {
        growIfNecessary();
        head = (head - 1 + elements.length) % elements.length;
        elements[head] = element;
        currentSize++;
    }

    @Override
    public void addLast(Object element) {
        growIfNecessary();
        elements[tail] = element;
        tail = (tail + 1) % elements.length;
        currentSize++;
    }

    @Override
    public Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object removed = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        currentSize--;
        return removed;
    }

    @Override
    public Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        tail = (tail - 1 + elements.length) % elements.length;
        Object removed = elements[tail];
        elements[tail] = null;
        currentSize--;
        return removed;
    }

    @Override
    public Object getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements[head];
    }

    @Override
    public Object getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements[(tail - 1 + elements.length) % elements.length];
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    private void growIfNecessary() {
        if (currentSize == elements.length) {
            Object[] newElements = new Object[2 * elements.length];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[(head + i) % elements.length];
            }
            elements = newElements;
            head = 0;
            tail = currentSize;
        }
    }
}
