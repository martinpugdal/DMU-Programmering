package gui.panes;

import application.controller.Controller;
import application.model.Deltager;
import application.model.Tilmelding;
import gui.windows.DeltagerWindow;
import gui.windows.TilmeldingWindow;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class DeltagerPane extends GridPane {
    private ListView<Deltager> lvwDeltagere;
    private ListView<Tilmelding> lvwTilmeldinger;
    public DeltagerPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        //----------------------------------------------------------------------

        Label lblKonference = new Label("Deltagere");
        this.add(lblKonference, 0, 0);

        lvwDeltagere = new ListView<>();
        this.add(lvwDeltagere, 0, 1);
        lvwDeltagere.setPrefHeight(200);
        lvwDeltagere.setPrefWidth(200);
        lvwDeltagere.getItems().setAll(Controller.getDeltagere());


        //----------------------------------------------------------------------

        Label lblTilmelding = new Label("Tilmeldinger");
        this.add(lblTilmelding, 1, 0);

        lvwTilmeldinger = new ListView<>();
        this.add(lvwTilmeldinger, 1, 1);
        lvwTilmeldinger.setPrefWidth(200);
        lvwTilmeldinger.setPrefHeight(200);


        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 3, 5, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_LEFT);

        Button btnOpret = new Button("Opret deltager");
        hbxButtons.getChildren().add(btnOpret);
        btnOpret.setOnAction(event -> opretAction(btnOpret));

        Button btnSlet = new Button("Slet deltager");
        hbxButtons.getChildren().add(btnSlet);
        btnSlet.setOnAction(event -> sletAction());

        Button btnOpdater = new Button("Opdater deltager");
        hbxButtons.getChildren().add(btnOpdater);
        btnOpdater.setOnAction(event -> opretAction(btnOpdater));

        HBox hbxTilmeldButtons = new HBox(40);
        this.add(hbxTilmeldButtons, 0, 4, 5, 1);
        hbxTilmeldButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxTilmeldButtons.setAlignment(Pos.BASELINE_LEFT);

        Button btnTilmeldKonference = new Button("Tilmeld Konference");
        hbxTilmeldButtons.getChildren().add(btnTilmeldKonference);
        btnTilmeldKonference.setOnAction(event -> tilmeldAction());

        Button btnOpdaterTilmelding = new Button("Opdater tilmelding");
        hbxTilmeldButtons.getChildren().add(btnOpdaterTilmelding);
        btnOpdaterTilmelding.setOnAction(event -> opdaterTilmeldingAction());

        Button btnSletTilmelding = new Button("Slet tilmelding");
        hbxTilmeldButtons.getChildren().add(btnSletTilmelding);
        btnSletTilmelding.setOnAction(event -> sletTilmeldingAction());

        ChangeListener<Deltager> listener = (ov, oldKonference, newKonference) -> updateTilmeldinger();
        lvwDeltagere.getSelectionModel().selectedItemProperty().addListener(listener);

        if (lvwDeltagere.getItems().size() > 0) {
            lvwDeltagere.getSelectionModel().select(0);
        }
    }

    public void updateTilmeldinger() {
        Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
        if (deltager != null) {
            lvwTilmeldinger.getItems().setAll(deltager.getTilmeldinger());
        }
    }

    public void opretAction(Button button) {
        Deltager deltager = null;
        if (button.getText().equals("Opdater")) {
            deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
        }
        if (deltager != null) {
            DeltagerWindow dia = new DeltagerWindow(deltager);
            dia.showAndWait();
        } else {
            DeltagerWindow dia = new DeltagerWindow();
            dia.showAndWait();
        }

        lvwDeltagere.getItems().setAll(Controller.getDeltagere());

        if (deltager != null) {
            int index = lvwDeltagere.getItems().indexOf(deltager);
            lvwDeltagere.getSelectionModel().select(index);
        } else {
            lvwDeltagere.getSelectionModel().selectLast();
        }
    }

    public void tilmeldAction() {
        Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
        TilmeldingWindow dia = new TilmeldingWindow(deltager);
        dia.showAndWait();

        lvwTilmeldinger.getItems().setAll(deltager.getTilmeldinger());
        int index = lvwTilmeldinger.getItems().size()-1;
        lvwTilmeldinger.getSelectionModel().select(index);
    }

    public void opdaterTilmeldingAction() {
        if (lvwTilmeldinger.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ingen tilmelding valgt");
            alert.setHeaderText("Fejl");
            alert.setContentText("Vælg en tilmelding fra listen");
            alert.showAndWait();
        } else {
            Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
            Tilmelding tilmelding = lvwTilmeldinger.getSelectionModel().getSelectedItem();
            TilmeldingWindow dia = new TilmeldingWindow(tilmelding, deltager);
            dia.showAndWait();
        }
    }

    public void sletTilmeldingAction() {
        Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
        Tilmelding tilmelding = lvwTilmeldinger.getSelectionModel().getSelectedItem();
        if (tilmelding != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Bekræft sletning");
            alert.setHeaderText("Slet tilmeldning");
            alert.setContentText("Er du sikker på, at du vil slette denne tilmeldning?");

            if (alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
                Controller.deleteTilmelding(deltager, tilmelding);
                lvwTilmeldinger.getItems().remove(tilmelding);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ingen tilmelding valgt");
            alert.setHeaderText("Fejl");
            alert.setContentText("Vælg en tilmelding fra listen for at slette");
            alert.showAndWait();
        }
    }

    public void sletAction() {
        Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
        if (deltager != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Bekræft sletning");
            alert.setHeaderText("Slet deltager");
            alert.setContentText("Er du sikker på, at du vil slette denne deltager?");

            if (alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
                Controller.deleteDeltager(deltager);
                lvwDeltagere.getItems().remove(deltager);
                lvwTilmeldinger.getItems().clear();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ingen deltager valgt");
            alert.setHeaderText("Fejl");
            alert.setContentText("Vælg en deltager fra listen for at slette");
            alert.showAndWait();
        }
    }
}
