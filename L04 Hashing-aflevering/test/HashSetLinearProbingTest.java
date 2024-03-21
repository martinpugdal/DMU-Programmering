import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashSetLinearProbingTest {

    @Test
    public void testAdd() {
        HashSetLinearProbing set = new HashSetLinearProbing(10);

        assertTrue(set.add("a"));
        assertTrue(set.add("b"));
        assertTrue(set.add("c"));
        assertTrue(set.add("d"));
        assertFalse(set.add("a")); // duplicate element
    }

    @Test
    public void testContains() {
        HashSetLinearProbing set = new HashSetLinearProbing(10);

        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");

        assertTrue(set.contains("a"));
        assertTrue(set.contains("b"));
        assertTrue(set.contains("c"));
        assertTrue(set.contains("d"));
        assertFalse(set.contains("e")); // not in set
    }

    @Test
    public void testSizeAndRemove() {
        HashSetLinearProbing set = new HashSetLinearProbing(10);

        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");

        assertEquals(4, set.size());

        assertTrue(set.remove("b"));
        assertFalse(set.contains("b"));

        assertEquals(3, set.size());
    }

    @Test
    public void testAddAndRemove() {
        HashSetLinearProbing set = new HashSetLinearProbing(10);

        assertTrue(set.add("a"));
        assertTrue(set.add("b"));
        assertTrue(set.add("c"));

        assertFalse(set.remove("x"));
    }

    @Test
    public void testSizeAfterAddAndRemove() {
        HashSetLinearProbing set = new HashSetLinearProbing(10);

        assertTrue(set.add("a"));
        assertTrue(set.add("b"));
        assertTrue(set.add("c"));

        assertFalse(set.remove("x"));

        assertEquals(3, set.size());
    }
}
