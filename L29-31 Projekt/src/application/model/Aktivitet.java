package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Aktivitet {
    private String navn;
    private String by;
    private LocalDate dato;
    private double pris;
    private boolean frokost;
    private ArrayList<Ledsager> ledsagere = new ArrayList<>();

    Aktivitet(String navn, String by, LocalDate dato, double pris, boolean frokost) {
        this.navn = navn;
        this.by = by;
        this.dato = dato;
        this.pris = pris;
        this.frokost = frokost;
    }

    @Override
    public String toString() {
        return navn + " " + by + " " + dato + " " + pris + " " + frokost;
    }

    public String getNavn() {
        return navn;
    }

    public String getBy() {
        return by;
    }

    public LocalDate getDato() {
        return dato;
    }

    public double getPris() {
        return pris;
    }

    public boolean isFrokost() {
        return frokost;
    }

    public ArrayList<Ledsager> getLedsagere() {
        return new ArrayList<>(ledsagere);
    }

    public void addLedsager(Ledsager ledsager) {
        if (!ledsagere.contains(ledsager)) {
            ledsagere.add(ledsager);
            ledsager.addAktivitet(this);
        }
    }

    public void removeLedsager(Ledsager ledsager) {
        if (ledsagere.contains(ledsager)) {
            ledsagere.remove(ledsager);
            ledsager.removeAktivitet(this);
        }
    }
}
