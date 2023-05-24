package Opgave6;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        File folder = new File("A:\\GitHub\\Programmering1\\L32 Intellij\\src\\Opgave6\\talfiler\\");
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                String fileName = "\\" + file.getName();
                try {
                    System.out.printf("Max: %d%n", max(folder + fileName));
                    System.out.printf("Min: %d%n", min(folder + fileName));
                    System.out.printf("Gennemsnit: %.2f%n", gennemsnit(folder + fileName));
                } catch (IOException e) {
                    System.out.printf("File not found: %s%n", fileName);
                }
            }
        }
    }

    public static int max(String filename) throws IOException {
        try (Scanner scan = new Scanner(new File(filename))) {
            int max = scan.nextInt();
            while (scan.hasNextInt()) {
                int next = scan.nextInt();
                if (next > max) {
                    max = next;
                }
            }
            return max;
        }
    }

    public static int min(String fileName) throws IOException {
        try (Scanner scan = new Scanner(new File(fileName))) {
            int min = scan.nextInt();
            while (scan.hasNextInt()) {
                int next = scan.nextInt();
                if (next < min) {
                    min = next;
                }
            }
            return min;
        }
    }

    public static double gennemsnit(String fileName) throws IOException {
        try (Scanner scan = new Scanner(new File(fileName))) {
            int sum = 0;
            int count = 0;
            while (scan.hasNextInt()) {
                sum += scan.nextInt();
                count++;
            }
            return (double) sum / count;
        }
    }
}
