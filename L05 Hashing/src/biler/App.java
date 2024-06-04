package biler;

import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {

        Set<Bil> biler = new HashSet<>();

        biler.add(new Bil("EH22333", "Volvo", "Voldsom", "Rød"));
        biler.add(new Bil("EH22333", "Volvo1", "Voldsom", "Gul"));
        biler.add(new Bil("EH22333", "Volvo2", "Voldsom", "Blå"));
        biler.add(new Bil("EH22333", "Volvo2", "Voldsom", "Grå"));
        biler.add(new Bil("EH22333", "Volvo3", "Voldsom", "Grå"));
        biler.add(new Bil("EH22333", "Volvo3", "Voldsom", "Grøn"));
        biler.add(new Bil("EH22333", "Volvo4", "Voldsom", "Grøn"));

        System.out.println(biler);
        System.out.println(biler.size());
    }
}
