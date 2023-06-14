package gui.windows;

import application.controller.Controller;
import application.model.Konference;

import application.model.Deltager;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;

public class KonferenceWindow extends Stage {

    Konference konference;
    private TextField txfKonferenceNavn, txfLand, txfBy, txfAdresse, txfPris;
    private DatePicker dpStartDato, dpSlutDato;

    public KonferenceWindow(Konference konference) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);

        this.konference = konference;

        this.setTitle("Konference");
        GridPane pane = new GridPane();
        this.initContent(pane);

        if (konference != null) {
            txfKonferenceNavn.setText(konference.getNavn());
            txfLand.setText(konference.getLand());
            dpStartDato.setValue(konference.getStartDato());
            dpSlutDato.setValue(konference.getSlutDato());
            txfBy.setText(konference.getBy());
            txfAdresse.setText(konference.getAdresse());
            txfPris.setText(Double.toString(konference.getPris()));
        }

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public KonferenceWindow() {
        this(null);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblKonferenceNavn = new Label("Konference navn");
        pane.add(lblKonferenceNavn, 0, 0);

        txfKonferenceNavn = new TextField();
        pane.add(txfKonferenceNavn, 0, 1);
        txfKonferenceNavn.setPrefWidth(200);

        Label lblLand = new Label("Land");
        pane.add(lblLand, 0, 2);

        txfLand = new TextField();
        pane.add(txfLand, 0, 3);

        Label lblStartDato = new Label("Start dato");
        pane.add(lblStartDato, 0, 4);

        dpStartDato = new DatePicker();
        pane.add(dpStartDato, 0, 5);

        Label lblSlutDato = new Label("Slut dato");
        pane.add(lblSlutDato, 0, 6);

        dpSlutDato = new DatePicker();
        pane.add(dpSlutDato, 0, 7);

        Label lblBy = new Label("By");
        pane.add(lblBy, 0, 8);

        txfBy = new TextField();
        pane.add(txfBy, 0, 9);

        Label lblAdresse = new Label("Adresse");
        pane.add(lblAdresse, 0, 10);

        txfAdresse = new TextField();
        pane.add(txfAdresse, 0, 11);

        Label lblPris = new Label("Pris pr. dag");
        pane.add(lblPris, 0, 12);

        txfPris = new TextField();
        pane.add(txfPris, 0, 13);

        Button btnOpret = new Button("Opret");
        pane.add(btnOpret, 0, 14);
        btnOpret.setOnAction(event -> {
            opretKonferenceAction();
            this.close();
        });

        Button btnAnnuller = new Button("Annuller");
        pane.add(btnAnnuller, 1, 14);
        btnAnnuller.setOnAction(event -> this.close());
    }

    private void opretKonferenceAction() {
        String konferenceNavn = txfKonferenceNavn.getText();
        String land = txfLand.getText();
        LocalDate startDato = dpStartDato.getValue();
        LocalDate slutDato = dpSlutDato.getValue();
        String by = txfBy.getText();
        String adresse = txfAdresse.getText();
        String stringPris = txfPris.getText();
        double pris = Double.parseDouble(stringPris);

        if (konference != null)
            Controller.updateKonference(konference, konferenceNavn, startDato, slutDato, adresse, land, by, pris);
        else
            Controller.createKonference(konferenceNavn, startDato, slutDato, adresse, land, by, pris);

    }
}
