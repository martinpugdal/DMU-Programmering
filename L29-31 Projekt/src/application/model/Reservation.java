package application.model;

import java.util.ArrayList;

public class Reservation {
    private Hotel hotel;
    private ArrayList<Tillæg> valgteTilæg = new ArrayList<>();
    private boolean dobbelt;

    Reservation(Hotel hotel, ArrayList<Tillæg> valgteTilæg, boolean dobbelt) {
        this.hotel = hotel;
        this.valgteTilæg = valgteTilæg;
        this.dobbelt = dobbelt;
    }

    Reservation(Hotel hotel, boolean dobbelt) {
        this.hotel = hotel;
        this.dobbelt = dobbelt;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public ArrayList<Tillæg> getValgteTilæg() {
        return valgteTilæg;
    }

    public double beregnPrisReservation() {
        double pris = 0;
        if (this != null) {
            if (dobbelt) {
                pris += hotel.getPrisDobbelt();
            } else {
                pris += hotel.getPrisEnkelt();
            }

            for (Tillæg tillæg : valgteTilæg) {
                pris += tillæg.getPris();
            }
        }
        return pris;
    }
}
