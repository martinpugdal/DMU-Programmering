import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Opgave3 {
    /**
     * Returnerer en sorteret ArrayList der indeholder alle
     * customers fra l1 der ikke er i l2
     * Krav: l1 og l2 er sorterede, indeholder ikke dubletter og
     * indeholder ikke tomme pladser
     */

    public static void main(String[] args) {

        ArrayList<Kunde> l1 = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            l1.add(new Kunde());
        }
        Kunde[] l2 = new Kunde[25];
        for (int i = 0; i < l2.length; i++) {
            l2[i] = new Kunde();
        }

        Collections.sort(l1);
        Arrays.sort(l2);

        System.out.println(l1);
        System.out.println(Arrays.toString(l2));
        System.out.println(goodCustomers(l1, l2));
    }

    public static ArrayList<Kunde> goodCustomers(ArrayList<Kunde> l1, Kunde[] l2) {
        ArrayList<Kunde> result = new ArrayList<>();
        int i2 = 0;

        while (!l1.isEmpty() && i2 < l2.length) {
            if (l1.get(0).compareTo(l2[i2]) != 0) {
                result.add(l1.get(0));
            } else {
                i2++;
            }
            l1.remove(0);
        }

        return result;
    }
}
