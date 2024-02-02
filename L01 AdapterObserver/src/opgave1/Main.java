package opgave1;

public class Main {

    public static void main(String[] args) {

        Saelger saelgerHansen = new Saelger("Hansen");

        Indkoeber indkoeberJensen = new Indkoeber("Jensen");

        BogTitel bogTitelAndersAnd = new BogTitel("Anders And", 6);
        BogTitel bogTitelJava = new BogTitel("Java", 8);

        Kunde kundeLæsehest1 = new Kunde("Læsehest1");
        Kunde kundeLæsehest2 = new Kunde("Læsehest2");
        Kunde kundeLæsehest3 = new Kunde("Læsehest3");


        bogTitelAndersAnd.addObserver(saelgerHansen);
        bogTitelJava.addObserver(saelgerHansen);

        bogTitelAndersAnd.addObserver(indkoeberJensen);
        bogTitelJava.addObserver(indkoeberJensen);

        bogTitelAndersAnd.etKoeb(kundeLæsehest1);
        bogTitelAndersAnd.etKoeb(kundeLæsehest2);
        bogTitelAndersAnd.etKoeb(kundeLæsehest3);

        bogTitelJava.etKoeb(kundeLæsehest1);
        bogTitelJava.etKoeb(kundeLæsehest2);
        bogTitelJava.etKoeb(kundeLæsehest3);
    }
}
