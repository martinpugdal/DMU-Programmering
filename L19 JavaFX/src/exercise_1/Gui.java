package exercise_1;
;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Person administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextField txtTitle = new TextField();
    private final CheckBox checkBoxSenior = new CheckBox("Senior");
    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);


        Label lblName = new Label("Name:");
        Label lblTitle = new Label("Title:");
        Label lblPersons = new Label("Persons:");

        Button btnAddPerson = new Button("Add person");


        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);
        GridPane.setValignment(lblPersons, VPos.TOP);


        pane.add(lblName, 0, 0);
        pane.add(lblTitle, 0, 1);
        pane.add(lblPersons, 0, 3);

        pane.add(txfName, 1, 0);
        pane.add(txtTitle, 1, 1);

        pane.add(checkBoxSenior, 1, 2);

        pane.add(btnAddPerson, 2, 2);

        pane.add(lvwPersons, 1, 3);


        btnAddPerson.setOnAction(event -> addPerson());
    }

    private void addPerson() {
        persons.add(new Person(txfName.getText(), txtTitle.getText(), checkBoxSenior.isSelected()));
        lvwPersons.getItems().setAll(persons);
    }
}
