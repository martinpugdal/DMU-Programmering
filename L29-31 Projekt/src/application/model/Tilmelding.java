package application.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Tilmelding {
    private Deltager deltager;
    private Konference konference;
    private boolean fordragsholder;
    private LocalDate ankomstDato;
    private LocalDate afrejseDato;
    private Reservation reservation = null;
    private Ledsager ledsager = null;

    public Tilmelding(Deltager deltager, Konference konference, boolean fordragsholder, LocalDate ankomstDato, LocalDate afrejseDato) {
        this.deltager = deltager;
        this.konference = konference;
        this.fordragsholder = fordragsholder;
        this.ankomstDato = ankomstDato;
        this.afrejseDato = afrejseDato;
        konference.addTilmedling(this);
        deltager.addTilmelding(this);
    }

    public Deltager getDeltager() {
        return deltager;
    }

    public void opdaterTilmelding(boolean fordragsholder, LocalDate ankomstDato, LocalDate afrejseDato) {
        this.fordragsholder = fordragsholder;
        this.ankomstDato = ankomstDato;
        this.afrejseDato = afrejseDato;
    }

    public void fjernLedsager() {
        ledsager = null;
    }

    public Ledsager createLedsager(String navn, Deltager deltager) {
        if (!ledsagerNotEmpty()) {
            ledsager = new Ledsager(navn, deltager);
        } else if (!ledsager.getNavn().equals(navn)) {
            ledsager = new Ledsager(navn, deltager);
        }
        return ledsager;
    }

    public void opretReservation(Hotel hotel, ArrayList<Tillæg> valgteTillæg) {
        if (konference.getHoteller().contains(hotel) && hotel.getTillæg().containsAll(valgteTillæg)) {
            reservation = new Reservation(hotel, valgteTillæg, ledsagerNotEmpty());
        }
    }

    public void opretReservation(Hotel hotel) {
        if (konference.getHoteller().contains(hotel)) {
            reservation = new Reservation(hotel, ledsagerNotEmpty());
        }
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void fjernReservation() {
        reservation = null;
    }

    public double beregnPris() {
        double pris = 0;
        if (!fordragsholder) {
            pris += konference.getPris() * (ankomstDato.datesUntil(afrejseDato).count() + 1);
        }
        if (reservation != null) {
            pris += reservation.beregnPrisReservation() * ankomstDato.datesUntil(afrejseDato).count();
        }
        if (ledsager != null) {
            for (Aktivitet aktivitet : ledsager.getAktiviteter()) {
                pris += aktivitet.getPris();
            }
        }

        return pris;
    }

    public Ledsager getLedsager() {
        return ledsager;
    }

    public boolean ledsagerNotEmpty() {
        return this.ledsager != null;
    }

    public Konference getKonference() {
        return konference;
    }

    public boolean isFordragsholder() {
        return fordragsholder;
    }

    public void setFordragsholder(boolean fordragsholder) {
        this.fordragsholder = fordragsholder;
    }

    public LocalDate getAnkomstDato() {
        return ankomstDato;
    }

    public void setAnkomstDato(LocalDate ankomstDato) {
        this.ankomstDato = ankomstDato;
    }

    public LocalDate getAfrejseDato() {
        return afrejseDato;
    }

    public void setAfrejseDato(LocalDate afrejseDato) {
        this.afrejseDato = afrejseDato;
    }

    @Override
    public String toString() {
        return deltager.getNavn() + ", " + konference.toString() + ", " + ankomstDato.format(DateTimeFormatter.ofPattern("dd-MM")) + " til " + afrejseDato.format(DateTimeFormatter.ofPattern("dd-MM")) + ", " + beregnPris() + " kr.";
    }
}
