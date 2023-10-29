package queuetest;

import deque.CircularArrayDeque;
import deque.DequeI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DequeTest {

    private DequeI deque;

    @BeforeEach
    public void setUp() {
        deque = new CircularArrayDeque(5);
    }

    @Test
    public void testAddFirst() {
        deque.addFirst("A");
        deque.addFirst("B");
        deque.addFirst("C");
        assertEquals("C", deque.getFirst());
        assertEquals("A", deque.getLast());
        assertEquals(3, deque.size());
        assertFalse(deque.isEmpty());
    }

    @Test
    public void testAddLast() {
        deque.addLast("A");
        deque.addLast("B");
        deque.addLast("C");
        assertEquals("A", deque.getFirst());
        assertEquals("C", deque.getLast());
        assertEquals(3, deque.size());
        assertFalse(deque.isEmpty());
    }

    @Test
    public void testRemoveFirst() {
        deque.addLast("A");
        deque.addLast("B");
        deque.addLast("C");
        assertEquals("A", deque.removeFirst());
        assertEquals("B", deque.getFirst());
        assertEquals("C", deque.getLast());
        assertEquals(2, deque.size());
        assertFalse(deque.isEmpty());
    }

    @Test
    public void testRemoveLast() {
        deque.addLast("A");
        deque.addLast("B");
        deque.addLast("C");
        assertEquals("C", deque.removeLast());
        assertEquals("A", deque.getFirst());
        assertEquals("B", deque.getLast());
        assertEquals(2, deque.size());
        assertFalse(deque.isEmpty());
    }

    @Test
    public void testGetFirst() {
        deque.addLast("A");
        deque.addLast("B");
        deque.addLast("C");
        assertEquals("A", deque.getFirst());
        deque.removeFirst();
        assertEquals("B", deque.getFirst());
        assertEquals(2, deque.size());
        assertFalse(deque.isEmpty());
    }

    @Test
    public void testGetLast() {
        deque.addLast("A");
        deque.addLast("B");
        deque.addLast("C");
        assertEquals("C", deque.getLast());
        deque.removeLast();
        assertEquals("B", deque.getLast());
        assertEquals(2, deque.size());
        assertFalse(deque.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, deque.size());
        deque.addLast("A");
        deque.addLast("B");
        assertEquals(2, deque.size());
        deque.removeFirst();
        assertEquals(1, deque.size());
        deque.removeLast();
        assertEquals(0, deque.size());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(deque.isEmpty());
        deque.addLast("A");
        assertFalse(deque.isEmpty());
        deque.removeFirst();
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
    }
}