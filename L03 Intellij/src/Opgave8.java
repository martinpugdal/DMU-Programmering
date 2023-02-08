import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Opgave8 {
    public static void main(String [] args) {
        System.out.println(getSeason(1,12));
        System.out.println(getSeason(2,31));
        System.out.println(getSeason(3,17));
        System.out.println(getSeason(4,22));
        System.out.println(getSeason(5,20));
        System.out.println(getSeason(6,21));
        System.out.println(getSeason(7,3));
        System.out.println(getSeason(8,1));
        System.out.println(getSeason(9,30));
        System.out.println(getSeason(10,16));
        System.out.println(getSeason(11,10));
        System.out.println(getSeason(12,23));
    }

    private static String getSeason(int month, int day) {
        ArrayList<String> seasons = new ArrayList<>(Arrays.asList("Vinter", "Forår", "Sommer", "Efterår"));
        int s = 0;
        if (month % 3 == 0 && day >= 21) {s++;}
        if (month <= 3 && month >= 1) {
            return seasons.get((s)%4);
        }
        else if (month <= 6 && month >= 4) {
            return seasons.get((1+s)%4);
        }
        else if (month <= 9 && month >= 7) {
            return seasons.get((2+s)%4);
        }
        else {
            return seasons.get((3+s)%4);
        }
    }
}
