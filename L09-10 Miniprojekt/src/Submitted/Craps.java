package Submitted;

import java.util.*;

/**
 * @author Loshan Sundaramoorthy, Sebastian Tully Schmidt, Martin Pugdal Pedersen
 * @version 1.0
 */
public class Craps {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        rules();
        playCraps();
    }

    public static int sumOfTwoDice() {
        Random random = new Random();
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;

        return die1 + die2;
    }

    public static void playCraps() {
        System.out.print("To play craps press [Enter]");
        sc.nextLine();
        int firstThrow = sumOfTwoDice();

        if (firstThrow == 7 || firstThrow == 11) {
            System.out.println("You rolled " + firstThrow + ". You win!");
        } else if (firstThrow == 2 || firstThrow == 3 || firstThrow == 12) {
            System.out.println("You rolled " + firstThrow + ". You lose...");
        } else {
            System.out.println("You rolled " + firstThrow + " and your point is " + firstThrow + ".");
            boolean pointRolled = rollForPoint(firstThrow);
            if (pointRolled) {
                System.out.println("You rolled your point, and you won!");
            } else {
                System.out.println("You rolled 7, which means you lost...");
            }
        }

        System.out.println("Press [Enter] to quit or write 'y' to play again");
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("y")) {
            playCraps();
        }
    }

    public static boolean rollForPoint(int point) {
        System.out.print("Press [Enter] to throw again");
        sc.nextLine();
        int roll = sumOfTwoDice();

        while(point != roll && roll != 7) {
            System.out.println("You rolled " + roll + " and your point is " + point);
            System.out.println("Enter to roll again");
            sc.nextLine();
            roll = sumOfTwoDice();
        }
        return roll == point;
    }

    public static void rules() {
        System.out.println("Welcome to the game of Craps");
        System.out.println();
        System.out.println("========================================================================================================");
        System.out.println("Det første kast kaldes ‘come out roll’. Spilleren vinder med det samme, hvis det første kast er 7 \n" +
                "eller 11, og taber med det samme, hvis det første kast er 2, 3 eller 12. Hvis spillerens første kast er \n" +
                "4, 5, 6, 8, 9 eller 10, etableres dette tal som spillerens ‘point’. Spilleren bliver derefter ved med at \n" +
                "kaste, indtil han enten kaster sit ‘point’ igen eller kaster 7. Kaster han 7, har han tabt. Kaster han \n" +
                "sit ’point’, har han vundet.");
        System.out.println("========================================================================================================");
        System.out.println();
    }
}
