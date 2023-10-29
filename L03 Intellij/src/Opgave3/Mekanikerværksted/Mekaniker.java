package Opgave3.Mekanikerværksted;

import lombok.Getter;

@Getter
public class Mekaniker extends Ansat {

    private final int svendeproeve;

    public Mekaniker(String navn, String adresse, int svendeproeve, double timeLoen) {
        super(navn, adresse, timeLoen);
        this.svendeproeve = svendeproeve;
    }

    @Override
    public double beregnLoen() {
        return getTimeLoen() * 37;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
