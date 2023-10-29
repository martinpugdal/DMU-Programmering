package cannibal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircularCannibalMealTest {
    private CircularCannibalMeal meal;

    @BeforeEach
    public void setUp() {
        meal = new CircularCannibalMeal();
        meal.addPerson(new Person("Martin"));
        meal.addPerson(new Person("Mathias"));
        meal.addPerson(new Person("Mads"));
        meal.addPerson(new Person("Mikkel"));
        meal.printPersons();
    }

    @Test
    public void test_EatNextPerson() {
        assertEquals("Martin", meal.eatNextPerson(0).getName());
    }
}
