package opgave2;

public class AnvendCounter {

    public static void main(String[] args) {
        Counter counter = Counter.getInstance();

        counter.printValue();

        counter.count();

        counter.printValue();

        counter.times2();

        counter.printValue();

        counter.times2();

        counter.printValue();

        counter.zero();

        counter.printValue();
    }
}
