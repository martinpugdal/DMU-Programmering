package Application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Forestilling {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;
    private final ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Forestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public ArrayList<Bestilling> getBestillinger() {
        return new ArrayList<>(bestillinger);
    }

    public Bestilling createBestilling(LocalDate dato, Kunde kunde) {
        Bestilling bestilling = new Bestilling(dato, this, kunde);
        bestillinger.add(bestilling);
        return bestilling;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    @Override
    public String toString() {
        return navn + " (" + startDato + " til " + slutDato + ")";
    }

    public boolean erPladsLedig(int række, int nr, LocalDate dato) {
        Boolean ledig = true;
        for (Bestilling bestilling : bestillinger) {
            if (bestilling.getDato().equals(dato)) {
                for (Plads plads : bestilling.getPladser()) {
                    if (plads.getRække() == række && plads.getNr() == nr && ledig) {
                        ledig = false;
                        break;
                    }
                }
            }
        }
        return ledig;
    }

    public LocalDate succesDato() {
        LocalDate succesDato = startDato;
        int pladsAntal = 0;
        for (Bestilling bestilling : bestillinger) {
            if (bestilling.getPladser().size() > pladsAntal) {
                pladsAntal = bestilling.getPladser().size();
                succesDato = bestilling.getDato();
            }
        }
        return succesDato;
    }

    public int antalBestiltePladserPåDag(LocalDate dato) {
        int antal = 0;
        for (Bestilling bestilling : bestillinger) {
            if (bestilling.getDato().equals(dato)) {
                antal += bestilling.getPladser().size();
            }
        }
        return antal;
    }
}
