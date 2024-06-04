package biler;

public class Bil {

    private String registreringsnummer;
    private final String mærke;
    private final String model;
    private final String farve;

    public Bil(String registreringsnummer, String mærke, String model, String farve) {
        this.registreringsnummer = registreringsnummer;
        this.mærke = mærke;
        this.model = model;
        this.farve = farve;
    }

    public String getRegistreringsnummer() {
        return registreringsnummer;
    }

    public void setRegistreringsnummer(String registreringsnummer) {
        this.registreringsnummer = registreringsnummer;
    }

    public String getMærke() {
        return mærke;
    }

    public String getModel() {
        return model;
    }

    public String getFarve() {
        return farve;
    }

    @Override
    public String toString() {
        return "Bil{" + "registreringsnummer='" + registreringsnummer + '\'' + ", mærke='" + mærke + '\'' + ", model='" + model + '\'' + ", farve='" + farve + '\'' + '}';
    }

    @Override
    public int hashCode() {
        return registreringsnummer.hashCode() * mærke.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Bil)
            return this.hashCode() == o.hashCode();
        else
            return false;
    }
}
