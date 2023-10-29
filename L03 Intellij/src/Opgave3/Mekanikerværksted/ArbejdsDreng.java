package Opgave3.Mekanikerværksted;

public class ArbejdsDreng extends Ansat {

    public ArbejdsDreng(String navn, String adresse, double timeLoen) {
        super(navn, adresse, timeLoen);
    }

    @Override
    public double beregnLoen() {
        return getTimeLoen() * 25;
    }
}
