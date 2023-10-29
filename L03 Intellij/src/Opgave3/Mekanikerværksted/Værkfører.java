package Opgave3.Mekanikerværksted;

import lombok.Getter;

@Getter
public class Værkfører extends Ansat {

    private final int udnævnelse;
    private final double tillæg;

    public Værkfører(String navn, String adresse, double timeLoen, int udnævnelse, double tillæg) {
        super(navn, adresse, timeLoen);
        this.udnævnelse = udnævnelse;
        this.tillæg = tillæg;
    }

    @Override
    public double beregnLoen() {
        return getTimeLoen() * tillæg;
    }
}