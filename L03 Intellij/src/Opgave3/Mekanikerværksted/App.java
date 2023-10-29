package Opgave3.Mekanikerværksted;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        Mekaniker m1 = new Mekaniker("Jens", "Hansensvej 2", 2000, 100);
        Mekaniker m2 = new Mekaniker("Bo", "Hansensvej 3", 2000, 100);
        Mekaniker m3 = new Mekaniker("Lars", "Hansensvej 4", 2001, 100);
        Synsmand s1 = new Synsmand("Mikkel", "Jensensvej 20", 2004, 100, 10);
        ArbejdsDreng ab1 = new ArbejdsDreng("Henning", "Rasmussensvej", 100);
        Værkfører v1 = new Værkfører("Jonas", "Hansvej 33", 100, 2003, 1.5);

        ArrayList<Ansat> meki1 = new ArrayList<>();
        meki1.add(m1);
        meki1.add(m2);
        meki1.add(m3);
        meki1.add(s1);
        meki1.add(ab1);
        meki1.add(v1);

        System.out.println("Samlet løn er: " + samletUgeløn(meki1));
    }

    public static double samletUgeløn(ArrayList<Ansat> list) {
        double samletLøn = 0;
        for (Ansat ansat : list) {
            samletLøn += ansat.beregnLoen();
        }
        return samletLøn;
    }
}
