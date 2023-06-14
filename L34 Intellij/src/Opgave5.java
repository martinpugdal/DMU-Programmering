import java.io.*;
import java.util.Scanner;

public class Opgave5 {

    public static void main(String[] args) {
        String fileName1 = "A:\\GitHub\\Programmering1\\L34 Intellij\\src\\" +"file1.txt";
        String fileName2 = "A:\\GitHub\\Programmering1\\L34 Intellij\\src\\" +"file2.txt";
        String fileNameNy = "A:\\GitHub\\Programmering1\\L34 Intellij\\src\\" +"fileNy.txt";

        // Opret de to filer med stigende heltal og MAX_VALUE
        opretFil(fileName1, 100);
        opretFil(fileName2, 400);

        // Flet filerne og gem resultatet i en ny fil
        fletAlleHeltal(fileName1, fileName2, fileNameNy);
    }

    public static void fletAlleHeltal(String fileName1, String fileName2, String fileNameNy) {
        try (Scanner scanner1 = new Scanner(new File(fileName1));
             Scanner scanner2 = new Scanner(new File(fileName2));
             PrintWriter writer = new PrintWriter(fileNameNy)) {
            int num1 = scanner1.hasNextInt() ? scanner1.nextInt() : Integer.MAX_VALUE;
            int num2 = scanner2.hasNextInt() ? scanner2.nextInt() : Integer.MAX_VALUE;

            while (num1 != Integer.MAX_VALUE || num2 != Integer.MAX_VALUE) {
                if (num1 < num2) {
                    writer.println(num1);
                    num1 = scanner1.hasNextInt() ? scanner1.nextInt() : Integer.MAX_VALUE;
                } else {
                    writer.println(num2);
                    num2 = scanner2.hasNextInt() ? scanner2.nextInt() : Integer.MAX_VALUE;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void opretFil(String fileName, int antalTal) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 1; i <= antalTal; i++) {
                writer.println(i);
            }
            writer.print(Integer.MAX_VALUE); // Skriv MAX_VALUE som en linje uden newline
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}