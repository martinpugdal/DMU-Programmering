package Submitted;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Loshan Sundaramoorthy, Sebastian Tully Schmidt, Martin Pugdal Pedersen
 * @version 1.0
 */
public class Pigs {

    private static final Scanner scanner = new Scanner(System.in);
    private static int pointsToWin = 100;
    private static int player1Points = 0;
    private static String player1Name;
    private static int player2Points = 0;
    private static String player2Name;
    private static int[] player1Rolls;
    private static int[] player2Rolls;

    public static void main(String[] args) {
        System.out.println("Welcome to the game of Pigs");
        printRules();
        System.out.println();

        playPigs();

        System.out.println();
        printStatistics();
        System.out.println();

        System.out.println();
        System.out.println("Thank you for playing Pigs");
    }

    private static void pickNames() {
        System.out.print("Pick name for player 1: ");
        player1Name = scanner.next();
        System.out.print("Pick name for player 2: ");
        player2Name = scanner.next();
    }


    private static void winningPoint() {
        System.out.print("How many points for win this game? ");
        int maxPoints = scanner.nextInt();
        scanner.nextLine();
        pointsToWin = (maxPoints > 0) ? maxPoints : pointsToWin;
        player1Rolls = new int[pointsToWin*4];
        player2Rolls = new int[pointsToWin*4];
    }

    public static void playPigs() {
        pickNames();
        winningPoint();
        System.out.println();
        System.out.print("Start your game? (Press enter) ");
        scanner.nextLine();
        boolean whosTurn = true;
        boolean winnerFound = false;
        while (!winnerFound) {
            if (whosTurn) {
                player1Points = rollForPoint(player1Name, player1Points);
                if (player1Points >= pointsToWin) {
                    System.out.printf("%s won this game with %d!", player1Name, player1Points);
                    winnerFound = true;
                }
            } else {
                player2Points = rollForPoint(player2Name, player2Points);
                if (player2Points >= pointsToWin) {
                    System.out.printf("%s won this game with %d!", player2Name, player2Points);
                    winnerFound = true;
                }
            }
            whosTurn = !whosTurn;
        }
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Pigs:");
        System.out.println("Første spiller kaster en terning, indtil han enten kaster 1, eller beslutter sig for at stoppe. Hvis han \n" +
                "slår en 1’er, får han ingen point i denne runde. Hvis han beslutter sig for at stoppe, inden har slår \n" +
                "en 1’er, lægges summen af alle hans kast i denne runde sammen med hans samlede antal point, \n" +
                "og turen går videre til næste spiller. Derefter skiftes spillerne til at kaste. Den første spiller, der \n" +
                "samlet når 100 point, har vundet. ");
        System.out.println("=====================================================");
    }

    private static int[] rollDice() {
        Random random = new Random();
        return new int[]{random.nextInt(0,6)+1, random.nextInt(0,6)+1};
    }

    private static int rollForPoint(String name, int points) {
        System.out.println();
        System.out.printf("%s's turn to roll%n", name);
        System.out.println();
        System.out.print("Want to roll or skip? ");
        String answer = scanner.nextLine();
        int rollsTotal = 0;
        int pointsForThisRound = 0;
        int[] eyes;
        int eyesSum = 0;
        while (!answer.equals("skip")) {
            rollsTotal++;
            eyes = rollDice();
            eyesSum = eyes[0] + eyes[1];
            pointsForThisRound += eyesSum;
            if (eyes[0] == 1 && eyes[1] == 1) {
                updateStatistics(name.equals(player1Name), rollsTotal);
                System.out.printf("Aw shit we got 1 and 1, %s lost all points!%n%n", name);
                return 0;
            } else if (eyes[0] == 1 || eyes[1] == 1) {
                updateStatistics(name.equals(player1Name), rollsTotal);
                System.out.printf("Aw shit we got 1, %s lost the points for this round!%n%n", name);
                return points;
            } else if (points + pointsForThisRound >= pointsToWin) {
                updateStatistics(name.equals(player1Name), rollsTotal);
                System.out.printf("%s rolled %d (total: %d)%n%n", name, eyesSum, points + pointsForThisRound);
                return points + pointsForThisRound;
            } else {
                System.out.printf("%s rolled %d (total: %d)%n%n", name, eyesSum, points + pointsForThisRound);
                System.out.print("Want to roll again or skip? ");
                answer = scanner.nextLine();
            }
        }
        updateStatistics(name.equals(player1Name), rollsTotal);
        System.out.printf("%s ended their turn with %d points for this round, and now have %d %n%n", name, pointsForThisRound, points + pointsForThisRound);
        return points+pointsForThisRound;
    }

    private static void updateStatistics(boolean isPlayer1, int rolls) {
        if (isPlayer1) {
            for (int i = 0; i < player1Rolls.length; i++) {
                if (player1Rolls[i] == 0) {
                    player1Rolls[i] = rolls;
                    return;
                }
            }
        } else {
            for (int i = 0; i < player2Rolls.length; i++) {
                if (player2Rolls[i] == 0) {
                    player2Rolls[i] = rolls;
                    return;
                }
            }
        }
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        int p1Sum = 0;
        int p1Rounds = 0;
        int p2Sum = 0;
        int p2Rounds = 0;
        for (int rolls : player1Rolls) {
            if (rolls != 0) {
                p1Sum += rolls;
                p1Rounds++;
            }
        }
        for (int rolls : player2Rolls) {
            if (rolls != 0) {
                p2Sum += rolls;
                p2Rounds++;
            }
        }
        System.out.printf("%17s %4s %4d\n", "Rolls average per round for ", player1Name, p1Sum/p1Rounds);
        System.out.printf("%17s %4s %4d\n", "Rolls average per round for ", player2Name, (p2Rounds != 0) ? p2Sum/p2Rounds : 0);
    }
}