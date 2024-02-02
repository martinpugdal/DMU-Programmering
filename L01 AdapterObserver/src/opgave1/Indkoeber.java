package opgave1;

public class Indkoeber implements Observer {

    private final String navn;

    public Indkoeber(String navn) {
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
        if (o instanceof BogTitel) {
            BogTitel bogTitel = (BogTitel) o;
            if (bogTitel.getAntal() < 6) {
                System.out.println(this + " skal bestilles 10 eksemplarer af " + o);
                bogTitel.indkoebTilLager(10);
            }
        } else {
            System.out.println("Fejl: " + o + " er ikke en bogtitel");
        }
    }
}
