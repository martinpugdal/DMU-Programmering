package opgave2._2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Skole {

    String navn;
    Set<Studerende> studerende = new HashSet<>();

    public Skole(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void addStuderende(Studerende studerende) {
        this.studerende.add(studerende);
    }

    public void removeStuderende(Studerende studerende) {
        this.studerende.remove(studerende);
    }

    public double gennemsnit() {
        double sum = 0;
        for (Studerende s : studerende) {
            for (int i : s.getKarakterer()) {
                sum += i;
            }
        }
        return sum / studerende.size();
    }

    public Studerende findStuderende(int studieNr) {
        for (Studerende s : studerende) {
            if (s.getStudieNr() == studieNr) {
                return s;
            }
        }
        return null;
    }

    public String toString() {
        return navn;
    }
}
