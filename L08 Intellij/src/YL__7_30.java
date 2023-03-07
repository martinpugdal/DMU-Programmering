import java.util.Scanner;

public class YL__7_30 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the number of values: ");
        int valuesSize = scanner.nextInt();
        int[] arrayValues = new int[valuesSize];
        System.out.print("Enter the values: ");
        for (int i = 0; i < valuesSize; i++) {
            arrayValues[i] = scanner.nextInt();
        }
        System.out.println(isConsecutiveFour(arrayValues));
        main(null); //repeating
    }

    public static boolean isConsecutiveFour(int[] values) {
        for (int i = 0; i < values.length-3; i++) {
            if (values[i] == values[i + 1] && values[i] == values[i + 2] && values[i] == values[i + 3]) {
                return true;
            }
        }
        return false;
    }
}
