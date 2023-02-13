public class ChildApp {

        public static void main(String[] args) {
        System.out.println("Et barn på 5 skal i " + institution(5));
        System.out.println("Et barn på 9 skal i " + institution(9));
        System.out.println("Et barn på 17 skal i " + institution(17));

        System.out.println("Et dreng på 2 skal i " + team(true,2));
        System.out.println("Et dreng på 8 skal i " + team(true,8));
        System.out.println("En pige på 12 skal i " + team(false,12));
    }

   // Metoden skal returenre en tekststreng der beskriver hvilken institution et barn skal gå i, afhængig af barnets alder.
   // Reglerne for dette kan ses på opgavedsedlen
    public static String institution(int age) {
        if (age == 0) {
            return "Home";
        } else if (age < 3) {
            return "Nursery";
        } else if (age < 6) {
            return "Kindergarten";
        } else if (age < 16) {
            return "School";
        } else {
            return "Out of school";
        }
    }

    // Metoden skal returenre en tekststreng der beskriver hvilket gymnastikhold et barn skal gå på, afhængig af barnets alder og køn.
    // Reglerne for dette kan ses på opgavedsedlen
    public static String team(boolean isBoy, int age) {
        if (isBoy) {
            if (age < 8) {
                return "Young cubs";
//            } else if (age >= 8) {
            } else {
                return "Cool boys";
            }
//        } else if (!isBoy) {
        } else {
            if (age < 8) {
                return "Tumbling girls";
//            } else if (age >= 8) {
            } else {
                return "Springy girls";
            }
        }
    }
}
