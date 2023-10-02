package opgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    static Map<String, List<Integer>> filmKarakterer = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {


        File file = new File("C:\\Users\\Marti\\Documents\\GitHub\\Programmering1\\L10 Intellij\\src\\opgave4\\result.txt");
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String film = scanner.nextLine();
            filmKarakterer.putIfAbsent(film, new ArrayList<>());
            filmKarakterer.get(film).add(Integer.parseInt(scanner.nextLine()));
        }

        for (String film : filmKarakterer.keySet()) {
            System.out.println(film + ": " + + filmKarakterer.get(film).size() + " karakterer, gennemsnit " + gennemsnit(film));
        }
    }

    private static String gennemsnit(String film) {
        double sum = 0;
        for (int i : filmKarakterer.get(film)) {
            sum += i;
        }
        if ((sum / filmKarakterer.get(film).size()) % 1 == 0) {
            return String.format("%.0f", sum / filmKarakterer.get(film).size());
        } else {
            return String.format("%.1f", sum / filmKarakterer.get(film).size());
        }
    }
}
