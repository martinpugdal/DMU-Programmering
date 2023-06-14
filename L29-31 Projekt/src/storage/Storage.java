package storage;

import application.model.*;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Deltager> deltagere = new ArrayList<>();
    private static ArrayList<Hotel> hoteller = new ArrayList<>();
    private static ArrayList<Firma> firmaer = new ArrayList<>();
    private static ArrayList<Konference> konferencer = new ArrayList<>();

    public static ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }

    public static void addDeltager(Deltager deltager) {
        deltagere.add(deltager);
    }

    public static void removeDeltager(Deltager deltager) {
        deltagere.remove(deltager);
    }

    // -----------------------------------------------------------------------------------------

    public static ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }

    public static void addHotel(Hotel hotel) {
        hoteller.add(hotel);
    }

    public static void removeHotel(Hotel hotel) {
        hoteller.remove(hotel);
    }

    // -----------------------------------------------------------------------------------------

    public static ArrayList<Firma> getFirmaer() {
        return new ArrayList<>(firmaer);
    }

    public static void addFirma(Firma firma) {
        firmaer.add(firma);
    }

    public static void removeFirma(Firma firma) {
        firmaer.remove(firma);
    }

    // -----------------------------------------------------------------------------------------

    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<>(konferencer);
    }

    public static void addKonference(Konference konference) {
        konferencer.add(konference);
    }

    public static void removeKonference(Konference konference) {
        for (Tilmelding tilmelding : konference.getTilmeldinger()) {
            tilmelding.getDeltager().removeTilmelding(tilmelding);
        }
        konferencer.remove(konference);
    }
}
