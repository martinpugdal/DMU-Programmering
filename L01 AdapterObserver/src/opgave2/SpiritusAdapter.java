package opgave2;

public class SpiritusAdapter implements Moms {

    private final Spiritus spiritus;

    public SpiritusAdapter(Spiritus spiritus) {
        this.spiritus = spiritus;
    }

    @Override
    public double beregnMoms() {
        return spiritus.hentMoms();
    }
}
