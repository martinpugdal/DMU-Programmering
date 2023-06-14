package application.model;

import java.util.ArrayList;

public class Ledsager extends Person {

    private ArrayList<Aktivitet> aktiviteter = new ArrayList<>();
    private Deltager deltager;

    Ledsager(String navn, Deltager deltager) {
        super(navn);
        this.deltager = deltager;
    }

    public ArrayList<Aktivitet> getAktiviteter() {
        return new ArrayList<>(aktiviteter);
    }

    public void addAktivitet(Aktivitet aktivitet) {
        if (!aktiviteter.contains(aktivitet)) {
            aktiviteter.add(aktivitet);
            aktivitet.addLedsager(this);
        }
    }

    public void removeAktivitet(Aktivitet aktivitet) {
        if (aktiviteter.contains(aktivitet)) {
            aktiviteter.remove(aktivitet);
            aktivitet.removeLedsager(this);
        }
    }

    public boolean hasAktivitet(Aktivitet aktivitet) {
        return aktiviteter.contains(aktivitet);
    }

    @Override
    public String toString() {
        return super.toString() + " (" + deltager.getNavn() + ", " + deltager.getTlfNr() + ")";
    }
}
