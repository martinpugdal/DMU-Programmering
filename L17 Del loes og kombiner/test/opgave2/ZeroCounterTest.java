package opgave2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZeroCounterTest {

    @Test
    void countZero() {

        // Arranges
        ZeroCounter sort = new ZeroCounter();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(45);
        list.add(12);
        list.add(56);
        list.add(37);
        list.add(0); // 1
        list.add(48);
        list.add(12);
        list.add(34);
        list.add(4);
        list.add(56);
        list.add(0); // 2

        // Acts
        int actualCount = sort.countZero(list);
        int expectedCount = 2;

        // Asserts
        assertEquals(expectedCount, actualCount);
    }
}