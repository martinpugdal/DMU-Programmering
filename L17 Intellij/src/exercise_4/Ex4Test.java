package exercise_4;

import java.util.ArrayList;

public class Ex4Test {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(9);
        list.add(16);
        list.add(25);

        System.out.println("Original list: " + list);

        swapFirstAndLast(list);
        System.out.println("After swapping first and last: " + list);

        replaceEvenWithZero(list);
        System.out.println("After replacing even with zero: " + list);

        System.out.println("Second highest element: " + getSecondHighest(list));

        System.out.println("Is sorted ascending? " + isSortedAscending(list));

        shiftRight(list);
        System.out.println("After shifting right: " + list);

        System.out.println("Has doublets? " + hasDoublets(list));
    }

    public static void swapFirstAndLast(ArrayList<Integer> list) {
        int temp = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.set(list.size() - 1, temp);
    }

    public static void replaceEvenWithZero(ArrayList<Integer> list) {
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) % 2 == 0) {
                list.set(i, 0);
            }
        }
    }

    public static int getSecondHighest(ArrayList<Integer> list) {
        int n = list.size() - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (list.get(j) < list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list.get(1);
    }

    private static boolean isSortedAscending(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void shiftRight(ArrayList<Integer> list) {
        int lastElement = list.get(list.size() - 1);
        for (int i = list.size() - 2; i >= 0; i--) {
            list.set(i + 1, list.get(i));
        }
        list.set(0, lastElement);
    }

    public static boolean hasDoublets(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
}