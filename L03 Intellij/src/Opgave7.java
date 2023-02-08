import java.util.Scanner;

public class Opgave7 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Indtast et tal (1): ");
        int inputInt1 = sc.nextInt();
        System.out.print("Indtast et tal (2): ");
        int inputInt2 = sc.nextInt();
        System.out.print("Indtast et tal (3): ");
        int inputInt3 = sc.nextInt();
        System.out.println(inorder(inputInt1, inputInt2, inputInt3));
    }

    private static String inorder(int... args) {
        String result = "";
        if (args[0] < args[1] && args[1] < args[2]) {
            result = "voksende";
        } else if (args[0] > args[1] && args[1] > args[2]) {
            result = "aftagende";
        } else {
            result = "hverken eller";
        }
        return result;
    }
}
