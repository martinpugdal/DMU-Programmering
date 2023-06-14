package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Deltager extends Person {
    private String tlfNr;
    private String adresse;
    private String by;
    private String land;
    private Firma firma;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Deltager(String navn, String tlfNr, String adresse, String by, String land) {
        super(navn);
        this.tlfNr = tlfNr;
        this.adresse = adresse;
        this.by = by;
        this.land = land;
    }

    public void setNavn(String navn) {
        super.setNavn(navn);
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public void setTlfNr(String tlfNr) {
        this.tlfNr = tlfNr;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public void addTilmelding(Tilmelding tilmelding) {
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
        }
    }

    public void removeTilmelding(Tilmelding tilmelding) {
        if (tilmeldinger.contains(tilmelding)) {
            tilmeldinger.remove(tilmelding);
        }
    }

    public Tilmelding tilmedKonference(Konference konference, boolean foredragsholder, LocalDate ankomstDato, LocalDate afrejseDato) {
        Tilmelding tilmelding = new Tilmelding(this, konference, foredragsholder, ankomstDato, afrejseDato);
        return tilmelding;
    }

    public void afmeldTilmedling(Tilmelding tilmelding) {
        if (tilmeldinger.contains(tilmelding)) {
            tilmeldinger.remove(tilmelding);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " " + tlfNr + " " + adresse + " " + by + " " + land;
    }
}
