package opgave1;

import java.util.ArrayList;
import java.util.List;

public class Kunde {

    private final String navn;
    private final List<BogTitel> bogTitelList = new ArrayList<>();

    public Kunde(String navn) {
        this.navn = navn;
    }

    public void addBogTitel(BogTitel bogTitel) {
        bogTitelList.add(bogTitel);
    }

    public List<BogTitel> getBogTitelList() {
        return bogTitelList;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + navn;
    }
}
