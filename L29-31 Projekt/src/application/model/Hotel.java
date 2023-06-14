package application.model;

import java.util.ArrayList;

public class Hotel {
    private String navn;
    private String adresse;
    private String tlfNr;
    private double prisEnkelt;
    private double prisDobbelt;
    private ArrayList<Tillæg> tillæg;
    private ArrayList<Reservation> reservation;

    public Hotel(String navn, String adresse, String tlfNr, double prisEnkelt, double prisDobbelt, ArrayList<Tillæg> tillæg) {
        this.navn = navn;
        this.adresse = adresse;
        this.tlfNr = tlfNr;
        this.prisEnkelt = prisEnkelt;
        this.prisDobbelt = prisDobbelt;
        this.tillæg = tillæg;
    }

    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public double getPrisEnkelt() {
        return prisEnkelt;
    }

    public double getPrisDobbelt() {
        return prisDobbelt;
    }

    public ArrayList<Tillæg> getTillæg() {
        return new ArrayList<>(tillæg);
    }

    public Tillæg createTillæg(String navn, double pris) {
        Tillæg tillæg = new Tillæg(navn, pris);
        this.tillæg.add(tillæg);
        return tillæg;
    }

    @Override
    public String toString() {
        return navn + ", " + adresse + ", " + tlfNr;
    }

    //    public ArrayList<Deltager> getDeltagereVedKonference(Konference konference) {
//        ArrayList<Deltager> deltagere = new ArrayList<>();
//        for (Tilmelding tilmelding : konference.getTilmeldinger()) {
//            if (tilmelding.getReservation().getHotel().equals(this))
//                deltagere.add(tilmelding.getDeltager());
//        }
//
//        return deltagere;
//    }

}
