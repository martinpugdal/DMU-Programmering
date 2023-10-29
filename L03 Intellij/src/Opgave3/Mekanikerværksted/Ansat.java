package Opgave3.Mekanikerværksted;

import lombok.Getter;

@Getter
public abstract class Ansat extends Person {

    private final double timeLoen;

    public Ansat(String navn, String adresse, double timeLoen) {
        super(navn, adresse);
        this.timeLoen = timeLoen;
    }

    public abstract double beregnLoen();
}
