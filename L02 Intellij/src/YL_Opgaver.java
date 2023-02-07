import java.util.Scanner;

public class YL_Opgaver {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] arg) {
//        exercise__2_6();
//        exercise__2_7();
        exercise__2_23();
    }

    private static void exercise__2_6() {
//        (Sum the digits in an integer) Write a program that reads an integer between 0
//        and 1000 and adds all the digits in the integer. For example, if an integer is 932, the sum of all its digits is 14.
//        Hint: Use the % operator to extract digits, and use the / operator to remove the
//        extracted digit. For instance, 932 % 10 = 2 and 932 / 10 = 93.
        System.out.print("Indtast et tal ind, hvor værdien er i mellem 0 og 1000: ");
        int num = sc.nextInt();

        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        System.out.println("Summen af alle digits er: " + sum);
    }

    private static void exercise__2_7() {
//        Find the number of years) Write a program that prompts the user to enter the minutes (e.g., 1 billion),
//        and displays the maximum number of years and remaining days for the minutes.
//        For simplicity, assume that a year has 365 days.
        System.out.print("Indtast et tal ind hvor det er i enheden minut: ");
        long minutes = sc.nextLong();

        int years = (int) (minutes / 525600);
        int days = (int) ((minutes % 525600) / 1440);

        System.out.println(minutes + " minutes er omtrent " + years + " år og " + days + " dage.");
    }

    private static void exercise__2_23() {
//    (Cost of driving) Write a program that prompts the user to enter the distance to
//    drive, the fuel efficiency of the car in miles per gallon, and the price per gallon
//    then displays the cost of the trip.
        System.out.print("Indtast køreafstand: ");
        double distance = sc.nextDouble();
        System.out.print("Indtast miles per. gallon: ");
        double mpg = sc.nextDouble();
        System.out.print("Indtast prisen per gallon: ");
        double ppg = sc.nextDouble();
        double cost = (distance / mpg) * ppg;
        System.out.println("omkostningerne ved kørsel er $" + cost);
    }
}