package opgave3;

public class Test {

    public static void main(String[] args) {

            final Skole skole = new Skole("Skole");

            final Studerende s1 = new Studerende("Søren", 1);
            s1.addKarakter(7);
            s1.addKarakter(10);
            s1.addKarakter(12);
            skole.addStuderende(s1);

            final Studerende s2 = new Studerende("Hans", 2);
            s2.addKarakter(7);
            s2.addKarakter(10);
            s2.addKarakter(12);
            skole.addStuderende(s2);

            final Studerende s3 = new Studerende("Jens", 3);
            s3.addKarakter(7);
            s3.addKarakter(10);
            s3.addKarakter(12);
            skole.addStuderende(s3);

            final Studerende s4 = new Studerende("Jørgen", 4);
            s4.addKarakter(7);
            s4.addKarakter(10);
            s4.addKarakter(12);
            skole.addStuderende(s4);

            final Studerende s5 = new Studerende("Per", 5);
            s5.addKarakter(7);
            s5.addKarakter(-3);
            skole.addStuderende(s5);

            System.out.println(skole.gennemsnit());

            System.out.println(skole.findStuderende(3));

            System.out.println(skole);

            System.out.println(skole.getStuderende());
    }
}
