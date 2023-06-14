package Application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Kunde {
    private String navn;
    private String mobil;
    private final ArrayList<Bestilling> bestillinger = new ArrayList<>();


    public Kunde(String navn, String telefon) {
        this.navn = navn;
        this.mobil = telefon;
    }

    public String getNavn() {
        return navn;
    }

    public String getTelefon() {
        return mobil;
    }

    public ArrayList<Bestilling> getBestillinger() {
        return new ArrayList<>(bestillinger);
    }

    void addBestilling(Bestilling bestilling) {
        if (!bestillinger.contains(bestilling)) {
            bestillinger.add(bestilling);
        }
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setTelefon(String telefon) {
        this.mobil = telefon;
    }

    @Override
    public String toString() {
        return navn + " (" + mobil + ")";
    }

    public ArrayList<Plads> bestiltePladserTilForestillingPåDag(Forestilling forestilling, LocalDate dato) {
        ArrayList<Plads> pladser = new ArrayList<>();
        for (Bestilling bestilling : bestillinger) {
            if (bestilling.getDato().equals(dato) && bestilling.getForestilling().equals(forestilling)) {
                pladser.addAll(bestilling.getPladser());
            }
        }
        return pladser;
    }
}
