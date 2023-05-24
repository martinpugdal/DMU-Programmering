import java.util.ArrayList;
import java.util.Random;

public class Opgave7 {
    public static void main(String[] args) {
        ArrayList<Kunde> kunder = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            Kunde kunde = new Kunde(generateRandomName(4));
            kunder.add(kunde);
        }
        kunder.sort(Kunde::compareTo);
        System.out.println(kunder);
        indsætKunde(kunder, new Kunde(generateRandomName(2)));
    }

    private static String generateRandomName(int length) {
        Random r = new Random();
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = (char) (r.nextInt(26) + 'a');
            name.append(c);
        }
        return name.toString();
    }

    public static void indsætKunde(ArrayList<Kunde> kunder, Kunde kunde) {
        int index = 0;
        for (Kunde k : kunder) {
            if (k.getNavn().compareTo(kunde.getNavn()) > 0) {
                break;
            }
            index++;
        }
        kunder.add(index, kunde);
        System.out.println(kunder);
    }
}
