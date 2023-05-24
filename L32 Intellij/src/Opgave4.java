import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Opgave4 {
    public static void main(String[] args) {
        try {
            PrintWriter file = new PrintWriter("A:\\GitHub\\Programmering1\\L32 Intellij\\src\\" + "Opgave4.txt");

            for (int i = 0; i < 100; i++) {
                if (i % 2 != 0) {
                    file.println(i);
                }
            }

            file.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
