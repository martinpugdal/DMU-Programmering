package opgave3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
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

        Circle sunCircle = new Circle(250, 70, 30);
        pane.getChildren().add(sunCircle);
        sunCircle.setFill(Color.YELLOW);
        sunCircle.setStroke(blackColor);

        Rectangle houseRectangle = new Rectangle(50, 250 - 120, 120, 120);
        pane.getChildren().add(houseRectangle);
        houseRectangle.setFill(Color.RED);
        houseRectangle.setStroke(blackColor);

        Line platformLine = new Line(0, 250, 310, 250);
//        platformLine.setStrokeWidth(1);
        pane.getChildren().add(platformLine);
//        platformLine.setStroke(blackColor);

        int centerX = 220 / 2;
        int centerY = 200 / 2;
        double radius = 200 * 0.4;
        double[] roofPoints = new double[6];
        for (int i = 0; i < 3; i++) {
            roofPoints[i * 2] = centerX + radius * Math.sin(i * 2 * Math.PI / 3);
            roofPoints[i * 2 + 1] = centerY - radius * Math.cos(i * 2 * Math.PI / 3);
        }
        Polygon roofPolygon = new Polygon(roofPoints);
        roofPolygon.setFill(Color.GREEN);
        roofPolygon.setStroke(blackColor);
        pane.getChildren().add(roofPolygon);

        Rectangle windowRectangle = new Rectangle(60, 200-45, 45, 45);
        pane.getChildren().add(windowRectangle);
        windowRectangle.setFill(Color.BEIGE);
        windowRectangle.setStroke(blackColor);

        Rectangle doorRectangle = new Rectangle(120, 250-70, 40, 70);
        pane.getChildren().add(doorRectangle);
        doorRectangle.setFill(Color.BROWN);
        doorRectangle.setStroke(blackColor);

    }
}