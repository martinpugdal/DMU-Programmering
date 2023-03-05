package Submitted;

import java.util.*;

/**
 * @author Loshan Sundaramoorthy, Sebastian Tully Schmidt, Martin Pugdal Pedersen
 * @version 1.0
 */
public class RollTwoDice {

    public static int rollCount;
    public static int eyesSum;
    public static int totalPair;
    public static int highestEyes;
    public static final int[] countFaces = new int[6];

    public static void main(String[] args) {
        System.out.println("Welcome to the game of RollTwoDice");
        printRules();
        System.out.println();

        playTwoDice();

        System.out.println();
        System.out.println("Thank you for playing RollTwoDice");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Submitted.RollTwoDice:");
        System.out.println("The player throws two dice as long as he/she wants.");
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
        int[] dice = new int[2];
        Random random = new Random();
        for (int i = 0; i < dice.length; i++) {
            dice[i] = random.nextInt(6) + 1;
        }
        return dice;
    }

    private static void updateStatistics(int[] faces) {
        rollCount++;
        int facesSum = faces[0] + faces[1];
        eyesSum += facesSum;
        if (faces[0] == faces[1])
            totalPair++;
        if (facesSum > highestEyes)
            highestEyes = facesSum;
        for (int face : faces) {
            countFaces[face - 1] += 1;
        }
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Roll count:", rollCount);
        System.out.printf("%17s %4d\n", "Sum of eyes:", eyesSum);
        System.out.printf("%17s %4d\n", "Total pairs:", totalPair);
        System.out.printf("%17s %4d\n", "Highest eyes:", highestEyes);
        for (int i = 0; i < 6; i++) {
            System.out.printf("%17s %4d\n", i + 1 + " Dice:", countFaces[i]);
        }
    }
}

