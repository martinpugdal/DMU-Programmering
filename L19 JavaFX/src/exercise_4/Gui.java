package exercise_4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Person administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final ListView<String> lvwNames = new ListView<>();
    private final ArrayList<String> names = new ArrayList<>();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);


        Label lblName = new Label("Name:");
        Label lblNames = new Label("Names:");

        Button btnAddName = new Button("Add");


        lvwNames.setPrefWidth(200);
        lvwNames.setPrefHeight(200);
        lvwNames.getItems().setAll(names);


        pane.add(lblNames, 0, 0);
        pane.add(lblName, 0, 1);

        pane.add(txfName, 1, 1);

        pane.add(btnAddName, 2, 1);

        pane.add(lvwNames, 1, 0);

        btnAddName.setOnAction(event -> {
            if (!txfName.getText().isEmpty()) {
                names.add(txfName.getText());
                lvwNames.getItems().setAll(names);
                txfName.clear();
                txfName.requestFocus();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No name typed");
                alert.setContentText("Please type a name");
                alert.show();
            }
        });
    }
}
