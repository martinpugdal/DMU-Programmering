package gui;

import application.controller.Controller;
import application.model.Hotel;
import application.model.Konference;
import application.model.Tillæg;
import application.model.Tilmelding;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        initStorage();
        Gui.launch(Gui.class);
    }

    public static void initStorage() {
        // create konference
        Konference konference = Controller.createKonference(
                "Hav og himmel",
                LocalDate.of(2023, 5, 18),
                LocalDate.of(2023, 5, 20),
                "Odsense Universitet",
                "Denmark",
                "Odsense",
                1500
        );

        // create deltagere
        Controller.createDeltager(
                "Finn Madsen",
                "12121212",
                "Malmøvej 1",
                "Aarhus",
                "Denmark"
        );
        Controller.createDeltager(
                "Niels Petersen",
                "52525252",
                "Malmøvej 3",
                "Aarhus",
                "Denmark"
        );
        Controller.createDeltager(
                "Peter Sommer",
                "34343434",
                "Malmøvej 7",
                "Aarhus",
                "Denmark"
        );
        Controller.createDeltager(
                "Lone Jensen",
                "78787878",
                "Malmøvej 9",
                "Aarhus",
                "Denmark"
        );

        // create akitiviteter
        konference.createAktivitet(
                "Byrundtur",
                "Odense",
                LocalDate.of(2023, 5, 18),
                125,
                true
        );
        konference.createAktivitet(
                "Egeskov",
                "Ingen by?",
                LocalDate.of(2023, 5, 19),
                75,
                false
        );
        konference.createAktivitet(
                "Trapholt Museum",
                "Kolding",
                LocalDate.of(2023, 5, 20),
                200,
                true
        );

        // Create hoteller
        Hotel hotel = Controller.createHotel(
                "Den hvide svane",
                "Havnegade 1",
                "12312312",
                1050,
                1250,
                new ArrayList<Tillæg>(
                        Arrays.asList(
                                new Tillæg("WIFI", 50)
                        )
                )
        );
        Hotel hotel1 = Controller.createHotel(
                "Høtel Phønix",
                "Havnegade 3",
                "12341234",
                700,
                800,
                new ArrayList<Tillæg>(
                        Arrays.asList(
                                new Tillæg("Bad", 200),
                                new Tillæg("WIFI", 75)
                        )
                )
        );
        Hotel hotel2 = Controller.createHotel(
                "Pension Tusindfryd",
                "Havnegade 5",
                "43214321",
                500,
                600,
                new ArrayList<Tillæg>(
                        Arrays.asList(
                                new Tillæg("Morgenmad", 100)
                        )
                )
        );

        konference.addHotel(hotel); // Den hvide svane
        konference.addHotel(hotel1); // Høtel Phønix
        konference.addHotel(hotel2); // Pension Tusindfryd

        //create tilmeldinger
        Tilmelding tilmelding = Controller.createTilmelding(
                Controller.getDeltagere().get(0),
                konference,
                false,
                LocalDate.of(2023, 5, 18),
                LocalDate.of(2023, 5, 20)
        );

        Tilmelding tilmelding1 = Controller.createTilmelding(
                Controller.getDeltagere().get(1),
                konference,
                false,
                LocalDate.of(2023, 5, 18),
                LocalDate.of(2023, 5, 20)
        );
        tilmelding1.opretReservation(hotel); // Den hvide svane

        Tilmelding tilmelding2 = Controller.createTilmelding(
                Controller.getDeltagere().get(2),
                konference,
                false,
                LocalDate.of(2023, 5, 18),
                LocalDate.of(2023, 5, 20)
        );
        tilmelding2.createLedsager("Mie Sommer", tilmelding2.getDeltager());
        tilmelding2.opretReservation(hotel, hotel.getTillæg()); // Den hvide svane
        tilmelding2.getLedsager().addAktivitet(konference.getAktiviteter().get(1)); // Egeskov
        tilmelding2.getLedsager().addAktivitet(konference.getAktiviteter().get(2)); // Trapholt

        Tilmelding tilmelding3 = Controller.createTilmelding(
                Controller.getDeltagere().get(3),
                konference,
                true,
                LocalDate.of(2023, 5, 18),
                LocalDate.of(2023, 5, 20)
        );
        tilmelding3.createLedsager("Jan Madsen", tilmelding3.getDeltager());
        tilmelding3.opretReservation(hotel, hotel.getTillæg()); // Den hvide svane
        tilmelding3.getLedsager().addAktivitet(konference.getAktiviteter().get(1)); // Egeskov
        tilmelding3.getLedsager().addAktivitet(konference.getAktiviteter().get(0)); // Byrundtur

        // craete firmaer
        Controller.createFirma(
                "Firma A/S",
                "12345678",
                "12312312"
        );
        Controller.createFirma(
                "Firma ApS",
                "87654321",
                "12341234"
        );
        Controller.createFirma(
                "Tom ApS",
                "12345678",
                "43214321"
        );
    }
}
