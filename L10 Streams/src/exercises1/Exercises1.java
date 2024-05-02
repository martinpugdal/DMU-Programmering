package exercises1;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Exercises1 {

    public static void main(String[] args) {
        // Liste med tal mellem 1 - 50
        List<Integer> list = List.of(1,2,3,2,1,6,3,4,5,2,3,8,8,9,34,32);
        list.stream().forEach(e-> System.out.println(e+1));

        //	Udskriver det største element i listen
        System.out.println(list.stream().max(Integer::compareTo).get());

        //	Afgør og udskriver om alle tallene i listen er mindre end 50
        System.out.println(list.stream().allMatch(n -> n < 50));

        // 	Udskriver antallet af lige tal i listen
        System.out.println(list.stream().filter(n -> n % 2 == 0).count());

        //	Udskriver antallet af ulige tal i listen
        System.out.println(list.stream().filter(n -> n % 2 != 0).count());

        //  Udskriver
        //      Gennemsnittet af tallene i listen
        System.out.println(list.stream().mapToInt(Integer::intValue).average().getAsDouble());
        //      Antallet af tallene i listen
        System.out.println(list.stream().count());
        //      Antallet af tallene i listen der er større end gennemsnittet
        System.out.println(list.stream().filter(n -> n > list.stream().mapToInt(Integer::intValue).average().getAsDouble()).count());
        //      Antallet af tallene i listen der er mindre end gennemsnittet
        System.out.println(list.stream().filter(n -> n < list.stream().mapToInt(Integer::intValue).average().getAsDouble()).count());

        // Udskriver antallet af gange de forskellige tal forekommer i listen
        list.stream().distinct().forEach(n -> System.out.println(n + ": " + list.stream().filter(m -> m == n).count()));

        //	Udskriver antallet af gange de forskellige tal forekommer i listen i sorteret orden
        list.stream().distinct().sorted().forEach(n -> System.out.println(n + ": " + list.stream().filter(m -> m == n).count()));
    }
}
