import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Opgave3 {
    public static void main(String[] args) {
        File file = new File("A:\\GitHub\\Programmering1\\L32 Intellij\\src\\" + "Opgave2.txt");
        try {
            Scanner scanner = new Scanner(file);
            ArrayList<Integer> numbers = new ArrayList<>();

            while (scanner.hasNextLine()) {
                numbers.add(scanner.nextInt());
            }
            scanner.close();

            numbers.sort((a, b) -> b - a);
            System.out.println(numbers);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
