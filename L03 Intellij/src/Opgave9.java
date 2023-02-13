import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Opgave9 {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter today’s day: ");
        int dayNow = sc.nextInt();
        System.out.print("Enter the number of days elapsed since today: ");
        int dayFuture = sc.nextInt();
        System.out.printf("Today is %s and the future day is %s%n", getDay(dayNow), getDay(dayNow+dayFuture));
    }

    private static String getDay(int day) {
        ArrayList<String> days = new ArrayList<>(Arrays.asList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"));
        return days.get((day)%7);
    }
}
