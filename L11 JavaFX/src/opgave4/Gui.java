package opgave4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        this.initContent(pane);
        Scene scene = new Scene(pane, 400, 400);
        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(Pane pane) {

        Color blackColor = Color.BLACK;

        Rectangle carRectangle = new Rectangle(50, 200-70, 300, 140);
        pane.getChildren().add(carRectangle);
        carRectangle.setFill(Color.DEEPPINK);
        carRectangle.setStroke(blackColor);

        int numberOfWheels = 4;
        int numberOfDoors = 4;
        for (int i = 1; i <= Math.max(numberOfDoors, numberOfWheels); i++) {
            if (i <= numberOfWheels) {
                Circle wheelCircle = new Circle(80*i, 200+80, 30);
                pane.getChildren().add(wheelCircle);
                wheelCircle.setFill(Color.OLIVEDRAB);
                wheelCircle.setStroke(blackColor);
            }
            if (i <= numberOfDoors) {
                Rectangle doorRectangle = new Rectangle(70*i, 200-35, 40, 70);
                pane.getChildren().add(doorRectangle);
                doorRectangle.setFill(Color.BROWN);
                doorRectangle.setStroke(blackColor);
            }
        }
    }
}