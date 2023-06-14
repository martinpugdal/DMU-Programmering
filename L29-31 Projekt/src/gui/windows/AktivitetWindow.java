package gui.windows;

import application.model.Aktivitet;
import application.model.Ledsager;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class AktivitetWindow extends Stage {

    private ArrayList<Aktivitet> aktiviteter = new ArrayList<>();
    private ArrayList<Ledsager> ledsagere = new ArrayList<>();
    private ComboBox<Aktivitet> cbbAktiviter = new ComboBox<>();
    private ListView<Ledsager> lvwTilmeldteLedsagere = new ListView<>();
    private ListView<Ledsager> lvwIkkeTilmeldteLedsagere = new ListView<>();

    public AktivitetWindow(ArrayList<Ledsager> ledsagere, ArrayList<Aktivitet> aktiviteter) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.aktiviteter = aktiviteter;
        this.ledsagere = ledsagere;

        this.setTitle("Aktiviteter");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10, 20, 10, 10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblIkkeTilmeldteLedsagere = new Label("Ikke tilmeldte ledsagere");
        pane.add(lblIkkeTilmeldteLedsagere, 0, 0);

        lvwIkkeTilmeldteLedsagere.getItems().addAll(ledsagere);
        pane.add(lvwIkkeTilmeldteLedsagere, 0, 1);
        lvwIkkeTilmeldteLedsagere.setPrefHeight(150);
        lvwIkkeTilmeldteLedsagere.setPrefWidth(150);

        Label lblTilmeldteLedsagere = new Label("Tilmeldte ledsagere");
        pane.add(lblTilmeldteLedsagere, 1, 0);

        lvwTilmeldteLedsagere = new ListView<>();
        pane.add(lvwTilmeldteLedsagere, 1, 1);


        cbbAktiviter = new ComboBox<>();
        cbbAktiviter.setPromptText("Vælg aktivitet");
        cbbAktiviter.getItems().addAll(aktiviteter);
        pane.add(cbbAktiviter, 0, 2);
        cbbAktiviter.setOnAction(event -> updateControls());

        HBox hbxButtons = new HBox(10);
        pane.add(hbxButtons, 1, 2);

        Button btnTilføjAktivitet = new Button("Tilføj til Aktivitet");
        hbxButtons.getChildren().add(btnTilføjAktivitet);
        btnTilføjAktivitet.setOnAction(event -> tilføjAktivitet());

        Button btnFjernAktivitet = new Button("Fjern fra Aktivitet");
        hbxButtons.getChildren().add(btnFjernAktivitet);
        btnFjernAktivitet.setOnAction(event -> fjernAktivitet());
    }

    private void tilføjAktivitet() {
        Ledsager ledsager = lvwIkkeTilmeldteLedsagere.getSelectionModel().getSelectedItem();
        Aktivitet aktivitet = cbbAktiviter.getSelectionModel().getSelectedItem();

        if (ledsager == null || aktivitet == null || ledsager.hasAktivitet(aktivitet)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Fejl");
            alert.setHeaderText("Fejl");
            alert.setContentText((ledsager == null ? "Ledsager" : "Aktivitet") + " er ikke valgt");
            alert.showAndWait();
        } else {
            ledsager.addAktivitet(aktivitet);
            lvwTilmeldteLedsagere.getItems().addAll(ledsager);
            lvwIkkeTilmeldteLedsagere.getItems().remove(ledsager);
        }
    }

    private void updateControls() {
        Aktivitet aktivitet = cbbAktiviter.getSelectionModel().getSelectedItem();
        lvwIkkeTilmeldteLedsagere.getItems().clear();
        lvwIkkeTilmeldteLedsagere.getItems().addAll(ledsagere);
        if (aktivitet != null) {
            lvwTilmeldteLedsagere.getItems().clear();
            lvwTilmeldteLedsagere.getItems().addAll(aktivitet.getLedsagere());
            lvwIkkeTilmeldteLedsagere.getItems().removeAll(aktivitet.getLedsagere());
        }
    }

    private void fjernAktivitet() {
        Ledsager ledsager = lvwTilmeldteLedsagere.getSelectionModel().getSelectedItem();
        Aktivitet aktivitet = cbbAktiviter.getSelectionModel().getSelectedItem();

        if (ledsager == null || aktivitet == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Fejl");
            alert.setHeaderText("Fejl");
            alert.setContentText("Vælg en ledsager og en aktivitet");
            alert.showAndWait();
            return;
        }

        if (!ledsager.hasAktivitet(aktivitet)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Fejl");
            alert.setHeaderText("Fejl");
            alert.setContentText("Ledsager er ikke tilmeldt denne aktivitet");
            alert.showAndWait();
            return;
        }

        ledsager.removeAktivitet(aktivitet);

        lvwIkkeTilmeldteLedsagere.getItems().addAll(ledsager);
        lvwTilmeldteLedsagere.getItems().remove(ledsager);
    }
}
