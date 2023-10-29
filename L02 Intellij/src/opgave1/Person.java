package opgave1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private String navn;
    private String adresse;

    public Person(String navn, String adresse) {
        this.navn = navn;
        this.adresse = adresse;
    }
}
