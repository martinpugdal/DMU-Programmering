package exercise_3;

import guides.demotwowindows.Movie;
import guides.demotwowindows.MovieInputWindow;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;

;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Person administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        personWindow = new PersonInputWindow("Create a person", stage);
    }

    // -------------------------------------------------------------------------

    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();

    private PersonInputWindow personWindow;


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);


        Label lblPersons = new Label("Persons:");

        Button btnAddPerson = new Button("Add person");


        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);


        pane.add(lblPersons, 0, 0);

        pane.add(btnAddPerson, 1, 1);

        pane.add(lvwPersons, 0, 1);

        GridPane.setValignment(btnAddPerson, VPos.TOP);
        GridPane.setMargin(btnAddPerson, new Insets(10, 10, 0, 10));

        btnAddPerson.setOnAction(event -> {

            personWindow.showAndWait();
            Person person = personWindow.getPerson();
            if (person != null) {
                persons.add(person);
                lvwPersons.getItems().setAll(persons);
            }
        });
    }
}
