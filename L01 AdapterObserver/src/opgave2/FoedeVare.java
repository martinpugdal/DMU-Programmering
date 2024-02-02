package opgave2;

public class FoedeVare extends Vare {

    private final int moms;

    public FoedeVare(int pris, String navn) {
        super(pris, navn);
        this.moms = 5;
    }

    @Override
    public double beregnMoms() {
        return getPris() * moms / 100.0;
    }
}
