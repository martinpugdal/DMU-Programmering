import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Opgave2 {
    public static void main(String[] args) {
        File file = new File("A:\\GitHub\\Programmering1\\L32 Intellij\\src\\"+"Opgave2.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextInt() * 2);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
