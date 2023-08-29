package opgave2;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        ArrayList<Mekaniker> mekanikere = new ArrayList<>();
        mekanikere.add(new Mekaniker("Mekaniker 1", "Adresse 1", 1, 100));
        mekanikere.add(new Mekaniker("Mekaniker 2", "Adresse 2", 2, 200));
        mekanikere.add(new Mekaniker("Mekaniker 3", "Adresse 3", 3, 300));
        mekanikere.add(new Mekaniker("Mekaniker 4", "Adresse 4", 4, 400));

        mekanikere.add(new Værkfører("Værkfører 1", "Adresse 1", 1, 100, 1, 1.1));
        mekanikere.add(new Værkfører("Værkfører 2", "Adresse 2", 2, 200, 2, 1.2));
        mekanikere.add(new Værkfører("Værkfører 3", "Adresse 3", 3, 300, 3, 1.3));

        mekanikere.add(new Synsmand("Synsmand 1", "Adresse 1", 1, 100, 2));
        mekanikere.add(new Synsmand("Synsmand 2", "Adresse 2", 2, 200, 5));
        mekanikere.add(new Synsmand("Synsmand 3", "Adresse 3", 3, 300, 12));

        for (Mekaniker m : mekanikere) {
            System.out.println(m);
            System.out.println("Ugeløn: " + m.beregnLoen());
        }

        System.out.println("Samlet løn: " + samletLoen(mekanikere));
    }

    /**
     * Beregner summen af ugelønnen for alle i listen
     **/
    public static double samletLoen(ArrayList<Mekaniker> list){
        double sum = 0;
        for (Mekaniker m : list) {
            sum += m.beregnLoen();
        }
        return sum;
    };
}
