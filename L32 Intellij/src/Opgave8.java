import java.util.Arrays;
import java.util.Random;

public class Opgave8 {
    public static void main(String[] args) {
        Kunde[] kunder = new Kunde[17];
        for (int i = 0; i < 16; i++) {
            Kunde kunde = new Kunde(generateRandomName(4));
            kunder[i] = kunde;
        }
        Arrays.sort(kunder, 0, 16);
        System.out.println(Arrays.toString(kunder));
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

    public static void indsætKunde(Kunde[] kunder, Kunde kunde) {
        int index = kunder.length - 1;
        for (int i = kunder.length - 1; i >= 0; i--) {
            if (kunder[i] == null) {
                kunder[index] = kunde;
                break;
            }
        }
        for (int i = kunder.length - 1; i >= 0; i--) {
            if (kunder[i] != null && kunder[i].getNavn().compareTo(kunde.getNavn()) < 0) {
                kunder[i + 1] = kunde;
                break;
            }
        }
        System.out.println(Arrays.toString(kunder));
    }

}
