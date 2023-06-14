import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Opgave5 {
    public static void main(String[] args) {
        try {
            File file = new File("A:\\GitHub\\Programmering1\\L32 Intellij\\src\\"+"Opgave5.txt");
            ArrayList<Integer> numbers = new ArrayList<>();
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextInt()) {
                    numbers.add(scanner.nextInt());
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
            PrintWriter printWriter = new PrintWriter("A:\\GitHub\\Programmering1\\L32 Intellij\\src\\" + "Opgave5.txt");
            Scanner scanner1 = new Scanner(System.in);
            for (Integer number : numbers) {
                printWriter.println(number);
            }
            System.out.println("Enter some numbers and end it with \"-1\":");
            int input = 0;
            while (input != -1) {
                input = scanner1.nextInt();
                if (input < 1 && input != -1) {
                    System.out.printf("Input must be greater than 0, not %d%n", input);
                } else if (input != -1) {
                    printWriter.println(input);
                }
            }
            scanner1.close();
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
