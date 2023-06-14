package gui;

import Application.controller.Controller;
import Application.model.PladsType;
import javafx.application.Application;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        initStorage();
        Application.launch(gui.class);
    }

    public static void initStorage() {
        Controller.createKunde("Anders Hansen", "11223344");
        Controller.createKunde("Peter Jensen", "12345678");
        Controller.createKunde("Niels Madsen", "12341234");

        Controller.createForestilling("Evita", LocalDate.of(2023, 8, 10), LocalDate.of(2023, 8, 20));
        Controller.createForestilling("Lykke Per", LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 10));
        Controller.createForestilling("Chess", LocalDate.of(2023, 8, 21), LocalDate.of(2023, 9, 30));


        for (int række = 1; række <= 15; række++) {
            for (int nummer = 1; nummer <= 20; nummer++) {
                int pris;
                int gulPris = 500;
                int grønPris = 450;
                int blåPris = 400;

                if (række <= 5) {
                    if (nummer >= 3 && nummer <= 18) {
                        pris = gulPris;
                    } else {
                        pris = grønPris;
                    }
                } else if (række <= 10) {
                    if (nummer >= 3 && nummer <= 18) {
                        pris = grønPris;
                    } else {
                        pris = blåPris;
                    }
                } else {
                    pris = blåPris;
                }

                PladsType pladsType = PladsType.STANDARD;
                if ((række == 10 || række == 11) && (nummer >= 8 && nummer <= 12)) {
                    if (række == 10) {
                        pladsType = PladsType.KØRESTOL;
                    } else {
                        pladsType = PladsType.EKSTRABEN;
                    }
                }
                Controller.createPlads(række, nummer, pris, pladsType);
            }
        }
    }
}
