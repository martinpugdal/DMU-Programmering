package opgave3;

import java.util.Set;
import java.util.TreeSet;

public class Skole {

    String navn;
    Set<Studerende> studerende = new TreeSet<>(new StuderendeComparator());

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

    public Set<Studerende> getStuderende() {
        return this.studerende;
    }

    public String toString() {
        return navn;
    }
}
