import java.util.ArrayList;

public class WhiskeyStore {

    private ArrayList whiskies;

    public WhiskeyStore() {
        this.whiskies = new ArrayList<>();
    }

    public ArrayList getWhiskies() {
        return new ArrayList<>(whiskies);
    }

    public void addWhisky(Object whisky) {
        if (whisky instanceof Whiskey) {
            whiskies.add(whisky);
        } else if (whisky instanceof Whisky) {
            whiskies.add(new WhiskeyAdapter((Whisky) whisky).getWhisky());
        }
    }
}
