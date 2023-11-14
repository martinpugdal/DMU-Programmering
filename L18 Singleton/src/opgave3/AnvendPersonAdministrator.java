package opgave3;

public class AnvendPersonAdministrator {

    public static void main(String[] args) {
        PersonAdministrator pa = PersonAdministrator.getInstance();
        Person p1 = new Person("Martin");
        Person p2 = new Person("Thomas");

        pa.add(p1);
        pa.add(p2);
        System.out.println(pa.getPersoner());

        pa.remove(p1);
        System.out.println(pa.getPersoner());
    }
}
