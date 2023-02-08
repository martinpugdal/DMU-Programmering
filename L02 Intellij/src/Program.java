import java.util.ArrayList;
import java.util.Arrays;

public class Program
{
    public static void main(String[] arg) {
        String ord1 = getWords().get(0);
        String ord2 = getWords().get(1);
        String ord3 = getWords().get(2);

        System.out.println("a) Færdiggør programmet så det udskriver ord1 med store bogstaver.");
        System.out.println(ord1.toUpperCase());


        System.out.println("b) Færdiggør programmet så det udskriver ord2 med små bogstaver.");
        System.out.println(ord2.toLowerCase());


        System.out.println("c)  Færdiggør programmet så det sammensætter ord1 og ord2 med et mellemrum imellem og udskriver resultatet.");
        System.out.printf("%s  %s%n", ord1,ord2);


        System.out.println("d) Færdiggør programmet så det i en ny streng, ord3, sammensætter ord1 og ord2, hvor ord2 er med små bogstaver. Udskriv resultatet.");
        System.out.println(ord3);


        System.out.println("e) Udskriv længden af strengen fra opgave d).");
        System.out.println(ord3.length());


        System.out.println("f)  Udskriv de første 7 bogstaver af ord1.");
        System.out.println(ord1.substring(0, 7));


        System.out.println("g) Udskriv bogstav 3-7 fra ord2.");
        System.out.println(ord2.substring(2, 7));


        System.out.println("h) Udskriv den sidste halvdel af strengen fra opgave d).");
        System.out.println(ord3.substring(ord3.length() / 2));
    }

    private static ArrayList<String> getWords() {
        String ord1 = "Datamatiker";
        String ord2 = "Uddannelsen";
        String ord3 = ord1 + ord2.toLowerCase();
        return new ArrayList<>(Arrays.asList(ord1, ord2, ord3));
    }
}