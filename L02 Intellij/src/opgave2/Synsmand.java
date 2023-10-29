package opgave2;

public class Synsmand extends Mekaniker {

    private final int synUdført;

    public Synsmand(String navn, String adresse, int svendeprøve, double timeløn, int synUdført) {
        super(navn, adresse, svendeprøve, timeløn);
        this.synUdført = synUdført;
    }

    @Override
    public double beregnLoen() {
        return super.beregnLoen() + (29 * synUdført);
    }
}
