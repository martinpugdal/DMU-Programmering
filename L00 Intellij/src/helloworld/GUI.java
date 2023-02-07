package helloworld;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GUI extends Application {

    private HelloWorld world;

    public GUI(String[] args, HelloWorld world) {
        this.world = world;
        main(args);
    }
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText(String.format("Say '%s'", this.world.getName()));
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(GUI.this.world.toString());
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle(this.world.toString());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
