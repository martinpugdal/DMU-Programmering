import java.util.ArrayList;

public class Ex2 {
    /**
     * Tests all the methods.
     */
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(12);
        ints.add(0);
        ints.add(45);
        ints.add(7);
        ints.add(-16);
        ints.add(0);
        ints.add(23);
        ints.add(-10);
        // ints.addAll(List.of(12, 0, 45, 7, -16, 0, 23, -10));
        System.out.println("ints: " + ints);
        System.out.println();
        // Test of sum1() method: correct sum is 61.
        System.out.println("Sum1: " + sum1(ints));
        // Test of sum() method: correct sum is 61.
        System.out.println("Sum: " + sum(ints));
        // Test of minimum() method: correct minimum is -16.
        System.out.println("Minimum: " + minimum(ints));
        // Test of maximum() method: correct maximum is 45.
        System.out.println("Maximum: " + maximum(ints));
        // Test of average() method: correct average is 7.625.
        System.out.println("Average: " + average(ints));
        // Test of zeroes() method: correct number of zeroes is 2.
        System.out.println("Number of zeroes: " + zeroes(ints));
        // Test of evens() method: correct result is [12, 0, -16, 0, -10].
        System.out.println("Evens: " + evens(ints));
    }

    // sum made with for statement
    public static int sum1(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            sum += number;
        }
        return sum;
    }

    /**
     * Return the sum of all numbers in the list.
     * Return 0, if the list is empty.
     */
    public static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i: list) {
            sum += i;
        }
        return sum;
    }

    /**
     * Return the minimum of all numbers in the list.
     * Pre: The list is not empty.
     */
    public static int minimum(ArrayList<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (int i: list) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    /**
     * Return the maximum of all numbers in the list.
     * Pre: The list is not empty.
     */
    public static int maximum(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int i: list) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    /**
     * Return the average of the numbers in the list.
     * Pre: The list is not empty.
     */
    public static double average(ArrayList<Integer> list) {
        int sum = sum(list);
        return (double) sum / list.size();
    }

    /** Return the number of zeros in the list. */
    public static int zeroes(ArrayList<Integer> list) {
        int count = 0;
        for (int i: list) {
            if (i == 0) {
                count++;
            }
        }
        return count;
    }

    /** Return a new list containing the even numbers in the list. */
    public static ArrayList<Integer> evens(ArrayList<Integer> list) {
        ArrayList<Integer> evensList = new ArrayList<>();
        for (int i : list) {
            if (i % 2 == 0) {
                evensList.add(i);
            }
        }
        return evensList;
    }


}