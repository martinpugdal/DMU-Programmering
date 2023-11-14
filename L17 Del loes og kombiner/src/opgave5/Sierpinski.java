package opgave5;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Sierpinski extends Application {

    Pane pane;
    int nrOfOrder;

    @Override
    public void start(Stage stage) {
        pane = new Pane();
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        BackgroundFill backgroundFill = new BackgroundFill(Color.WHITE, null, null);
        borderPane.setBackground(new Background(backgroundFill));

        TextField input = new TextField();
        input.setOnAction(a -> {
            try {
                nrOfOrder = Integer.parseInt(input.getText());
                paintTriangle(nrOfOrder);
            } catch (NumberFormatException ignored) {
            }
        });
        borderPane.widthProperty().addListener(event -> {
                    pane.getChildren().clear();
                    paintTriangle(nrOfOrder);
                }
        );
        borderPane.heightProperty().addListener(event -> {
                    pane.getChildren().clear();
                    paintTriangle(nrOfOrder);
                }
        );
        Label label = new Label("order: ");

        HBox bottom = new HBox(10);
        bottom.getChildren().addAll(label, input);
        bottom.setAlignment(Pos.CENTER);
        borderPane.setBottom(bottom);

        Scene scene = new Scene(borderPane, 600, 600);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setMaximized(true);
        stage.setTitle("Sierpinski Triangle");
        stage.show();
    }

    public void paintTriangle(int order) {
        int y = 17;
        pane.getChildren().clear();
        Point2D point1 = new Point2D(pane.getWidth() / 2, y);
        Point2D point2 = new Point2D(pane.getWidth() - y, pane.getHeight() - y * 3);
        Point2D point3 = new Point2D(y, pane.getHeight() - y * 3);
        drawTriangles(order, point1, point2, point3);
    }

    public void drawTriangles(int order, Point2D point1, Point2D point2, Point2D point3) {
        if (order == 0) {
            Polygon triangle = new Polygon(
                    point1.getX(), point1.getY(),
                    point2.getX(), point2.getY(),
                    point3.getX(), point3.getY()
            );
            triangle.setFill(Color.WHITE);
            triangle.setStroke(Color.BLACK);
            pane.getChildren().add(triangle);
        } else {
            drawTriangles(
                    order - 1,
                    point1.midpoint(point1),
                    point1.midpoint(point2),
                    point1.midpoint(point3)
            );
            drawTriangles(
                    order - 1,
                    point2.midpoint(point1),
                    point2.midpoint(point2),
                    point2.midpoint(point3)
            );
            drawTriangles(
                    order - 1,
                    point3.midpoint(point1),
                    point3.midpoint(point2),
                    point3.midpoint(point3)
            );
        }
    }
}