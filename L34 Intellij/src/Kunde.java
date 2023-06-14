import lombok.Getter;

import java.util.Random;

public class Kunde implements Comparable<Kunde> {
    @Getter
    private String navn;

    public Kunde(String navn) {
        this.navn = navn;
    }

    public Kunde() {
        generateRandomName(2);
    }

    private void generateRandomName(int length) {
        Random r = new Random();
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = (char) (r.nextInt(26) + 'a');
            name.append(c);
        }
        this.navn = name.toString();
    }


    @Override
    public String toString() {
        return navn;
    }


    //    @Override // its need only to Opgave8.
    public int compareTo(Kunde o) {
        return navn.compareTo(o.getNavn());
    }
}
