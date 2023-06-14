import java.util.ArrayList;
import java.util.Arrays;

public class Opgave2 {
    /**
     * Returnerer et sorteret array der indeholder alle
     * elementer l1 og l2 har til fælles
     * Krav: l1 og l2 er sorterede, indeholder ikke dubletter og
     * indeholder ikke tomme pladser
     */
    public static void main(String[] args) {

        int[] l1 = {2, 4, 6, 8, 10, 12, 14};
        int[] l2 = {1, 2, 4, 5, 6, 9, 12, 17};



        int[] l3 = fællesTal(l1, l2);
        System.out.println(Arrays.toString(l3));
    }

    public static int[] fællesTal(int[] l1, int[] l2) {
        ArrayList<Integer> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        // flet sålænge der er noget i begge lister
        while (i1 < l1.length && i2 < l2.length) {
            if (l1[i1] == l2[i2]) {
                // s1's første tal er mindst
                result.add(l1[i1]);
                i1++;
                i2++;
            } else if (l1[i1] < l2[i2]) {
                // s1's første tal er mindst
                i1++;
            } else {
                // s2's første tal er mindst
                i2++;
            }
        }
        // konverter til array
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}
