package application.controller;

import application.model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Deltager createDeltager(String navn, String tlfNr, String adresse, String by, String land) {
        Deltager deltager = new Deltager(navn, tlfNr, adresse, by, land);
        Storage.addDeltager(deltager);
        return deltager;
    }

    public static Deltager createDeltager(String navn, String tlfNr, String adresse, String by, String land, Firma firma) {
        Deltager deltager = new Deltager(navn, tlfNr, adresse, by, land);
        deltager.setFirma(firma);
        Storage.addDeltager(deltager);
        return deltager;
    }

    public static void deleteDeltager(Deltager deltager) {
        Storage.removeDeltager(deltager);
    }

    public static void updateDeltager(Deltager deltager, String navn, String tlfNr, String adresse, String by, String land) {
        deltager.setNavn(navn);
        deltager.setTlfNr(tlfNr);
        deltager.setAdresse(adresse);
        deltager.setBy(by);
        deltager.setLand(land);
    }

    public static void updateDeltager(Deltager deltager, String navn, String tlfNr, String adresse, String by, String land, Firma firma) {
        deltager.setNavn(navn);
        deltager.setTlfNr(tlfNr);
        deltager.setAdresse(adresse);
        deltager.setBy(by);
        deltager.setLand(land);
        deltager.setFirma(firma);
    }

    public static ArrayList<Deltager> getDeltagere() {
        return Storage.getDeltagere();
    }

    // -----------------------------------------------------------------------------------------

    public static Konference createKonference(String navn, LocalDate startDato, LocalDate slutDato, String adresse, String land, String by, double pris) {
        Konference konference = new Konference(navn, startDato, slutDato, adresse, land, by, pris);
        Storage.addKonference(konference);
        return konference;
    }

    public static void deleteKonference(Konference konference) {
        Storage.removeKonference(konference);
    }

    public static void updateKonference(Konference konference, String navn, LocalDate startDato, LocalDate slutDato, String adresse, String land, String by, double pris) {
        konference.setNavn(navn);
        konference.setStartDato(startDato);
        konference.setSlutDato(slutDato);
        konference.setAdresse(adresse);
        konference.setLand(land);
        konference.setBy(by);
        konference.setPris(pris);
    }

    public static ArrayList<Konference> getKonferencer() {
        return Storage.getKonferencer();
    }

    // -----------------------------------------------------------------------------------------

    public static Tilmelding createTilmelding(Deltager deltager, Konference konference, boolean foredragsholder, LocalDate ankomstDato, LocalDate afrejseDato) {
        Tilmelding tilmelding = new Tilmelding(deltager, konference, foredragsholder, ankomstDato, afrejseDato);
        return tilmelding;
    }

    public static Tilmelding updateTilmelding(Tilmelding tilmelding, boolean foredragsholder, LocalDate ankomstDato, LocalDate afrejseDato) {
        tilmelding.setFordragsholder(foredragsholder);
        tilmelding.setAnkomstDato(ankomstDato);
        tilmelding.setAfrejseDato(afrejseDato);
        return tilmelding;
    }

    public static void deleteTilmelding(Deltager deltager, Tilmelding tilmelding) {
        deltager.removeTilmelding(tilmelding);
    }

    // -----------------------------------------------------------------------------------------

    public static Hotel createHotel(String navn, String adresse, String tlfNr, double prisEnkelt, double prisDobbelt, ArrayList<Tillæg> tillæg) {
        Hotel hotel = new Hotel(navn, adresse, tlfNr, prisEnkelt, prisDobbelt, tillæg);
        Storage.addHotel(hotel);
        return hotel;
    }

    public static void deleteHotel(Hotel hotel) {
        Storage.removeHotel(hotel);
    }

    public static ArrayList<Hotel> getHoteller() {
        return Storage.getHoteller();
    }

    // -----------------------------------------------------------------------------------------

    public static Firma createFirma(String navn, String cvr, String tlfNr) {
        Firma firma = new Firma(navn, cvr, tlfNr);
        Storage.addFirma(firma);
        return firma;
    }

    public static void deleteFirma(Firma firma) {
        Storage.removeFirma(firma);
    }

    public static ArrayList<Firma> getFirmaer() {
        return Storage.getFirmaer();
    }
}
