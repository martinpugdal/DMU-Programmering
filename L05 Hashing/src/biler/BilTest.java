package biler;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

class BilTest {

    @Test
    public void test_equals() {

        // Arrange
        Bil bil1 = new Bil("EH22333", "Volvo", "Voldsom", "Rød");
        Bil bil2 = new Bil("EH22333", "Volvo", "Voldsom", "Rød");

        // Act & assert
        assertTrue(bil1.equals(bil2));
        bil1.setRegistreringsnummer("EH22444");
        assertFalse(bil1.equals(bil2));
    }

    @Test
    public void test_hashCode() {

        // Arrange
        Bil bil1 = new Bil("EH22333", "Volvo", "Voldsom", "Rød");
        Bil bil2 = new Bil("EH22333", "Volvo", "Voldsom", "Rød");
        HashSet<Bil> biler = new HashSet<>();

        // Act & assert
        biler.add(bil1);
        assertEquals(1, biler.size());
        assertFalse(biler.add(bil2));
        assertEquals(1, biler.size());
    }
}