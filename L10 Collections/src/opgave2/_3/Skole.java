package opgave2._3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Skole {

    String navn;
    Map<Integer, Studerende> studerende = new HashMap<>();

    public Skole(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void addStuderende(Studerende studerende) {
        this.studerende.put(studerende.getStudieNr(), studerende);
    }

    public void removeStuderende(Studerende studerende) {
        this.studerende.remove(studerende.getStudieNr());
    }

    public double gennemsnit() {
        double sum = 0;
        for (Studerende s : studerende.values()) {
            for (int i : s.getKarakterer()) {
                sum += i;
            }
        }
        return sum / studerende.size();
    }

    public Studerende findStuderende(int studieNr) {
        return studerende.get(studieNr);
    }

    public String toString() {
        return navn;
    }
}
