package opgave3;

import java.util.HashSet;
import java.util.Set;

public class PersonAdministrator {

    private static PersonAdministrator instance = new PersonAdministrator();
    private final Set<Person> personSet;

    public PersonAdministrator() {
        personSet = new HashSet<>();
    }

    public static PersonAdministrator getInstance() {
        return instance;
    }

    public void add(Person person) {
        personSet.add(person);
    }

    public Set<Person> getPersoner() {
        return personSet;
    }

    public void remove(Person person) {
        personSet.remove(person);
    }
}
