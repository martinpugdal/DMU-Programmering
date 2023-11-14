import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelperMethodsTest {


    @Test
    void test_palindrom_valid() {

        // Arrange
        String pal1 = "aavaa";
        String pal2 = "anna";
        String pal3 = "TESET";

        // Act
        assertTrue(Main.palindrom(pal1));
        assertTrue(Main.palindrom(pal2));
        assertTrue(Main.palindrom(pal3));

    }

    @Test
    void test_palindrom_invalid() {

        // Arrange
        String pal1 = "BABABA";
        String pal2 = "ananas";
        String pal3 = "sovs";

        // Act & assert
        assertFalse(Main.palindrom(pal1));
        assertFalse(Main.palindrom(pal2));
        assertFalse(Main.palindrom(pal3));
    }
}