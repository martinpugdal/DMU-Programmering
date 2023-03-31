package exercise_1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*
          1
         */
        ArrayList<String> stringArrayList = new ArrayList<>();

        /*
          2
         */
        stringArrayList.add("Hans");
        stringArrayList.add("Viggo");
        stringArrayList.add("Jens");
        stringArrayList.add("Bente");
        stringArrayList.add("Bent");
//        stringArrayList.addAll(List.of("Hans", "Viggo", "Jens", "Bente", "Bent");
        
        /*
          3
         */
        System.out.println(stringArrayList.size());

        /*
          4
         */
        stringArrayList.add(2, "Jane");

        /*
          5
         */
        System.out.println(stringArrayList);

        /*
          6
         */
        stringArrayList.remove(1);

        /*
          7
         */
        stringArrayList.add(0, "Pia");

        /*
          8
         */
        stringArrayList.add("Ib");

        /*
          9
         */
        System.out.println(stringArrayList.size());

        /*
          10
         */
        stringArrayList.set(2, "Hansi");

        /*
          11
         */
        System.out.println(stringArrayList.size());

        /*
          12
         */
        for (int i = 0; i < stringArrayList.size(); i++) {
            System.out.println(stringArrayList.get(i).length());
        }

        /*
          13
         */
        for (String s : stringArrayList) {
            System.out.println(s.length());
        }
    }
}