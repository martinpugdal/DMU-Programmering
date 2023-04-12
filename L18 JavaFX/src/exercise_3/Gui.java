package exercise_3;

import javafx.application.Application;
import javafx.geometry.HPos;
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

    private TextField txfInvestment;
    private TextField txfYear;
    private TextField txfInterest;
    private TextField txtFutureValue;

    private void initContent(GridPane pane) {
        // show or hide grid lines
//        pane.setGridLinesVisible(true);



        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblInvestment = new Label("Investment:");
        pane.add(lblInvestment, 0, 0);

        txfInvestment = new TextField();
        pane.add(txfInvestment, 1, 0);

        Label lblYear = new Label("Years:");
        pane.add(lblYear, 0, 1);

        txfYear = new TextField();
        pane.add(txfYear, 1, 1);

        Label lblInterest = new Label("Interest (%):");
        pane.add(lblInterest, 0, 2);

        txfInterest = new TextField();
        pane.add(txfInterest, 1, 2);

        Button btnCalc = new Button("Caclulate");
        pane.add(btnCalc, 1, 3);
        GridPane.setHalignment(btnCalc, HPos.CENTER);
        btnCalc.setOnAction(event -> this.calculateInvestment());

        Label lblFutureValue = new Label("Future value:");
        pane.add(lblFutureValue, 0, 4);

        txtFutureValue = new TextField();
        pane.add(txtFutureValue, 1, 4);
        txtFutureValue.setEditable(false);

    }

    private void calculateInvestment() {
        double investment = Double.parseDouble(txfInvestment.getText().trim());
        int year = Integer.parseInt(txfYear.getText().trim());
        double interest = Double.parseDouble(txfInterest.getText().trim());
        double futureValue = investment * Math.pow(1 + interest / 100, year);
        txtFutureValue.setText(String.valueOf(futureValue));
    }

}