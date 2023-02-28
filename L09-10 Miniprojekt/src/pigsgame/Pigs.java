package pigsgame;

import java.util.Random;
import java.util.Scanner;

public class Pigs {

    private static final Scanner scanner = new Scanner(System.in);
    private static int pointsToWin;

    private static int player1Points = 0;
    private static int player2Points = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the game of Pigs");
        printRules();
        System.out.println();

        playPigs();

        System.out.println();
        System.out.println("Thank you for playing Pigs");
    }


    public static void choiceYourWinningPoint() {
        System.out.print("How many points for win this game? ");
        int maxPoints = scanner.nextInt();
        scanner.nextLine();
        pointsToWin = (maxPoints > 0) ? maxPoints : 100;
    }

    public static void playPigs() {
        choiceYourWinningPoint();
        System.out.println();
        System.out.print("Start your game? (Press enter) ");
        scanner.nextLine();
        boolean whosTurn = true;
        boolean winnerFound = false;
        while (!winnerFound) {
            if (whosTurn) {
                player1Points += rollforPoint("Martin", player1Points);
                if (player1Points >= pointsToWin) {
                    System.out.printf("%s just won this game with %d points!", "Martin", player1Points);
                    winnerFound = !winnerFound;
                }
            } else {
                player2Points += rollforPoint("Sebastian", player2Points);
                if (player2Points >= pointsToWin) {
                    System.out.printf("%s just won this game with %d points!", "Sebastian", player2Points);
                    winnerFound = !winnerFound;
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

    private static int rollDie() {
        Random random = new Random();
        return random.nextInt(6)+1;
    }

    public static int rollforPoint(String name, int points) {
        System.out.println();
        System.out.println(name + "'s turn to roll");
        System.out.println();
        System.out.print("Want to roll or skip? ");
        String answer = scanner.nextLine();
        int pointsForThisRound = 0;
        int eyes = 0;
        while (!answer.equals("skip")) {
            eyes = rollDie();
            pointsForThisRound += eyes;
            if (eyes == 1) {
                System.out.printf("Aw shit we got 1, %s lost the points for this round!%n%n", name);
                return 0;
            } else if (points + pointsForThisRound >= pointsToWin) {
                System.out.printf("%s rolled %d", name, eyes);
                return points + pointsForThisRound;
            }
            System.out.printf("%s rolled %d%n%n", name, eyes);
            System.out.print("Want to roll again or skip?");
            answer = scanner.nextLine();
        }
        System.out.printf("%s ended their turn with %d points.%n", name, points);
        return pointsForThisRound;
    }
}