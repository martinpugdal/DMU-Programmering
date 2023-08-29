package opgave2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Værkfører extends Mekaniker {

    private int udnævnelse;
    private double tillæg;

    public Værkfører(String navn, String adresse, int svendeprøve, double timeløn, int udnævnelse, double tillæg) {
        super(navn, adresse, svendeprøve, timeløn);
        this.udnævnelse = udnævnelse;
        this.tillæg = tillæg;
    }

    @Override
    public double beregnLoen() {
        return super.beregnLoen() * tillæg;
    }
}
