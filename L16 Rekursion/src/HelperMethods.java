import java.util.ArrayList;

public class HelperMethods {

    public static int ligeTal(ArrayList<Integer> list, int index) {
        if (index == list.size()) return 0;
        else {
            if (list.get(index) % 2 == 0) {
                return 1 + ligeTal(list, index + 1);
            } else {
                return ligeTal(list, index + 1);
            }
        }
    }

    public static boolean palindrom(char[] tekst, int index) {
        if (index == tekst.length / 2) {
            return true;
        }

        char first = tekst[index];
        char last = tekst[tekst.length - 1 - index];
        if (first == last) {
            return palindrom(tekst, index + 1);
        }
        return false;
    }


    public static boolean binarySearch(int[] array, int number, int index) {
        return index != array.length &&
                (
                        array[index] == number ||
                                binarySearch(array, number, index + 1)
                );
    }

    public static int towerOfHanoiMove(int disks, int from, int to) {
        if (disks == 1) {
            System.out.println("Move disk from " + from + " to " + to);
            return 1;
        }
        int other = 6 - from - to;
        int moves = 0;
        moves += towerOfHanoiMove(disks - 1, from, other);
        System.out.println("Move disk from " + from + " to " + to);
        moves++;
        moves += towerOfHanoiMove(disks - 1, other, to);
        return moves;
    }
}
