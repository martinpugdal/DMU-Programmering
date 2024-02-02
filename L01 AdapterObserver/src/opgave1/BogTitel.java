package opgave1;

import java.util.ArrayList;
import java.util.List;

public class BogTitel implements Subject {

    private final String titel;
    private int antal;
    private final List<Kunde> kunder = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    public BogTitel(String titel, int antal) {
        this.titel = titel;
        this.antal = antal;
    }

    public List<Kunde> getKunder() {
        return kunder;
    }

    public String getTitel() {
        return titel;
    }

    public int getAntal() {
        return antal;
    }

    public void indkoebTilLager(int antal) {
        this.antal += antal;
        notifyObservers();
    }

    public void etKoeb(Kunde kunde) {
        kunder.add(kunde);
        kunde.addBogTitel(this);
        antal--;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + titel;
    }
}
