package Opgave6.filer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class PrintWriterTal {

    public static void main(String[] args) {


        String filePath = "A:\\GitHub\\Programmering1\\L32 Intellij\\src\\Opgave6\\talfiler\\";
        try {

            // indlaes antal tal i filen
            Scanner scan = new Scanner(System.in);
            System.out.print("Antal tal der skal skrives i filen: ");
            int antal = scan.nextInt();
            String FileName = "Tal" + antal + ".txt";
            PrintWriter printWriter = new PrintWriter(filePath + FileName);

            // skab tilfældige tal generator Random
            Random rnd = new Random();

            // generer og skriv de tilfældige tal
            for (int n = 1; n <= antal; n++) {
                int tal = rnd.nextInt(10000);
                printWriter.println(tal);
            }

            // skriv filen
            printWriter.close();
            scan.close();

            System.out.println("Filen er lavet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
