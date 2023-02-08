import java.util.Scanner;

public class YL_Opgaver {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] arg) throws Exception {
//        exercise__2_6();
//        exercise__2_7();
        exercise__2_23();
    }

    private static void exercise__2_6() throws Exception {
//        (Sum the digits in an integer) Write a program that reads an integer between 0
//        and 1000 and adds all the digits in the integer. For example, if an integer is 932, the sum of all its digits is 14.
//        Hint: Use the % operator to extract digits, and use the / operator to remove the
//        extracted digit. For instance, 932 % 10 = 2 and 932 / 10 = 93.
        System.out.print("Indtast et tal ind, hvor værdien er i mellem 0 og 1000: ");
        int inputNum = sc.nextInt();
        if (inputNum > 1000 || inputNum < 0) {
            throw new Exception("Skriv et tal mellem 0 og 1000..");
        }

        int sum = 0;
        while (inputNum > 0) {
            sum += inputNum % 10;
            inputNum /= 10;
        }
        System.out.println("Summen af alle digits er: " + sum);
    }

    private static void exercise__2_7() {
//        Find the number of years) Write a program that prompts the user to enter the minutes (e.g., 1 billion),
//        and displays the maximum number of years and remaining days for the minutes.
//        For simplicity, assume that a year has 365 days.
        System.out.print("Indtast et tal ind hvor det er i enheden minut: ");
        long inputMinutes = sc.nextLong();
        int days = (int) inputMinutes/60/24;
        int years = days/365;
        System.out.println(inputMinutes + " minutes er omtrent " + years + " år og " + days + " dage.");
    }

    private static double getDoubleByString(String value) {
        double doubleVal;
        try {
            doubleVal = Double.parseDouble(value);
        } catch (Exception e) {
            doubleVal = Double.parseDouble(value.replace(",", "."));
        }
        return doubleVal;
    }

    private static void exercise__2_23() {
//    (Cost of driving) Write a program that prompts the user to enter the distance to
//    drive, the fuel efficiency of the car in km per L, and the price per L
//    then displays the cost of the trip.
        System.out.print("Indtast køreafstand: ");
        double inputDistance = getDoubleByString(sc.next());
        System.out.print("Indtast miles per. liter: ");
        double inputKmPerL = getDoubleByString(sc.next());
        System.out.print("Indtast prisen per liter: ");
        double inputPricePerL = getDoubleByString(sc.next());
        double cost = (inputDistance / inputKmPerL) * inputPricePerL;
        System.out.println("omkostningerne ved kørsel er " + cost + ",-");
    }
}