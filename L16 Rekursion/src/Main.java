import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // opgave 1
        final ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 10));
        System.out.println("Opgave 1: " + ligeTal(list));
        System.out.println("Opgave 1 with helper: " + ligeTalHelper(list));

        // opgave 2
        System.out.println("Opgave 2 (ABBA): " + palindrom("ABBA"));
        System.out.println("Opgave 2 (radar): " + palindrom("radar"));

        // opgave 3
        System.out.println("Opgave 3: " + binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10}, 10));
        System.out.println("Opgave 3: " + binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10}, 11));

        // opgave 4
        System.out.println("Opgave 4 (2 rings): " + towerOfHanoi(2));
        System.out.println("Opgave 4 (3 rings): " + towerOfHanoi(3));
        System.out.println("Opgave 4 (4 rings): " + towerOfHanoi(4));
        System.out.println("Opgave 4 (5 rings): " + towerOfHanoi(5));
        System.out.println("Opgave 4 (6 rings): " + towerOfHanoi(6));
        System.out.println("Opgave 4 (7 rings): " + towerOfHanoi(7));
        System.out.println("Opgave 4 (8 rings): " + towerOfHanoi(8));
        System.out.println("Opgave 4 (9 rings): " + towerOfHanoi(9));
        System.out.println("Opgave 4 (10 rings): " + towerOfHanoi(10));
        System.out.println("Opgave 4 (15 rings): " + towerOfHanoi(15));
        System.out.println("Opgave 4 (20 rings): " + towerOfHanoi(20));
        System.out.println("Opgave 4 (25 rings): " + towerOfHanoi(25));
    }

    static int ligeTal(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        } else {
            ArrayList<Integer> newlist = new ArrayList<>(list.subList(1, list.size()));
            if (list.get(0) % 2 == 0) {
                return 1 + ligeTal(newlist);
            } else {
                return ligeTal(newlist);
            }
        }
    }

    static int ligeTalHelper(ArrayList<Integer> list) {
        return HelperMethods.ligeTal(list, 0);
    }

    static boolean palindrom(String tekst) {
        return HelperMethods.palindrom(tekst.toCharArray(), 0);
    }

    static boolean binarySearch(int[] array, int number) {
        return HelperMethods.binarySearch(array, number, 0);
    }

    static int towerOfHanoi(int rings) {
        return HelperMethods.towerOfHanoiMove(rings, 1, 3);
    }
}