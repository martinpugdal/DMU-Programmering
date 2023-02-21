import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        exercise_1a();
        exercise_1b();
    }


    public static void exercise_1a() {
        int max = 1;
        int min = 99;
        int evenCount = 0;
        int oddCount = 0;
        Scanner sc = new Scanner(System.in);
        int num = -1;
        while (num != 0) {
            System.out.print("Enter a number between 1-99, use (0) to stop it: ");
            num = sc.nextInt();
            if (num >= 1 && num <= 99) {
                if (num > max) {
                    max = num;
                }
                if (num < min) {
                    min = num;
                }
                if (num % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }
        }
        System.out.println("The largest number is: " + max);
        System.out.println("The smallest number is: " + min);
        System.out.println("Number of even numbers: " + evenCount);
        System.out.println("Number of odd numbers: " + oddCount);
    }


    public static void exercise_1b() {
        Scanner sc = new Scanner(System.in);
        int num = -1;
        int sum = 0;
        while (num != 0) {
            System.out.print("Enter a number between 1-99, use (0) to stop it: ");
            num = sc.nextInt();
            if (num >= 1 && num <= 99) {
                sum += num;
                System.out.println(sum);
            }
        }
    }
}
