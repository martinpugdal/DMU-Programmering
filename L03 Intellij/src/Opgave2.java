import java.util.Scanner;

public class Opgave2 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Indtast et tal: ");
        int inputInt = sc.nextInt();
        String result = "";
        if (inputInt > 0) {
             result = "positiv";
        } else if (inputInt < 0) {
            result = "negativ";
        } else {
            result = "nul";
        }
        System.out.println(result);
    }
}
