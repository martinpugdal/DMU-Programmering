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

        Circle circle = new Circle(250, 70, 30);
        pane.getChildren().add(circle);
        circle.setFill(Color.YELLOW);
        circle.setStroke(Color.BLACK);

        Rectangle rectangle = new Rectangle(50, 250 - 120, 120, 120);
        pane.getChildren().add(rectangle);
        rectangle.setFill(Color.RED);
        rectangle.setStroke(Color.BLACK);

        Line line = new Line(0, 250, 310, 250);
        line.setStrokeWidth(1);
        pane.getChildren().add(line);
        line.setStroke(Color.BLACK);

        double centerX = 220 / 2;
        double centerY = 200 / 2;
        double radius = 200 * 0.4;

        double[] points = new double[6];
        for (int i = 0; i < 3; i++) {
            points[i * 2] = centerX + radius * Math.sin(i * 2 * Math.PI / 3); // x value
            points[i * 2 + 1] = centerY - radius * Math.cos(i * 2 * Math.PI / 3); // y value
        }

        Polygon polygon = new Polygon(points);
        // Polyline polygon = new Polyline(points);
        polygon.setFill(Color.GREEN);
        polygon.setStroke(Color.BLACK);
        pane.getChildren().add(polygon);

        Rectangle window = new Rectangle(60, 200-45, 45, 45);
        pane.getChildren().add(window);
        window.setFill(Color.BEIGE);
        window.setStroke(Color.BLACK);

        Rectangle door = new Rectangle(120, 250-70, 40, 70);
        pane.getChildren().add(door);
        door.setFill(Color.BROWN);
        door.setStroke(Color.BLACK);
    }
}