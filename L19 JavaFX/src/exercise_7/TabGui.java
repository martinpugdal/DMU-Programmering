package exercise_7;

import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TabGui {

    private static final ListView<String> lvwBoysNames = new ListView<>();
    private static final ListView<String> lvwGirlsNames = new ListView<>();

    public static TabPane initContent(TabPane tabPane) {
        Tab boyTab = new Tab();
        boyTab.setText("Boys tab");
        boyTab.setContent(lvwBoysNames);
        boyTab.setClosable(false);
        boyTab.setGraphic(new Rectangle(10 , 10, Color.AQUA));
        tabPane.getTabs().add(boyTab);

        Tab girlTab = new Tab();
        girlTab.setText("Girls tab");
        girlTab.setContent(lvwGirlsNames);
        girlTab.setClosable(false);
        girlTab.setGraphic(new Rectangle(10 , 10, Color.PINK));
        tabPane.getTabs().add(girlTab);
        return tabPane;
    }

    public static void updateTabs() {
        lvwBoysNames.getItems().setAll(Gui.getBoysNames());
        lvwGirlsNames.getItems().setAll(Gui.getGirlsNames());
    }
}
