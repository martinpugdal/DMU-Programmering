package twodice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RollTwoDice {
    private static int rollCount = 0;
    private static int eyesSum = 0;
    private static int totalPairs = 0;
    private static int highestEyes = 0;
    private static final int[] frequentFaces = new int[6];

    public static void main(String[] args) {
        System.out.println("Welcome to the game of RollTwoDice");
        printRules();
        System.out.println();

        playTwoDice();

        System.out.println();
        System.out.println("Thank you for playing RollOneDie");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of RollOneDie:");
        System.out.println("The player throws one die as long as he/she wants.");
        System.out.println("=====================================================");
    }

    private static void playTwoDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Roll? ('no' stops) ");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) {
            int[] faces = rollDice();
            System.out.println("Eyes: " + Arrays.toString(faces));
            System.out.println();

            updateStatistics(faces);

            System.out.print("Roll? ('no' stops) ");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }

    private static int[] rollDice() {
        Random random = new Random();
        return new int[]{random.nextInt(6)+1, random.nextInt(6)+1};
    }

    private static void updateStatistics(int[] faces) {
        rollCount++;
        int facesSum = faces[0] + faces[1];
        eyesSum += facesSum;
        if (faces[0] == faces[1]) {
            totalPairs++;
        }
        if (facesSum > highestEyes) {
            highestEyes = facesSum;
        }
        for (int face : faces) {
            frequentFaces[face-1]++;
        }
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Roll count:", rollCount);
        System.out.printf("%17s %4d\n", "Eyes sum:", eyesSum);
        System.out.printf("%17s %4d\n", "Total pairs:", totalPairs);
        System.out.printf("%17s %4d\n", "Highest eyes:", highestEyes);
        for (int i = 0; i < 6; i++) {
            System.out.printf("%17s %4d\n", (i+1 == 1) ? i+1+" eye:" : i+1+" eyes:", frequentFaces[i]);
        }
    }
}
