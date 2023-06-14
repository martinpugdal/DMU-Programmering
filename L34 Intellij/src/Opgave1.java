import java.util.ArrayList;

public class Opgave1 {
    /**
     * Returnerer en sorteret ArrayList der indeholder alle
     * kunder fra både l1 og l2
     * Krav: l1 og l2 er sorterede
     */
    public static void main(String[] args) {
        // make some customers
        ArrayList<Kunde> l1 = new ArrayList<>();
        ArrayList<Kunde> l2 = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            l1.add(new Kunde());
        }

        for (int i = 0; i < 16; i++) {
            l2.add(new Kunde());
        }

        l1.sort(Kunde::compareTo);
        l2.sort(Kunde::compareTo);

        ArrayList<Kunde> l3 = fletAlleKunder(l1, l2);
        System.out.println(l3);
    }

    public static ArrayList<Kunde> fletAlleKunder(ArrayList<Kunde> s1, ArrayList<Kunde> s2) {
        ArrayList<Kunde> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        // flet sålænge der er noget i begge lister
        while (i1 < s1.size() && i2 < s2.size()) {
            if (s1.get(i1).compareTo((s2.get(i2))) <= 0) {
                // s1's første tal er mindst
                result.add(s1.get(i1));
                i1++;
            } else {
                // s2's første tal er mindst
                result.add(s2.get(i2));
                i2++;
            }
        }
        // tøm den liste der ikke er tom
        while (i1 < s1.size()) {
            result.add(s1.get(i1));
            i1++;
        }
        while (i2 < s2.size()) {
            result.add(s2.get(i2));
            i2++;
        }
        return result;
    }
}
