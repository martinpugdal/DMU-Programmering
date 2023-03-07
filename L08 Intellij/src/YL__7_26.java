import java.util.Scanner;

public class YL__7_26 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter list: ");
        int valuesSize = scanner.nextInt();
        int[] arrayValues = new int[valuesSize];
        for (int i = 0; i < valuesSize; i++) {
            arrayValues[i] = scanner.nextInt();
        }
        System.out.println(isSorted(arrayValues) ? "The list is sorted" : "The list is not sorted");
        main(null); //repeating
    }


    public static boolean isSorted(int[] list) {
        for (int i = 0; i < list.length-1; i++) {
            if (!(list[i + 1] >= list[i])) {
                return false;
            }
        }
        return true;
    }
}
