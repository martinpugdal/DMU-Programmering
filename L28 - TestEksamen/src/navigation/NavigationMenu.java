package navigation;

public class NavigationMenu extends NavigationComponent {

    public NavigationMenu(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.println("Menu: " + getName());
        for (NavigationComponent component : getChildren()) {
            component.print();
        }
    }
}
