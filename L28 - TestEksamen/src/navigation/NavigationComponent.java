package navigation;

import java.util.ArrayList;

public abstract class NavigationComponent {

    private final String name;
    private final ArrayList<NavigationComponent> children = new ArrayList<>();

    public NavigationComponent(String name) {
        this.name = name;
    }

    public void addChild(NavigationComponent navigationComponent) {
        children.add(navigationComponent);
    }

    public ArrayList<NavigationComponent> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}
