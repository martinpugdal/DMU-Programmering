package opgave2._2;

import java.util.ArrayList;
import java.util.List;

public class Studerende {

    private int studieNr;
    private String navn;
    private final List<Integer> karakterer = new ArrayList<>();

    public Studerende(String navn, int studieNr) {
        this.navn = navn;
        this.studieNr = studieNr;
    }

    public int getStudieNr() {
        return studieNr;
    }

    public String getNavn() {
        return navn;
    }

    public List<Integer> getKarakterer() {
        return karakterer;
    }

    public void setStudieNr(int studieNr) {
        this.studieNr = studieNr;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void addKarakter(int karakter) {
        karakterer.add(karakter);
    }
    public String toString() {
        return navn;
    }
}
