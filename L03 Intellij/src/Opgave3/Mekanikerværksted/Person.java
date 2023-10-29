package Opgave3.Mekanikerværksted;

import lombok.Getter;

@Getter
public class Person {

    private final String navn;
    private final String adresse;

    public Person(String navn, String adresse) {
        this.navn = navn;
        this.adresse = adresse;
    }

    public String toString() {
        return "Navn: " + navn + ", adresse: " + adresse;
    }
}