package exercise_7;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Boys and girls");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final TextField txfName = new TextField();
    private Button btnShowNamesInTabs;
    private static final ArrayList<String> boyNames = new ArrayList<>();
    private static final ArrayList<String> girlNames = new ArrayList<>();
    private final ToggleGroup group = new ToggleGroup();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);


        Label lblName = new Label("Name:");

        Button btnAddName = new Button("Add");
        btnShowNamesInTabs = new Button("Show names");

        HBox box = new HBox();
        TabPane tabPane = TabGui.initContent(new TabPane());

        RadioButton radioButtonBoy = new RadioButton();
        RadioButton radioButtonGirl = new RadioButton();


        box.getChildren().add(radioButtonBoy);
        radioButtonBoy.setText("Boy");
        radioButtonBoy.setUserData("Boy");
        radioButtonBoy.setToggleGroup(group);
        radioButtonBoy.setSelected(true);

        box.getChildren().add(radioButtonGirl);
        radioButtonGirl.setText("Girl");
        radioButtonGirl.setUserData("Girl");
        radioButtonGirl.setToggleGroup(group);

        tabPane.setVisible(!tabPane.isVisible());
        box.setSpacing(10);

        pane.add(box, 1, 0);

        pane.add(lblName, 0, 1);

        pane.add(txfName, 1, 1);

        pane.add(btnAddName, 2, 1);
        pane.add(btnShowNamesInTabs, 1, 2);

        pane.add(tabPane, 1, 3);

        btnAddName.setOnAction(event -> this.addNameAction());
        btnShowNamesInTabs.setOnAction(event -> this.showNamesInTabsAction(tabPane));
    }

    private void showNamesInTabsAction(TabPane tabPane) {
        tabPane.setVisible(!tabPane.isVisible());
        if (tabPane.isVisible()) {
            btnShowNamesInTabs.setText("Hide names");
        } else {
            btnShowNamesInTabs.setText("Show names");
        }
    }

    private void addNameAction() {
        if (!txfName.getText().isEmpty()) {
            if (group.getSelectedToggle().getUserData().equals("Girl")) {
                girlNames.add(txfName.getText());
            } else {
                boyNames.add(txfName.getText());
            }
            TabGui.updateTabs();
            txfName.clear();
            txfName.requestFocus();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No name typed");
            alert.setContentText("Please type a name");
            alert.show();
        }
    }

    public static ArrayList<String> getBoysNames() {
        return boyNames;
    }

    public static ArrayList<String> getGirlsNames() {
        return girlNames;
    }
}
