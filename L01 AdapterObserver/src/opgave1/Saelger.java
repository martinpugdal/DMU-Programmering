package opgave1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Saelger implements Observer {

    private final String navn;
    private final List<BogTitel> bogTitler = new ArrayList<>();

    public Saelger(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + navn;
    }

    @Override
    public void update(Subject o) {
        if (o instanceof BogTitel bogTitel) {
            bogTitler.add(bogTitel);
            System.out.println("Bøger købt af andre kunder: (" + bogTitel.getTitel() + ")");
            Set<Subject> hasSeen = new HashSet<>();
            hasSeen.add(bogTitel);
            List<Kunde> kunder = bogTitel.getKunder();
            for (Kunde kunde : kunder) {
                for (BogTitel bogTitel1 : kunde.getBogTitelList()) {
                    if (!hasSeen.contains(bogTitel1)) {
                        hasSeen.add(bogTitel1);
                        System.out.println(" - " + bogTitel1.getTitel());
                    }
                }
            }
        } else {
            System.out.println("Fejl: " + o + " er ikke en bogtitel");
        }
    }
}
