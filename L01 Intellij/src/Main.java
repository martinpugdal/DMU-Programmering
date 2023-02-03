import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //En unavngiven underviser på datamatikeruddannelsen har seks børn: Tre drenge på 6,
        //6 og 8 år og tre piger på 15, 16 og 18 år. På de fleste folkeskoler skal børn i dag
        //medbringe to madpakker hver dag. Underviseren har en husregel om, at man selv
        //smører madpakker fra man er fyldt 10 år. Et folkeskoleår i Danmark har gennemsnitligt
        //200 undervisningsdage.
        program1();
        program2();
        program3();
    }

    public static void program1() {
        //Skriv et program, der beregner gennemsnitsalderen for underviserens børn
        //(hhv. piger, drenge og samlet)
        Person p1 = new Person("male", 6);
        Person p2 = new Person("male", 6);
        Person p3 = new Person("male", 8);
        Person p4 = new Person("female", 15);
        Person p5 = new Person("female", 16);
        Person p6 = new Person("female", 18);
        ArrayList<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);

        Double averageBoys = list.stream().filter(p -> p.getSex().equals("male")).mapToInt(Person::getAge).average().getAsDouble();
        Double averageGirls = list.stream().filter(p -> p.getSex().equals("female")).mapToInt(Person::getAge).average().getAsDouble();
        Double averageAll = list.stream().mapToInt(Person::getAge).average().getAsDouble();
        System.out.println("----------- OPGAVE 1 -----------");
        System.out.println(averageBoys);
        System.out.println(averageGirls);
        System.out.println(averageAll);
    }

    public static void program2() {
        //Skriv et program, der beregner hvor mange madpakker underviseren har smurt til nytår
        //(det kan antages, at alle børn har fødselsdag i juli)
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("male", 6));
        list.add(new Person("male", 6));
        list.add(new Person("male", 8));
        list.add(new Person("female", 15));
        list.add(new Person("female", 16));
        list.add(new Person("female", 18));

        Integer schoolDays = 200;
        Integer lunchesPrDay = 2;

        List<Person> under10YearsOld = list.stream().filter(p -> p.getAge() < 10).collect(Collectors.toList());
        System.out.println("----------- OPGAVE 2 -----------");
        System.out.println(under10YearsOld.size()*schoolDays*lunchesPrDay);
    }

    public static void program3() {
        //Skriv et program, der beregner hvor mange madpakker børnene selv har smurt til nytår
        //(det kan antages, at alle børn har fødselsdag i juli)
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("male", 6));
        list.add(new Person("male", 6));
        list.add(new Person("male", 8));
        list.add(new Person("female", 15));
        list.add(new Person("female", 16));
        list.add(new Person("female", 18));

        Integer schoolDays = 200;
        Integer lunchesPrDay = 2;

        List<Person> Over10YearsOld = list.stream().filter(p -> p.getAge() >= 10).collect(Collectors.toList());
        System.out.println("----------- OPGAVE 3 -----------");
        System.out.println(Over10YearsOld.size()*schoolDays*lunchesPrDay);
    }
}