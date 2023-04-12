package exercise_6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Exercise 6");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final ArrayList<Slider> sliders = new ArrayList<>();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setStyle("-fx-background: " + "#000000");

        String[] colorNames = {"Red", "Green", "Blue"};
        for (int i = 0; i < colorNames.length; i++) {
            pane.add(new Label(colorNames[i]), 0, i);
            Slider slider = new Slider(0, 255, 0);
            sliders.add(slider);
            pane.add(slider, 1, i);
            slider.valueProperty().addListener(
                    event -> this.sliderValueChanged(pane));
        }
    }

    private void sliderValueChanged(GridPane pane) {
        String color = "#"
            +String.format("%02X", (int) sliders.get(0).getValue())
            +String.format("%02X", (int) sliders.get(1).getValue())
            +String.format("%02X", (int) sliders.get(2).getValue());
        pane.setStyle("-fx-background: " + color);
    }
}
