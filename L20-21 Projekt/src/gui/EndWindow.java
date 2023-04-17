package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EndWindow extends Stage {

    private final Stage mainStage;
    private Label lblScore;

    public EndWindow(String title, Stage stage) {
        this.initOwner(stage);
        this.mainStage = stage;
        this.setMinHeight(350);
        this.setMinWidth(450);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);
        Image image = new Image(getClass().getResource("public/wellplayed.gif").toString(), true);
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, null, null, null, backgroundSize);
        pane.setBackground(new Background(backgroundImage));

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(15));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setAlignment(Pos.CENTER);

        lblScore = new Label();
        lblScore.setStyle("-fx-font-size: 35px; -fx-text-fill: white; -fx-background-color: transparent; -fx-text-alignment: center");
        pane.add(lblScore, 0, 0);

        Button btnPlayAgain = new Button("Play again?");
        btnPlayAgain.setStyle("-fx-font-size: 35px; -fx-text-fill: white; -fx-background-color: transparent; -fx-text-alignment: center");
        pane.add(btnPlayAgain, 0, 1);
        btnPlayAgain.setOnAction(event -> this.playAgain());
    }

    private void playAgain() {
        this.close();
        this.mainStage.show();
    }

    public void gameOver(int totalScore) {
        lblScore.setText("Your score: " + totalScore);
        this.mainStage.close();
        this.show();
    }
}