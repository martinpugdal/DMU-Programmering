package gui;

import Application.controller.Controller;
import Application.model.Bestilling;
import Application.model.Forestilling;
import Application.model.Plads;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class StatistikWindow extends Stage {
    public StatistikWindow(Stage stage) {
        this.initOwner(stage);
        this.setTitle("Statistik");
        this.setResizable(false);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private final ListView<Forestilling> lvwForestillinger = new ListView<>();
    private final ListView<String> lvwInfo = new ListView<>();
    private final ListView<Bestilling> lvwBestillinger = new ListView<>();

    public void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblForestillinger = new Label("Forestillinger");
        pane.add(lblForestillinger, 0, 0);
        pane.add(lvwForestillinger, 0, 1);
        lvwForestillinger.getItems().setAll(Controller.getForestillinger());

        Label lblBestillinger = new Label("Bestillinger");
        pane.add(lblBestillinger, 1, 0);
        pane.add(lvwBestillinger, 1, 1);

        Label lblInfo = new Label("Information");
        pane.add(lblInfo, 2, 0);
        pane.add(lvwInfo, 2, 1);

        lvwForestillinger.setOnMouseClicked(event -> this.selectedForestillingChanged());
        lvwBestillinger.setOnMouseClicked(event -> this.selectedBestillingChanged());
    }

    private void selectedBestillingChanged() {
        Bestilling bestilling = lvwBestillinger.getSelectionModel().getSelectedItem();
        int samletPris = bestilling.samletPris();
        int antalBestiltePladserPåDag = bestilling.getForestilling().antalBestiltePladserPåDag(bestilling.getDato());
        LocalDate succesDato = bestilling.getForestilling().succesDato();
        ArrayList<Plads> bestiltePladserTilForestillingPåDag = bestilling.getKunde().bestiltePladserTilForestillingPåDag(bestilling.getForestilling(), bestilling.getDato());

        lvwInfo.getItems().setAll(
                "Samlet pris for bestilling: " + samletPris,
                "Antal bestilte pladser på dag: " + antalBestiltePladserPåDag,
                "Succes dato for forestilling: " + succesDato,
                "Bestilte pladser til forestilling på dag: " + bestiltePladserTilForestillingPåDag);
    }

    private void selectedForestillingChanged() {
        lvwInfo.getItems().clear();
        lvwBestillinger.getItems().setAll(lvwForestillinger.getSelectionModel().getSelectedItem().getBestillinger());
    }
}
