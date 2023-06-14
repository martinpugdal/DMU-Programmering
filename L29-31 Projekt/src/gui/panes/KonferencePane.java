package gui.panes;

import application.controller.Controller;
import application.model.Aktivitet;
import application.model.Deltager;
import application.model.Konference;
import application.model.Ledsager;
import gui.windows.AktivitetWindow;
import gui.windows.HotelWindow;
import gui.windows.KonferenceWindow;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;


public class KonferencePane extends GridPane {
    private ListView<Konference> lvwKonferencer;
    private ListView<Deltager> lvwDeltagere;

    public KonferencePane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        //----------------------------------------------------------------------

        Label lblKonference = new Label("Konferencer");
        this.add(lblKonference, 0, 0);

        lvwKonferencer = new ListView<>();
        this.add(lvwKonferencer, 0, 1);
        lvwKonferencer.setPrefHeight(200);
        lvwKonferencer.setPrefWidth(200);
        lvwKonferencer.getItems().setAll(Controller.getKonferencer());


        Button btnSeAktiviteter = new Button("Se aktiviteter");
        this.add(btnSeAktiviteter, 0, 2);
        btnSeAktiviteter.setOnAction(event -> seAktiviteterAction());

        //----------------------------------------------------------------------

        Label lblDeltager = new Label("Deltagere");
        this.add(lblDeltager, 1, 0);

        lvwDeltagere = new ListView<>();
        this.add(lvwDeltagere, 1, 1);
        lvwDeltagere.setPrefWidth(200);
        lvwDeltagere.setPrefHeight(200);


        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 3, 5, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_LEFT);

        Button btnOpret = new Button("Opret");
        hbxButtons.getChildren().add(btnOpret);
        btnOpret.setOnAction(event -> opretAction(btnOpret));

        Button btnSlet = new Button("Slet");
        hbxButtons.getChildren().add(btnSlet);
        btnSlet.setOnAction(event -> sletAction());

        Button btnOpdater = new Button("Opdater");
        hbxButtons.getChildren().add(btnOpdater);
        btnOpdater.setOnAction(event -> opretAction(btnOpdater));

        Button btnSeHoteller = new Button("Hoteller");
        hbxButtons.getChildren().add(btnSeHoteller);
        btnSeHoteller.setOnAction(event -> seHotellerAction());

        ChangeListener<Konference> listener = (ov, oldKonference, newKonference) -> updateDeltagere();
        lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(listener);

        if (lvwKonferencer.getItems().size() > 0) {
            lvwKonferencer.getSelectionModel().select(0);
        }


    }

    public void updateDeltagere() {
        Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
        if (konference != null) {
            lvwDeltagere.getItems().setAll(konference.getDeltagere());
        }
    }

    public void opretAction(Button button) {
        Konference konference = null;
        if (button.getText().equals("Opdater")) {
            konference = lvwKonferencer.getSelectionModel().getSelectedItem();
        }
        if (konference != null) {
            KonferenceWindow dia = new KonferenceWindow(konference);
            dia.showAndWait();
        } else {
            KonferenceWindow dia = new KonferenceWindow();
            dia.showAndWait();
        }

        lvwKonferencer.getItems().setAll(Controller.getKonferencer());

        if (konference != null) {
            int index = lvwKonferencer.getItems().indexOf(konference);
            lvwKonferencer.getSelectionModel().select(index);
        } else {
            int lastIndex = lvwKonferencer.getItems().size() - 1;
            lvwKonferencer.getSelectionModel().select(lastIndex);
        }
    }

    public void sletAction() {
        Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
        if (konference != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Bekræft sletning");
            alert.setHeaderText("Slet konference");
            alert.setContentText("Er du sikker på, at du vil slette denne konference?");

            if (alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
                Controller.deleteKonference(konference);
                lvwKonferencer.getItems().remove(konference);
                lvwDeltagere.getItems().clear();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ingen konference valgt");
            alert.setHeaderText("Fejl");
            alert.setContentText("Væl en konference fra listen for at slette");
            alert.showAndWait();
        }
    }

    public void seAktiviteterAction() {
        Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
        if (konference != null) {
            ArrayList<Ledsager> ledsagere = konference.getLedsagere();
            ArrayList<Aktivitet> aktiviteter = konference.getAktiviteter();
            AktivitetWindow aktivitetWindow = new AktivitetWindow(ledsagere, aktiviteter);
            aktivitetWindow.showAndWait();
        }
    }

    public void seHotellerAction() {
        Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
        if (konference != null) {
            HotelWindow hotelWindow = new HotelWindow(konference);
            hotelWindow.showAndWait();
        }
    }
}
