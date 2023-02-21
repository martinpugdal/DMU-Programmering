package exercise1;

import java.sql.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //a
        int[] aList = new int[10];
        System.out.println(Arrays.toString(aList));

        //b
        int[] bList = new int[]{2,44,-23,99,8,-5,7,10,20,30};
        System.out.println(Arrays.toString(bList));

        //c
        int[] cList = new int[10];
        for (int i = 0; i < 10; i++) {
            cList[i] = i;
        }
        System.out.println(Arrays.toString(cList));

        //d
    }
}
