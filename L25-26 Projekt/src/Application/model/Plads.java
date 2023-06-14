package Application.model;

public class Plads {
    private int række;
    private int nr;
    private final int pris;
    private final PladsType pladsType;

    public Plads(int række, int nr, int pris, PladsType pladsType) {
        this.række = række;
        this.nr = nr;
        this.pris = pris;
        this.pladsType = pladsType;
    }

    public int getRække() {
        return række;
    }

    public int getNr() {
        return nr;
    }

    public int getPris() {
        return pris;
    }

    public PladsType getPladsType() {
        return pladsType;
    }

    public void setRække(int række) {
        this.række = række;
    }

    public void setNummer(int nummer) {
        this.nr = nummer;
    }

    @Override
    public String toString() {
        return "rk: " + række + ", nr: " + nr + ", (kr. " + pris + " " + pladsType + ')' + '\n';
    }
}
