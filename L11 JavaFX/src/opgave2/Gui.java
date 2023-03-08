package opgave2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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
        int add100toX = 100;
        Color colorGul = Color.YELLOW;
        Color colorBlack = Color.BLACK;

        Circle circle = new Circle(add100toX+70, 70, 30);
        pane.getChildren().add(circle);
        circle.setFill(colorGul);
        circle.setStroke(colorBlack);

        Rectangle rectangle = new Rectangle(add100toX, 100, 50, 80);
        pane.getChildren().add(rectangle);
        rectangle.setFill(colorGul);
        rectangle.setStroke(colorBlack);

        Line line = new Line(add100toX, 190, add100toX + 190, 190);
        line.setStrokeWidth(5);
        pane.getChildren().add(line);
        line.setStroke(colorGul);
    }
}
