package exercise_2;

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
        stage.setTitle("Exercise 2");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private TextField txfNumber;

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(true);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblNumber = new Label("Number:");
        pane.add(lblNumber, 0, 0, 1,2);

        txfNumber = new TextField();
        txfNumber.setPrefWidth(60);
        pane.add(txfNumber, 1, 0, 1, 2);

        Button btnInc = new Button("Inc");
        pane.add(btnInc, 2, 0);
        btnInc.setOnAction(event -> this.increaseNumber());

        Button btnDec = new Button("Dec");
        pane.add(btnDec, 2, 1);

        btnDec.setOnAction(event -> this.decreaseNumber());

    }

    private void increaseNumber() {
        int number = Integer.parseInt(txfNumber.getText().trim());
        number++;
        txfNumber.setText(String.valueOf(number));
    }

    private void decreaseNumber() {
        int number = Integer.parseInt(txfNumber.getText().trim());
        number--;
        txfNumber.setText(String.valueOf(number));
    }
}