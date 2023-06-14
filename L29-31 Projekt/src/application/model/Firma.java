package application.model;

public class Firma {
    private String navn;
    private String cvr;
    private String tlfNr;

    public Firma(String navn, String cvr, String tlfNr) {
        this.navn = navn;
        this.cvr = cvr;
        this.tlfNr = tlfNr;
    }

    public String getNavn() {
        return navn;
    }

    public String getCvr() {
        return cvr;
    }

    public String getTlfNr() {
        return tlfNr;
    }

    @Override
    public String toString() {
        return navn + ", CVR: " + cvr + ", Tlf: " + tlfNr;
    }

}
