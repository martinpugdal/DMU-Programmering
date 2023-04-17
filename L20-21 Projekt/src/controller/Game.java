package controller;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import model.YatzyDice;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    public static boolean[] getHolds(CheckBox[] cbxHolds) {
        boolean[] holds = new boolean[5];
        for (int i = 0; i < cbxHolds.length; i++) {
            holds[i] = cbxHolds[i].isSelected();
        }
        return holds;
    }

    public static boolean allResultsFilled(ArrayList<TextField> txfResults) {
        for (TextField txfResult : txfResults) {
            if (txfResult.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static void updateFields(boolean[] holds, TextField[] txfValues, int[] values) {
        for (int i = 0; i < txfValues.length; i++) {
            if (!holds[i]) {
                txfValues[i].setText(Game.getEye(values[i] - 1));
            }
        }
    }

    public static void lockHolds(CheckBox[] cbxHolds) {
        for (CheckBox cbxHold : cbxHolds) {
            if (cbxHold.isSelected()) {
                cbxHold.setDisable(true);
            }
        }
    }

    public static String getEye(int nextInt) {
        return new String[]{"⚀", "⚁", "⚂", "⚃", "⚄", "⚅"}[nextInt];
    }

    public static void updateResults(ArrayList<TextField> txfResults, YatzyDice dice) {
        int[] values = dice.getResults();
        for (int i = 0; i < txfResults.size(); i++) {
            if (!txfResults.get(i).isDisabled()) {
                txfResults.get(i).setText(String.valueOf(values[i]));
                txfResults.get(i).setStyle("-fx-background-color: yellow");
            }
        }
    }

    public static void resetHolds(CheckBox[] cbxHolds) {
        for (CheckBox cbxHold : cbxHolds) {
            cbxHold.setDisable(false);
            cbxHold.setSelected(false);
        }
    }

    public static void resetDice(TextField[] txfValues) {
        for (TextField txfValue : txfValues) {
            txfValue.setText("?");
        }
    }

    public static void diceAnimation(ArrayList<TextField> txfResults, TextField[] txfValues, CheckBox[] cbxHolds, YatzyDice dice, Button btnThrow) {
        new AnimationTimer() {
            private long time = System.currentTimeMillis();
            private int counter = 0;
            final int[] values = dice.getValues();
            private final Random random = new Random();

            @Override
            public void handle(long l) {
                if (counter == 10) {
                    this.stop();
                    updateFields(getHolds(cbxHolds), txfValues, values);
                    updateResults(txfResults, dice);
                    updateThrowButton(btnThrow, dice.getThrowCount());
                }
                if (System.currentTimeMillis() - time >= 50) {
                    time = System.currentTimeMillis();
                    counter++;
                    for (int i = 0; i < 5; i++) {
                        if (!cbxHolds[i].isSelected()) {
                            txfValues[i].setText(getEye(random.nextInt(6)));
                        }
                    }
                }
            }
        }.start();
    }

    public static void addScore(TextField txf, int result) {
        int score = 0;
        if (txf.getText() != null && !txf.getText().isEmpty()) {
            score = Integer.parseInt(txf.getText());
        }
        score += result;
        txf.setText(String.valueOf(score));
    }

    public static void clearResults(ArrayList<TextField> txfResults) {
        for (TextField txfResult : txfResults) {
            if (!txfResult.isDisabled()) {
                txfResult.setText("");
                txfResult.setStyle("-fx-background-color: white");
            }
        }
    }

    public static void resetResults(ArrayList<TextField> txfResults) {
        for (TextField txfResult : txfResults) {
            txfResult.setText("");
        }
    }

    public static void updateThrowButton(Button btnThrow, int count) {
        if (count == 3) {
            btnThrow.setVisible(false);
        } else {
            btnThrow.setText("Throw " + (count + 1));
            if (!btnThrow.isVisible()) {
                btnThrow.setVisible(true);
            }
        }
    }

    public static void resetScore(TextField txf) {
        txf.setText("");
    }
}
