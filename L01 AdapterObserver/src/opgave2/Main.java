package opgave2;

public class Main {

    public static void main(String[] args) {

        Spiritus spiritus = new Spiritus(100, "Vodka");
        SpiritusAdapter spiritusAdapter = new SpiritusAdapter(spiritus);

        Vare foedeVare = new FoedeVare(12, "Vodka");
        Vare elVare = new ElVare(40, "Vodka");

        testMoms(spiritusAdapter);
        testMoms(foedeVare);
        testMoms(elVare);

    }


    private static void testMoms(Moms moms) {
        System.out.println(moms.beregnMoms());
    }
}
