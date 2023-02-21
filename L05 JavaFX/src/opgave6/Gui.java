package opgave6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

	@Override
	public void start(Stage stage) {
		GridPane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Loops");
		stage.setScene(scene);
		stage.show();
	}

	private GridPane initContent() {
		GridPane pane = new GridPane();
		Canvas canvas = new Canvas(200, 200);
		pane.add(canvas, 0, 0);
		this.drawShapes(canvas.getGraphicsContext2D());
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(GraphicsContext gc) {
		int x1 = 10; // start point: (x,y1)
		int x2 = 180;
		int y1 = 180, y2 = 180; // end point: (x,y2)
		gc.strokeLine(x1, y1, x2, y2);
		y1 = 170;
		y2 = 190;
		for (int i = 0; i < 11; i++) {
			int x = 10 + i * 16;
			gc.strokeLine(x, y1, x, y2);
		}
		x1 = 180;
		y1 = 180;
		int factor = 1;
		int sizeX = 10*factor;
		int sizeY = 4*factor;
		// draw an arrowhead at (100,75)
		gc.strokeLine(x1, y1, x1 - sizeX, y1 - sizeY);
		gc.strokeLine(x1, y1, x1 - sizeX, y1 + sizeY);
	}
}
