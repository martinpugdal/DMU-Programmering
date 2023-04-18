package gui;

import controller.Game;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.YatzyDice;

import java.util.ArrayList;

public class YatzyGui extends Application {
    private final YatzyDice dice = new YatzyDice();
    private EndWindow endWindow;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy | Roll the dice!");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResource("public/yatzyLogo.png").toString()));

        StartWindow startWindow = new StartWindow("Want to play?", stage);
        endWindow = new EndWindow("Game over", stage);

        startWindow.getIcons().add(stage.getIcons().get(0));
        endWindow.getIcons().add(stage.getIcons().get(0));

//        startWindow.show();
        endWindow.gameOver(123);
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
        pane.setStyle("-fx-background-color: #348311;");


        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
//        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(13);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");


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


        dicePane.add(btnThrow, 3, 2, 2, 1);
        btnThrow.setOnAction(event -> this.throwDice());
        btnThrow.setPrefWidth(85);
        GridPane.setMargin(btnThrow, new Insets(11, 0, 0, 0));


        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
//        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int width = 50; // width of the text fields


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
                txf.setStyle("-fx-background-color: white;");
                txf.setOnMouseClicked(this::mousePickResult);
                scorePane.add(txf, 1, i);
                txfResults.add(txf);
            }
        }


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

    private void throwDice() {
        if (btnThrow.getText().trim().equals("Throwing...")) {
            return;
        }
        if (dice.getThrowCount() == 0) {
            Game.resetHolds(cbxHolds);
        } else {
            Game.lockHolds(cbxHolds);
        }
        for (TextField txfResult : txfResults) {
            txfResult.setStyle("-fx-background-color: white");
        }
        Game.clearResults(txfResults);
        btnThrow.setText(" Throwing... ");
        dice.throwDice(cbxHolds);
        Game.diceAnimation(txfResults, txfValues, cbxHolds, dice, btnThrow);
    }

    private void mousePickResult(MouseEvent event) {
        TextField txf = (TextField) event.getSource();
        if (txf.getText().isEmpty()) {
            return;
        }
        if (txfResults.indexOf(txf) < 6) {
            Game.addScore(txfSumSame, Integer.parseInt(txf.getText()));
        } else {
            Game.addScore(txfSumOther, Integer.parseInt(txf.getText()));
        }
        if (txfSumSame.getText() != null && Integer.parseInt(txfSumSame.getText()) >= 63) {
            Game.addScore(txfBonus, 50);
            Game.addScore(txfTotal, 50);
        }
        Game.addScore(txfTotal, Integer.parseInt(txf.getText()));
        txf.setDisable(true);
        txf.setStyle("-fx-background-color: white");
        Game.clearResults(txfResults);
        if (Game.allResultsFilled(txfResults)) {
            endWindow.gameOver(Integer.parseInt(txfTotal.getText()));
            Game.resetScore(txfSumSame);
            Game.resetScore(txfBonus);
            Game.resetScore(txfSumOther);
            Game.resetScore(txfTotal);
        }
        dice.resetThrowCount();
        Game.resetHolds(cbxHolds);
        Game.resetDice(txfValues);
        Game.updateThrowButton(btnThrow, dice.getThrowCount());
    }
}
