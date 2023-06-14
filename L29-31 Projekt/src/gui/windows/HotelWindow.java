package gui.windows;

import application.controller.Controller;
import application.model.Deltager;
import application.model.Hotel;
import application.model.Konference;
import application.model.Tilmelding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class HotelWindow extends Stage {

    Konference konference;
    private ComboBox<Hotel> cbbHoteller;
    private ListView<String> lvwPersoner;

    public HotelWindow(Konference konference) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.konference = konference;

        this.setTitle("Hotel oversigt");
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

        Label lblHoteller = new Label("Hoteller");
        pane.add(lblHoteller, 0, 0);

        cbbHoteller = new ComboBox<>();
        cbbHoteller.setPromptText("Vælg hotel");
        pane.add(cbbHoteller, 0, 1);

        Label lblDeltagere = new Label("Deltagere");
        pane.add(lblDeltagere, 0, 2);

        lvwPersoner = new ListView<>();
        pane.add(lvwPersoner, 0, 3);
        lvwPersoner.setPrefWidth(200);
        lvwPersoner.setPrefHeight(200);

        ObservableList<Hotel> hotelList = FXCollections.observableArrayList(Controller.getHoteller());
        cbbHoteller.setItems(hotelList);


        cbbHoteller.getSelectionModel().selectedItemProperty().addListener((ov, oldHotel, newHotel) -> {
            ArrayList<String> personList = new ArrayList<>();
            for (Deltager deltager : konference.getDeltagereVedHotel(newHotel)) {
                String buildString = deltager.toString();
                for (Tilmelding tilmelding : deltager.getTilmeldinger()) {
                    if (tilmelding.ledsagerNotEmpty()) {
                        buildString += ", " + tilmelding.getLedsager().getNavn();
                    }
                }
                personList.add(buildString);
            }
            lvwPersoner.getItems().setAll(personList);
        });
    }

}
