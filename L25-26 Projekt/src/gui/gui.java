package gui;

import Application.controller.Controller;
import Application.model.Bestilling;
import Application.model.Forestilling;
import Application.model.Kunde;
import Application.model.Plads;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class gui extends Application {
    StatistikWindow statistikWindow;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Teater Bestillinger");
        GridPane pane = new GridPane();
        this.initContent(pane);

        statistikWindow = new StatistikWindow(stage);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final ListView<Forestilling> lvwForestillinger = new ListView<>();
    private final ListView<Kunde> lvwKunder = new ListView<>();
    private final ListView<Plads> lvwPladser = new ListView<>();
    private final TextField txfNavn = new TextField();
    private final DatePicker dtpStartDato = new DatePicker();
    private final DatePicker dtpSlutDato = new DatePicker();
    private final DatePicker dtpDato = new DatePicker();
    private final TextField txfKundeNavn = new TextField();
    private final TextField txfKundeMobil = new TextField();

    public void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        int width = 175;

        GridPane infoPane = new GridPane();
        infoPane.setPadding(new Insets(10));
        infoPane.setVgap(5);
        infoPane.setHgap(10);
        pane.add(infoPane, 0, 0);

        Label lblForestillinger = new Label("Forestillinger");
        infoPane.add(lblForestillinger, 0, 0);
        infoPane.add(lvwForestillinger, 0, 1);
        lvwForestillinger.getItems().setAll(Controller.getForestillinger());

        Label lblKunder = new Label("Kunder");
        infoPane.add(lblKunder, 1, 0);
        infoPane.add(lvwKunder, 1, 1);
        lvwKunder.getItems().setAll(Controller.getKunder());

        Label lblPladser = new Label("Pladser");
        infoPane.add(lblPladser, 2, 0);
        infoPane.add(lvwPladser, 2, 1);
        lvwPladser.getItems().setAll(Controller.getPladser());
        lvwPladser.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // ---------------------------------------------------------------------

        GridPane inputPane = new GridPane();
        inputPane.setPadding(new Insets(10));
        inputPane.setVgap(5);
        inputPane.setHgap(10);
        pane.add(inputPane, 0, 1);

        Label lblNavn = new Label("Navn");
        inputPane.add(lblNavn, 0, 0);
        inputPane.add(txfNavn, 1, 0);
        txfNavn.setPrefWidth(width);

        Label lblStartDato = new Label("Start Dato");
        inputPane.add(lblStartDato, 0, 1);
        inputPane.add(dtpStartDato, 1, 1);
        dtpStartDato.setPrefWidth(width);

        Label lblSlutDato = new Label("Slut Dato");
        inputPane.add(lblSlutDato, 0, 2);
        inputPane.add(dtpSlutDato, 1, 2);
        dtpSlutDato.setPrefWidth(width);

        Button btnOpretForestilling = new Button("Opret Forestilling");
        inputPane.add(btnOpretForestilling, 1, 3);
        btnOpretForestilling.setOnAction(event -> onOpretForestillingAction());

        Label lblKundeNavn = new Label("Kunde Navn");
        inputPane.add(lblKundeNavn, 2, 0);
        inputPane.add(txfKundeNavn, 3, 0);
        txfKundeNavn.setPrefWidth(width);

        Label lblKundeMobil = new Label("Kunde Mobil");
        inputPane.add(lblKundeMobil, 2, 1);
        inputPane.add(txfKundeMobil, 3, 1);

        Button btnOpretKunde = new Button("Opret Kunde");
        inputPane.add(btnOpretKunde, 3, 3);
        btnOpretKunde.setOnAction(event -> onOpretKundeAction());

        Label lblDato = new Label("Dato");
        inputPane.add(lblDato, 4, 0);
        inputPane.add(dtpDato, 5, 0);
        dtpDato.setPrefWidth(width);

        Button btnOpretBestilling = new Button("Opret Bestilling");
        inputPane.add(btnOpretBestilling, 5, 1);
        btnOpretBestilling.setOnAction(event -> opretBestilling());

        Button btnStatistik = new Button("Statistik");
        inputPane.add(btnStatistik, 5, 3);
        btnStatistik.setOnAction(event -> statistik());
    }

    public void onOpretForestillingAction() {
        if (txfNavn.getText().length() > 0 && dtpStartDato.getValue() != null && dtpSlutDato.getValue() != null) {
            String navn = txfNavn.getText().trim();
            LocalDate startDato = dtpStartDato.getValue();
            LocalDate slutDato = dtpSlutDato.getValue();

            Controller.createForestilling(navn, startDato, slutDato);
            lvwForestillinger.getItems().setAll(Controller.getForestillinger());
        } else {
            errorMessage("Udfyld alle felter");
        }
    }

    public void onOpretKundeAction() {
        if (txfKundeNavn.getText().length() > 0 && txfKundeMobil.getText().length() > 0) {
            String navn = txfKundeNavn.getText().trim();
            String mobil = txfKundeMobil.getText().trim();

            Controller.createKunde(navn, mobil);
            lvwKunder.getItems().setAll(Controller.getKunder());
        } else {
            errorMessage("Udfyld alle felter");
        }
    }

    public void opretBestilling() {
        Forestilling forestilling = lvwForestillinger.getSelectionModel().getSelectedItem();
        Kunde kunde = lvwKunder.getSelectionModel().getSelectedItem();
        LocalDate dato = dtpDato.getValue();
        ArrayList<Plads> pladser = new ArrayList<>(lvwPladser.getSelectionModel().getSelectedItems());
        if (forestilling != null && kunde != null && dato != null && pladser.size() > 0) {
            if (dato.isBefore(forestilling.getStartDato()) || dato.isAfter(forestilling.getSlutDato())) {
                errorMessage("Datoen er ikke indenfor forestillingens periode");
                return;
            }
            Bestilling bestilling = Controller.opretBestillingMedPladser(forestilling, kunde, dato, pladser);
            if (bestilling == null) {
                errorMessage("En eller flere pladser er optaget");
            } else {
                bestillingDialog(bestilling);
            }
        } else {
            errorMessage("Udfyld alle felter");
        }

    }

    public void errorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Fejl");
        alert.setHeaderText(message);
        alert.showAndWait();
    }

    public void bestillingDialog(Bestilling bestilling) {
        Dialog dialog = new Dialog();
        dialog.setResizable(true);
        dialog.setTitle("Bestilling Oprettet");
        dialog.setHeaderText(null);
        dialog.setContentText("Bestillingen er oprettet: " + Controller.bestillingToString(bestilling));
        ButtonType okButton = new ButtonType("OK");
        dialog.getDialogPane().getButtonTypes().add(okButton);
        dialog.showAndWait();
    }

    public void statistik() {
        statistikWindow.show();
    }
}
