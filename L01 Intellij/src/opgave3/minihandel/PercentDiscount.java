package opgave3.minihandel;

public class PercentDiscount extends Discount {

    private final double percent;

    public PercentDiscount(double percent) {
        super();
        this.percent = percent;
    }

    @Override
    public double getDiscount(double price) {
        return price * percent / 100;
    }
}
