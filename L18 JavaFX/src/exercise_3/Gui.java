package exercise_3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Exercise 3");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private TextField txfFirstName;
    private TextField txfLastName;
    private TextField txfFullName;

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(true);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblFirstName = new Label("First name:");
        pane.add(lblFirstName, 0, 0);

         txfFirstName = new TextField();
        pane.add(txfFirstName, 0, 1, 1, 1);


        Label lblLastName = new Label("Last name:");
        pane.add(lblLastName, 1, 0);

        txfLastName = new TextField();
        pane.add(txfLastName, 1, 1, 1, 1);

        Label lblFullName = new Label("Full name:");
        pane.add(lblFullName, 0, 2);

        txfFullName = new TextField();
        pane.add(txfFullName, 0, 3, 2, 1);

        Button btnCombine = new Button("Combine");
        pane.add(btnCombine, 1, 4);
        GridPane.setMargin(btnCombine, new Insets(10, 10, 0, 10));

        btnCombine.setOnAction(event -> this.combineAction());

    }

    private void combineAction() {
        String name = txfFirstName.getText().trim() + " " + txfLastName.getText().trim();
        txfFullName.setText(name);
    }
}