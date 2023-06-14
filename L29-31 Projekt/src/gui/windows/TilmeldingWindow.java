package gui.windows;

import application.controller.Controller;
import application.model.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TilmeldingWindow extends Stage {
    Tilmelding tilmelding;
    Deltager deltager;
    Konference konference;
    ListView<CheckBox> lvwTillæg;
    private GridPane reservationPane;
    private TextField txfDeltager, txfFordragsholder, txfReservation, txfLedsager, txfPrisPerNat;
    private CheckBox chbForedragsholder, chbLedsager, chbReservation;
    private ComboBox<Konference> cbbKonference;
    private ComboBox<LocalDate> cbbAnkomstDato, cbbAfrejseDato;
    private ComboBox<Hotel> cbbHotel;
    private Label lblLedsagerNavn;

    public TilmeldingWindow(Tilmelding tilmelding, Deltager deltager) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.tilmelding = tilmelding;
        this.deltager = deltager;
        ;

        this.setTitle("Tilmelding");
        GridPane pane = new GridPane();
        this.initContent(pane);

        if (tilmelding != null) {
            cbbKonference.getSelectionModel().select(tilmelding.getKonference());
            cbbKonference.setDisable(true);
            cbbAnkomstDato.getSelectionModel().select(tilmelding.getAnkomstDato());
            cbbAfrejseDato.getSelectionModel().select(tilmelding.getAfrejseDato());
            chbForedragsholder.setSelected(tilmelding.isFordragsholder());
            if (tilmelding.ledsagerNotEmpty()) {
                chbLedsager.setSelected(tilmelding.ledsagerNotEmpty());
                txfLedsager.setText(tilmelding.getLedsager().getNavn());
            }
            if (tilmelding.getReservation() != null) {
                chbReservation.setSelected(true);
                cbbHotel.getSelectionModel().select(tilmelding.getReservation().getHotel());
                for (CheckBox checkBox : lvwTillæg.getItems()) {
                    if (tilmelding.getReservation().getValgteTilæg().contains(checkBox.getUserData())) {
                        checkBox.setSelected(true);
                    }
                }
            }
            updateControls();
        }

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public TilmeldingWindow(Deltager deltager) {
        this(null, deltager);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10, 20, 10, 10));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblDeltager = new Label("Deltager");
        pane.add(lblDeltager, 0, 0);

        txfDeltager = new TextField(deltager.getNavn());
        pane.add(txfDeltager, 0, 1);
        txfDeltager.setEditable(false);
        txfDeltager.setPrefWidth(200);

        Label lblKonference = new Label("Konference");
        pane.add(lblKonference, 0, 2);

        cbbKonference = new ComboBox();
        cbbKonference.getItems().setAll(Controller.getKonferencer());
        pane.add(cbbKonference, 0, 3);
        cbbKonference.setPrefWidth(200);
        cbbKonference.setOnAction(event -> updateControls());

        Label lblAnkomstDato = new Label("Ankomst dato");
        pane.add(lblAnkomstDato, 0, 4);

        cbbAnkomstDato = new ComboBox();
        pane.add(cbbAnkomstDato, 0, 5);
        cbbAnkomstDato.setPrefWidth(200);

        Label lblAfrejseDato = new Label("Afrejse dato");
        pane.add(lblAfrejseDato, 0, 6);

        cbbAfrejseDato = new ComboBox();
        pane.add(cbbAfrejseDato, 0, 7);
        cbbAfrejseDato.setPrefWidth(200);

        chbForedragsholder = new CheckBox("Fordragsholder");
        pane.add(chbForedragsholder, 0, 8);

        chbLedsager = new CheckBox("Ledsager");
        pane.add(chbLedsager, 0, 9);
        chbLedsager.setOnAction(event -> enableLedsager());

        lblLedsagerNavn = new Label("Ledsager navn");
        pane.add(lblLedsagerNavn, 0, 10);
        lblLedsagerNavn.setDisable(true);

        txfLedsager = new TextField();
        pane.add(txfLedsager, 0, 11);
        txfLedsager.setPrefWidth(200);
        txfLedsager.setDisable(true);


        //------------------------------------------------------------------------------

        reservationPane = new GridPane();
        reservationPane.setPadding(new Insets(0));
        reservationPane.setHgap(10);
        reservationPane.setVgap(10);
        reservationPane.setGridLinesVisible(false);
        reservationPane.setDisable(true);

        chbReservation = new CheckBox("Hotel reservation");
        pane.add(chbReservation, 1, 0);
        chbReservation.setOnAction(event -> enableReservation());

        cbbHotel = new ComboBox<>();
        reservationPane.add(cbbHotel, 0, 0);
        cbbHotel.setPrefWidth(200);
        cbbHotel.setOnAction(event -> updateControls());

        Label lblPrisPerNat = new Label("Pris pr. nat");
        reservationPane.add(lblPrisPerNat, 0, 1);

        txfPrisPerNat = new TextField();
        txfPrisPerNat.setEditable(false);
        reservationPane.add(txfPrisPerNat, 0, 2);

        Label lblTillæg = new Label("Tillæg");
        reservationPane.add(lblTillæg, 0, 3);

        lvwTillæg = new ListView<>();
        lvwTillæg.setPrefHeight(75);
        reservationPane.add(lvwTillæg, 0, 4);

        pane.add(reservationPane, 1, 1, 1, pane.getRowCount() - 1);

        HBox hbxButtons = new HBox(90);
        pane.add(hbxButtons, 0, 12);

        Button btnTilmeld = new Button("Tilmeld");
        hbxButtons.getChildren().add(btnTilmeld);
        btnTilmeld.setOnAction(event -> tilmeldAction());

        Button btnAnnuller = new Button("Annuller");
        hbxButtons.getChildren().add(btnAnnuller);
        btnAnnuller.setOnAction(event -> this.close());

        updateControls();
    }

    private void updateControls() {
        if (cbbKonference.getSelectionModel().isEmpty()) {
            cbbKonference.getSelectionModel().select(0);
        }
        konference = cbbKonference.getSelectionModel().getSelectedItem();

        ArrayList<LocalDate> dates = new ArrayList<>(konference.getStartDato().datesUntil(konference.getSlutDato().plusDays(1)).collect(Collectors.toList()));
        cbbAnkomstDato.getItems().setAll(dates);
        cbbAnkomstDato.getSelectionModel().select(0);
        cbbAfrejseDato.getItems().setAll(dates);
        cbbAfrejseDato.getSelectionModel().select(dates.size() - 1);

        if (!konference.getHoteller().equals(cbbHotel.getItems())) {
            cbbHotel.getItems().setAll(konference.getHoteller());
        }
        if (cbbHotel.getSelectionModel().isEmpty()) {
            cbbHotel.getSelectionModel().select(0);
        }

        if (!konference.getHoteller().isEmpty()) {
            lvwTillæg.getItems().clear();
            for (Tillæg tillæg : cbbHotel.getSelectionModel().getSelectedItem().getTillæg()) {
                CheckBox chbTillæg = new CheckBox(tillæg.toString());
                chbTillæg.setUserData(tillæg);
                lvwTillæg.getItems().add(chbTillæg);
            }
            enableLedsager();
            enableReservation();
        } else {
            chbReservation.setDisable(true);
        }
    }

    private void enableLedsager() {
        if (chbLedsager.isSelected()) {
            lblLedsagerNavn.setDisable(false);
            txfLedsager.setDisable(false);
            if (!konference.getHoteller().isEmpty()) {
                txfPrisPerNat.setText((Double.toString(cbbHotel.getSelectionModel().getSelectedItem().getPrisDobbelt())));
            }
        } else {
            lblLedsagerNavn.setDisable(true);
            txfLedsager.clear();
            txfLedsager.setDisable(true);
            if (!konference.getHoteller().isEmpty()) {
                txfPrisPerNat.setText((Double.toString(cbbHotel.getSelectionModel().getSelectedItem().getPrisEnkelt())));
            }
        }
    }

    private void enableReservation() {
        if (chbReservation.isSelected()) {
            reservationPane.setDisable(false);
        } else {
            reservationPane.setDisable(true);
        }
    }

    private void tilmeldAction() {
        if (chbLedsager.isSelected() && txfLedsager.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ingen Ledsager");
            alert.setHeaderText("Ledsager felt tomt");
            alert.setContentText("Indtast Ledsager");
            alert.showAndWait();
        } else {
            if (tilmelding == null) {
                tilmelding = Controller.createTilmelding(deltager, konference, chbForedragsholder.isSelected(), cbbAnkomstDato.getSelectionModel().getSelectedItem(), cbbAfrejseDato.getSelectionModel().getSelectedItem());
            } else {
                Controller.updateTilmelding(tilmelding, chbForedragsholder.isSelected(), cbbAnkomstDato.getSelectionModel().getSelectedItem(), cbbAfrejseDato.getSelectionModel().getSelectedItem());
            }
            if (chbLedsager.isSelected()) {
                tilmelding.createLedsager(txfLedsager.getText().trim(), deltager);
            } else {
                tilmelding.fjernLedsager();
            }
            if (chbReservation.isSelected()) {
                ArrayList<Tillæg> valgteTillæg = new ArrayList<>();
                for (CheckBox chbTillæg : lvwTillæg.getItems()) {
                    if (chbTillæg.isSelected()) {
                        valgteTillæg.add((Tillæg) chbTillæg.getUserData());
                    }
                }
                tilmelding.opretReservation(cbbHotel.getSelectionModel().getSelectedItem(), valgteTillæg);
            }
            this.close();
        }
    }
}

