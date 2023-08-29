package opgave2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mekaniker extends Person {

    private int svendeprøve;
    private double timeløn;

    public Mekaniker(String navn, String adresse, int svendeprøve, double timeløn) {
        super(navn, adresse);
        this.svendeprøve = svendeprøve;
        this.timeløn = timeløn;
    }

    public double beregnLoen() {
        return timeløn * 37;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
