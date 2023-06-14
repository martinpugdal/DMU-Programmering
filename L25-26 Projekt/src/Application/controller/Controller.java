package Application.controller;

import Application.model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    //    ---------------- Forestilling ----------------
    public static Forestilling createForestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        Forestilling forestilling = new Forestilling(navn, startDato, slutDato);
        Storage.addForestilling(forestilling);

        return forestilling;
    }

    public static ArrayList<Forestilling> getForestillinger() {
        return Storage.getForestillinger();
    }

    //    ---------------- Kunde ----------------
    public static Kunde createKunde(String navn, String telefon) {
        Kunde kunde = new Kunde(navn, telefon);
        Storage.addKunde(kunde);

        return kunde;
    }

    public static ArrayList<Kunde> getKunder() {
        return Storage.getKunder();
    }

    //    ---------------- Plads ----------------
    public static Plads createPlads(int række, int nummer, int pris, PladsType pladsType) {
        Plads plads = new Plads(række, nummer, pris, pladsType);
        Storage.addPlads(plads);

        return plads;
    }

    public static ArrayList<Plads> getPladser() {
        return Storage.getPladser();
    }

    public static Bestilling opretBestillingMedPladser(Forestilling forestilling, Kunde kunde, LocalDate dato, ArrayList<Plads> pladser) {
        Bestilling bestilling = null;
        Boolean allePladserLedige = true;
        if (!dato.isBefore(forestilling.getStartDato()) || !dato.isAfter(forestilling.getSlutDato())) {
            for (Plads plads : pladser) {
                if (!forestilling.erPladsLedig(plads.getRække(), plads.getNr(), dato)) {
                    allePladserLedige = false;
                }
            }
            if (allePladserLedige) {
                bestilling = forestilling.createBestilling(dato, kunde);
                for (Plads plads : pladser) {
                    bestilling.addPlads(plads);
                }
            }
        }

        return bestilling;
    }

    public static String bestillingToString(Bestilling bestilling) {
        return bestilling.toString();
    }
}
