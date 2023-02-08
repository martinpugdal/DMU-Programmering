import java.util.Scanner;

public class Opgave3 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Indtast et tal (1): ");
        int inputInt1 = sc.nextInt();
        System.out.print("Indtast et tal (2): ");
        int inputInt2 = sc.nextInt();
        System.out.print("Indtast et tal (3): ");
        int inputInt3 = sc.nextInt();
        String result = "";
        if (inputInt1 < inputInt2 && inputInt2 < inputInt3)
             result = "voksende";
        else if (inputInt1 > inputInt2 && inputInt2 > inputInt3) {
            result = "aftagende";
        } else {
            result = "hverken eller";
        }
        System.out.println(result);
    }
}
