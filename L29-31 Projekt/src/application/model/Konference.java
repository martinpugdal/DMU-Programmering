package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;
    private String adresse;
    private String land;
    private String by;
    private double pris;
    private ArrayList<Hotel> hoteller;
    private ArrayList<Aktivitet> aktiviteter;
    private ArrayList<Tilmelding> tilmeldinger;

    public Konference(String navn, LocalDate startDato, LocalDate slutDato, String adresse, String land, String by, double pris) {
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.adresse = adresse;
        this.land = land;
        this.by = by;
        this.pris = pris;
        this.aktiviteter = new ArrayList<>();
        this.hoteller = new ArrayList<>();
        this.tilmeldinger = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public ArrayList<Aktivitet> getAktiviteter() {
        return new ArrayList<>(aktiviteter);
    }

    public Aktivitet createAktivitet(String navn, String by, LocalDate dato, double pris, boolean frokost) {
        Aktivitet aktivitet = new Aktivitet(navn, by, dato, pris, frokost);
        aktiviteter.add(aktivitet);
        return aktivitet;
    }

    public ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }

    public void addHotel(Hotel hotel) {
        hoteller.add(hotel);
    }

    public void removeHotel(Hotel hotel) {
        if (hoteller.contains(hotel)) hoteller.remove(hotel);
    }

    void addTilmedling(Tilmelding tilmelding) {
        tilmeldinger.add(tilmelding);
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<Tilmelding>(tilmeldinger);
    }

    public ArrayList<Deltager> getDeltagere() {
        ArrayList<Deltager> deltagere = new ArrayList<>();
        for (Tilmelding tilmelding : tilmeldinger) {
            deltagere.add(tilmelding.getDeltager());
        }
        return deltagere;
    }

    public ArrayList<Ledsager> getLedsagere() {
        ArrayList<Ledsager> ledsagere = new ArrayList<>();
        for (Tilmelding tilmelding : tilmeldinger) {
            if (tilmelding.ledsagerNotEmpty()) {
                ledsagere.add(tilmelding.getLedsager());
            }
        }
        return ledsagere;
    }


    public ArrayList<Deltager> getDeltagereVedHotel(Hotel hotel) {
        ArrayList<Deltager> deltagere = new ArrayList<>();
        for (Tilmelding tilmelding : tilmeldinger) {
            Reservation reservation = tilmelding.getReservation();
            if (reservation != null && reservation.getHotel() != null && tilmelding.getReservation().getHotel().equals(hotel))
                deltagere.add(tilmelding.getDeltager());
        }

        return deltagere;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    public String toString() {
        return navn + ", " + by;
    }
}
