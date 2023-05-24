import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Opgave5 {
    public static void main(String[] args) {
        try {
            PrintWriter file = new PrintWriter("A:\\GitHub\\Programmering1\\L32 Intellij\\src\\" + "Opgave5.txt");
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter some numbers and end it with \"-1\":");
            int input = 0;
            while (input != -1) {
                input = scanner.nextInt();
                if (input < 1 && input != -1) {
                    System.out.printf("Input must be greater than 0, not %d%n", input);
                } else if (input != -1) {
                    file.println(input);
                }
            }

            file.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
