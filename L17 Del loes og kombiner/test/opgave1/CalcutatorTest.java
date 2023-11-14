package opgave1;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalcutatorTest {

    @org.junit.jupiter.api.Test
    void add() {

        // Arranges
        Calcutator calcutator = new Calcutator();
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(45);
        numbers.add(12);
        numbers.add(56);
        numbers.add(37);
        numbers.add(48);
        numbers.add(12);
        numbers.add(34);
        numbers.add(4);
        numbers.add(56);

        // Acts
        int actualSum = calcutator.sum(numbers);
        int expectedSum = 304;

        // Asserts
        assertEquals(expectedSum, actualSum);
    }
}