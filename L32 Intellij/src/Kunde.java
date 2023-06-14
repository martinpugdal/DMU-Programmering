import lombok.Getter;

public class Kunde implements Comparable<Kunde> {
//public class Kunde {
    @Getter
    private final String navn;

    public Kunde(String navn) {
        this.navn = navn;
    }


    @Override
    public String toString() {
        return navn;
    }


    @Override // its need only to Opgave8.
    public int compareTo(Kunde o) {
        if (o == null) {
            return 1;
        }
        return navn.compareTo(o.getNavn());
    }
}
