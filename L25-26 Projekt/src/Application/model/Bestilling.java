package Application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
    private final LocalDate dato;
    private final ArrayList<Plads> pladser = new ArrayList<>();
    private final Kunde kunde;

    private final Forestilling forestilling;

    Bestilling(LocalDate dato, Forestilling forestilling, Kunde kunde) {
        this.forestilling = forestilling;
        this.dato = dato;
        this.kunde = kunde;
        kunde.addBestilling(this);
    }

    public LocalDate getDato() {
        return dato;
    }

    public ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    public void addPlads(Plads plads) {
        if (!pladser.contains(plads)) {
            pladser.add(plads);
        }
    }

    public Kunde getKunde() {
        return kunde;
    }

    public Forestilling getForestilling() {
        return forestilling;
    }

    @Override
    public String toString() {
        return "Forestilling : " + "\n" + forestilling + "\n" + " Dato : " + dato + "\n" + " Kunde : " + kunde + "\n" + " Pladser : " + pladser + "\n";
    }

    public int samletPris() {
        int pris = 0;
        for (Plads plads : pladser) {
            pris += plads.getPris();
        }
        return pris;
    }
}
