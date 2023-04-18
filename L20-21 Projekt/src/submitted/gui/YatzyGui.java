package submitted.gui;

import submitted.controller.Game;
import submitted.model.YatzyDice;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class YatzyGui extends Application {
    private final YatzyDice dice = new YatzyDice();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy | Roll the dice!");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/5e8371c9-8447-4d9e-92bd-a856aadc77e2/d4fg040-82583b4c-f48b-45fe-bc39-cb045b541464.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwic3ViIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsImF1ZCI6WyJ1cm46c2VydmljZTpmaWxlLmRvd25sb2FkIl0sIm9iaiI6W1t7InBhdGgiOiIvZi81ZTgzNzFjOS04NDQ3LTRkOWUtOTJiZC1hODU2YWFkYzc3ZTIvZDRmZzA0MC04MjU4M2I0Yy1mNDhiLTQ1ZmUtYmMzOS1jYjA0NWI1NDE0NjQucG5nIn1dXX0.tnt9fffxR6racRlhMDESkOhVdlsgkYRjM7RcoCDYU48"));
        stage.show();
    }

    // -------------------------------------------------------------------------

    // txfValues shows the face values of the 5 dice.
    private final TextField[] txfValues = new TextField[5];
    // cbxHolds shows the hold status of the 5 dice.
    private final CheckBox[] cbxHolds = new CheckBox[5];
    // txfResults shows the obtained results.
    // For results not set yet, the possible result of 
    // the actual face values of the 5 dice are shown.
    private final ArrayList<TextField> txfResults = new ArrayList<>(15);
    // Shows points in sums, bonus and total.
    private final TextField txfSumSame = new TextField();
    private final TextField txfBonus = new TextField();
    private final TextField txfSumOther = new TextField();
    private final TextField txfTotal = new TextField();
    private final Button btnThrow = new Button("Throw 1");

    private void initContent(GridPane pane) {
//        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(13);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        // add txfValues, chbHolds
        // TODO
        for (int i = 0; i < txfValues.length; i++) {
            txfValues[i] = new TextField();
            txfValues[i].setEditable(false);
            txfValues[i].setPrefWidth(65);
            txfValues[i].setPrefHeight(65);
            txfValues[i].setStyle("-fx-alignment: center; -fx-text-alignment: center; -fx-font-size: 30; -fx-font-weight: bold;");
            txfValues[i].setFocusTraversable(false);
            cbxHolds[i] = new CheckBox("Hold");
            dicePane.add(txfValues[i], i, 0);
            dicePane.add(cbxHolds[i], i, 1);
            GridPane.setHalignment(cbxHolds[i], HPos.CENTER);
        }
        Game.resetDice(txfValues);

        // add btnThrow
        // TODO
        dicePane.add(btnThrow, 3, 2, 2, 1);
        btnThrow.setStyle("-fx-text-alignment: center");
        btnThrow.setOnAction(event -> this.throwDice());
        btnThrow.setPrefWidth(85);
        btnThrow.setDefaultButton(true);
        GridPane.setMargin(btnThrow, new Insets(11, 0, 0, 0));

        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int width = 50; // width of the text fields

        // add labels for results
        // add txfResults,
        // TODO
        String[] resultsTexts = {
                "1-s",
                "2-s",
                "3-s",
                "4-s",
                "5-s",
                "6-s",
                null,
                "One Pair",
                "Two Pairs",
                "Three-Same",
                "Four-Same",
                "Full House",
                "Small Str.",
                "Large Str.",
                "Chance",
                "Yatzy"
        };
        for (int i = 0; i < resultsTexts.length; i++) {
            if (resultsTexts[i] != null) {
                Label label = new Label(resultsTexts[i]);
                scorePane.add(label, 0, i);
                TextField txf = new TextField();
                txf.setPrefWidth(width);
                txf.setEditable(false);
                txf.setStyle("-fx-background-color: white");
                txf.setFocusTraversable(true);
                txf.setOnMouseClicked(this::mousePickResult);
                scorePane.add(txf, 1, i);
                txfResults.add(txf);
            }
        }

        // add labels and text fields for sums, bonus and total.
        // TODO
        String[] sumTexts = {
                "Sum",
                "Bonus",
                "Sum",
                "TOTAL"
        };
        TextField[] sumTextFields = {txfSumSame, txfBonus, txfSumOther, txfTotal};
        int j = 6;
        for (int i = 0; i < sumTextFields.length; i++) {
            if (i == 2) {
                j = 13;
            }
            if (j == 13) {
                sumTextFields[i].setStyle("-fx-background-color: white");
            }
            Label label = new Label(sumTexts[i]);
            scorePane.add(label, 2, i + j);
            sumTextFields[i].setPrefWidth(width);
            sumTextFields[i].setEditable(false);
            sumTextFields[i].setFocusTraversable(false);
            scorePane.add(sumTextFields[i], 3, i + j);
        }
    }

    // -------------------------------------------------------------------------

    // Create an action method for btnThrow's action.
    // Hint: Create small helper methods to be used in the action method.
    // TODO
    private void throwDice() {
        Game.lockHolds(cbxHolds);
        if (dice.getThrowCount() == 0) {
            Game.resetHolds(cbxHolds);
        }
        for (TextField txfResult : txfResults) {
            txfResult.setStyle("-fx-background-color: white");
        }
        Game.resetResults(txfResults);
        btnThrow.setText(" Throwing... ");
        dice.throwDice(cbxHolds);
        Game.diceAnimation(txfResults, txfValues, cbxHolds, dice, btnThrow);
    }

    // -------------------------------------------------------------------------

    // Create a method for mouse click on one of the text fields in txfResults.
    // Hint: Create small helper methods to be used in the mouse click method.
    // TODO
    private void mousePickResult(MouseEvent event) {
        TextField txf = (TextField) event.getSource();
        if (txf.getText().isEmpty()) {
            return;
        }
        dice.resetThrowCount();
        Game.resetHolds(cbxHolds);
        Game.resetDice(txfValues);
        txf.setDisable(true);
        if (txfResults.indexOf(txf) < 6) {
            Game.addScore(txfSumSame, Integer.parseInt(txf.getText()));
        } else {
            Game.addScore(txfSumOther, Integer.parseInt(txf.getText()));
        }
        if (Integer.parseInt(txf.getText()) >= 63) {
            Game.addScore(txfBonus, 50);
            Game.addScore(txfTotal, 50);
        }
        Game.addScore(txfTotal, Integer.parseInt(txf.getText()));
        for (TextField txfResult : txfResults) {
            txfResult.setStyle("-fx-background-color: white");
        }
        Game.resetResults(txfResults);
        if (Game.allResultsFilled(txfResults)) {
            Game.resetDice(txfValues);
        }
        Game.updateThrowButton(btnThrow, dice.getThrowCount());
    }
}
