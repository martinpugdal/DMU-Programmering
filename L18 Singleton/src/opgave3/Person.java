package opgave3;

public class Person {

    private final String navn;

    public Person(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return "Person{" +
                "navn='" + navn + '\'' +
                '}';
    }
}
