package navigation;

public class NavigationItem extends NavigationComponent {
    private final String link;

    public NavigationItem(String name, String link) {
        super(name);
        this.link = link;
    }

    @Override
    public String getLink() {
        return link;
    }

    @Override
    public void print() {
        System.out.println(" --> Item: " + getName() + " (" + getLink() + ")");
    }
}
