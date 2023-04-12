package exercise_5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Boys and girls");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final ListView<String> lvwNames = new ListView<>();
    private final ArrayList<String> boyNames = new ArrayList<>();
    private final ArrayList<String> girlNames = new ArrayList<>();
    private final ToggleGroup group = new ToggleGroup();


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);


        Label lblName = new Label("Name:");
        Label lblNames = new Label("Names:");

        Button btnAddName = new Button("Add");

        HBox box = new HBox();

        RadioButton radioButtonBoy = new RadioButton();
        RadioButton radioButtonGirl = new RadioButton();


        lvwNames.setPrefWidth(200);
        lvwNames.setPrefHeight(200);


        box.getChildren().add(radioButtonBoy);
        radioButtonBoy.setText("Boy");
        radioButtonBoy.setUserData("Boy");
        radioButtonBoy.setToggleGroup(group);
        radioButtonBoy.setSelected(true);

        box.getChildren().add(radioButtonGirl);
        radioButtonGirl.setText("Girl");
        radioButtonGirl.setUserData("Girl");
        radioButtonGirl.setToggleGroup(group);

        pane.add(box, 1, 0);

        pane.add(lblNames, 0, 1);
        pane.add(lblName, 0, 2);

        pane.add(txfName, 1, 2);

        pane.add(btnAddName, 2, 2);

        pane.add(lvwNames, 1, 1);

        btnAddName.setOnAction(event -> this.addNameAction());
        group.selectedToggleProperty().addListener(event -> this.updateNames());
    }

    private void updateNames() {
        if (group.getSelectedToggle().getUserData().equals("Girl")) {
            lvwNames.getItems().setAll(girlNames);
        } else {
            lvwNames.getItems().setAll(boyNames);
        }
    }

    private void addNameAction() {
        if (!txfName.getText().isEmpty()) {
            if (group.getSelectedToggle().getUserData().equals("Girl")) {
                girlNames.add(txfName.getText());
                lvwNames.getItems().setAll(girlNames);
            } else {
                boyNames.add(txfName.getText());
                lvwNames.getItems().setAll(boyNames);
            }
            txfName.clear();
            txfName.requestFocus();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No name typed");
            alert.setContentText("Please type a name");
            alert.show();
        }
    }
}
