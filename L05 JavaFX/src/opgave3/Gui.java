package opgave3;

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
		//figure 1
//		int f1_x1 = 20; // start point: (x1,y1)
//		int f1_y1 = 20;
//		int f1_x2 = 20; // end point: (x2,y2)
//		int f1_y2 = 180;
//		while (f1_x1 <= 180) {
//			gc.strokeLine(f1_x1, f1_y1, f1_x2, f1_y2);
//			f1_x1 = f1_x1 + 40;
//			f1_x2 = f1_x2 + 40;
//		}

		//figure 2
//		int f2_x1 = 20; // start point: (x1,y1)
//		int f2_y1 = 20;
//		int f2_x2 = 180; // end point: (x2,y2)
//		int f2_y2 = 20;
//		while (f2_y1 <= 180) {
//			gc.strokeLine(f2_x1, f2_y1, f2_x2, f2_y2);
//			f2_y1 = f2_y1 + 40;
//			f2_y2 = f2_y2 + 40;
//		}

		//figure 3
		int f3_x1 = 20; // start point: (x1,y1)
		int f3_y1 = 180;
		int f3_x2 = 180; // end point: (x2,y2)
		int f3_y2 = 180;
		int times = 5;
		while (f3_y1 > 0) {
			System.out.println(f3_y1);
			gc.strokeLine(f3_x1, f3_y1, f3_x2, f3_y2);
			f3_y1 -= 40;
			f3_y2 -= 40;
			f3_x1 += 180/(times*2);
			f3_x2 -= 180/(times*2);
		}
	}
}
