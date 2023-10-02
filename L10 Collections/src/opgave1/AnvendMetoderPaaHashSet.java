package opgave1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AnvendMetoderPaaHashSet {

    public static void main(String[] args) {

        final Set<Integer> numbers = new HashSet<>(Arrays.asList(34, 12, 23, 45, 67, 34, 98));
        numbers.add(34);

        numbers.add(23);
        System.out.println(numbers);

        numbers.remove(67);
        System.out.println(numbers);

        System.out.println("Contains 23: " + numbers.contains(23));

        System.out.println("Størrelsen af set: " + numbers.size());

    }
}
