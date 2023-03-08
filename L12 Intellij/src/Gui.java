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
        Car car = new Car();
        this.drawCar(pane, car);
        Scene scene = new Scene(pane, 400, 400);

        stage.setTitle("My awesome car!");
        stage.setScene(scene);
        stage.show();
    }

    private void drawCar(Pane pane, Car car) {
        int firstWheelX = 100;
        int firstWheelY = 200;
        int numberOfWheels = car.getWheels();
        int firstDoorX = 110;
        int firstDoorY = 130;
        int numberOfDoors = car.getDoors();
        Color blackColor = Color.BLACK;

        Rectangle body = new Rectangle(70,150,150,50);
        pane.getChildren().add(body);
        body.setFill(car.getColor());

        Rectangle body2 = new Rectangle(100,120,80,30);
        pane.getChildren().add(body2);
        body2.setFill(car.getColor());

        for (int i = 0; i < Math.max(numberOfDoors, numberOfWheels); i++) {
            if (i < numberOfWheels) {
                Circle wheelCircle = new Circle(firstWheelX, firstWheelY, 15);
                pane.getChildren().add(wheelCircle);
                wheelCircle.setFill(Color.OLIVEDRAB);
                wheelCircle.setStroke(blackColor);
                firstWheelX += 30;
            }
            if (i < numberOfDoors) {
                Rectangle doorRectangle = new Rectangle(firstDoorX, firstDoorY, 15, 30);
                pane.getChildren().add(doorRectangle);
                doorRectangle.setFill(Color.BROWN);
                doorRectangle.setStroke(blackColor);
                firstDoorX += 15;
            }
        }
    }
}