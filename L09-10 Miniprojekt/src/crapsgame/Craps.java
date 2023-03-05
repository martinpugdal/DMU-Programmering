package crapsgame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Craps {

    private static final Scanner scanner = new Scanner(System.in);
    private static int lostGames = 0;
    private static int WonGames = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the game of Submitted.Craps");
        printRules();
        System.out.println();

        playCraps();

        System.out.println();
        System.out.println("Thank you for playing Submitted.Craps");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Submitted.Craps:");
        System.out.println("The first throw is called 'come out roll'. The player wins immediately if the first throw is 7 or 11, and loses immediately if the first throw is 2, 3 or 12. If the player's first throw is 4, 5, 6, 8, 9 or 10, this number is established as the player's 'points'. The player then keeps going throw until he either throws his 'point' again or throws 7. If he throws 7, he has lost. Does he throw his 'point', he has won.");
        System.out.println("=====================================================");
    }

    private static void playCraps() {
        System.out.print("Roll? ('no' stops) ");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) {
            int[] faces = rollDice();
            System.out.println("Eyes: " + Arrays.toString(faces));
            System.out.println();
            int facesSum = faces[0] + faces[1];
            if (facesSum == 7 || facesSum == 11) {
                WonGames++;
                System.out.println("You won on your first throw!");
            } else if (facesSum == 2 || facesSum == 3 || facesSum == 12) {
                lostGames++;
                System.out.println("You lost on your first throw!");
            } else {
                if (rollforPoint(facesSum)) {
                    WonGames++;
                    System.out.println("You won!");
                } else {
                    lostGames++;
                    System.out.println("You lost!");
                }
            }
            System.out.print("Play again? ('no' stops) ");
            answer = scanner.nextLine();
        }
        printStatistics();
        scanner.close();
    }

    public static boolean rollforPoint(int point) {
        int[] faces;
        int facesSum = 0;
        System.out.print("Roll again? ");
        scanner.nextLine();
        while (facesSum != 7) {
            faces = rollDice();
            System.out.println("Eyes: " + Arrays.toString(faces));
            System.out.println();
            facesSum = faces[0] + faces[1];
            if (facesSum == point) {
                return true;
            } else if (facesSum != 7) {
                System.out.print("Roll again? ");
                scanner.nextLine();
            }
        }
        return false;
    }

    private static int[] rollDice() {
        Random random = new Random();
        return new int[]{random.nextInt(6)+1, random.nextInt(6)+1};
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Won games:", WonGames);
        System.out.printf("%17s %4d\n", "Lost games:", lostGames);
    }
}
