import java.util.Scanner;

public class Opgave6 {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Indtast et tal: ");
        System.out.println(sign(sc.nextInt()));
    }

    private static String sign(int i) {
//        String result = "";
        if (i > 0) {
//            result = "positiv";
            return "positiv";
        } else if (i < 0) {
//            result = "negativ";
            return "negativ";
        } else {
//            result = "nul";
            return "nul";
        }
//        return result;
    }
}
