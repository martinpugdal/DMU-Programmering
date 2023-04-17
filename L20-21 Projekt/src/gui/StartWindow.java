package gui;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.YatzyDice;

import java.util.Random;

public class StartWindow extends Stage {

    private final Stage mainStage;

    public StartWindow(String title, Stage stage) {
//        this.initOwner(owner);
        this.mainStage = stage;
        this.setMinHeight(350);
        this.setMinWidth(450);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);
        Image image = new Image(getClass().getResource("public/yatzyBackground.png").toString(), true);
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, null, null, null, backgroundSize);
        pane.setBackground(new Background(backgroundImage));

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setAlignment(Pos.BOTTOM_CENTER);

        Button btnPlay = new Button("Start".toUpperCase());
        btnPlay.setStyle("-fx-font-size: 35px; -fx-text-fill: white; -fx-background-color: transparent");
        btnPlay.setOnAction(event -> this.startGame());
        pane.add(btnPlay, 0, 0);
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void startGame() {
        StartWindow.this.close();
        this.mainStage.show();
    }

}