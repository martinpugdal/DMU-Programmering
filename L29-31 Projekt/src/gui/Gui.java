package gui;

import gui.panes.DeltagerPane;
import gui.panes.KonferencePane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        KonferencePane root = new KonferencePane();
        stage.setTitle("KAS");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabKonference = new Tab("Konference");
        tabPane.getTabs().add(tabKonference);

        KonferencePane konferencePane = new KonferencePane();
        tabKonference.setContent(konferencePane);
//        tabKonference.setOnSelectionChanged(event -> tabKonference.updateControls());

        Tab tabDeltager = new Tab("Deltager");
        tabPane.getTabs().add(tabDeltager);

        DeltagerPane deltagerPane = new DeltagerPane();
        tabDeltager.setContent(deltagerPane);
//        tabDeltager.setOnSelectionChanged(event -> deltagerPane.updateControls());
    }
}
