package opgave2;

public class ElVare extends Vare {

    private final int moms;

    public ElVare(int pris, String navn) {
        super(pris, navn);
        this.moms = 30;
    }

    @Override
    public double beregnMoms() {
        double calculatedMoms = getPris() * moms / 100.0;
        return calculatedMoms > 3 ? calculatedMoms : 3;
    }
}
