package opgave2;

public class Counter {

    private static Counter instance = new Counter();
    private int counter = 0;

    public static Counter getInstance() {
        return instance;
    }

    public void count() {
        counter++;
    }

    public void times2() {
        counter *= 2;
    }

    public void zero() {
        counter = 0;
    }

    public int getValue() {
        return counter;
    }

    public void printValue() {
        System.out.println("Nuværende tal: " + counter);
    }
}
