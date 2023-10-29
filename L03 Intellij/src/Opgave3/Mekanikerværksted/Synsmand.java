package Opgave3.Mekanikerværksted;

public class Synsmand extends Mekaniker {

    private final int synUdført;

    public Synsmand(String navn, String adresse, int svendeproeve, double timeløn, int synUdført) {
        super(navn, adresse, svendeproeve, timeløn);
        this.synUdført = synUdført;
    }

    @Override
    public double beregnLoen() {
        return super.beregnLoen() + (29 * synUdført);
    }
}
