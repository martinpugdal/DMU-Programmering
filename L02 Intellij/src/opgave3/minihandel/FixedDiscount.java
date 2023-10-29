package opgave3.minihandel;

import lombok.Getter;

public class FixedDiscount extends Discount {

    private final double fixedDiscount;
    @Getter
    private final int discountLimit;

    public FixedDiscount(double fixedDiscount, int discountLimit) {
        super();
        this.fixedDiscount = fixedDiscount;
        this.discountLimit = discountLimit;
    }

    @Override
    public double getDiscount(double price) {
        if (price > discountLimit) {
            return fixedDiscount;
        } else {
            return 0;
        }
    }
}
