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
        int[] dList = new int[10];
        for (int i = 1; i <= 10; i++) {
            dList[i-1] = i*2;
        }
        System.out.println(Arrays.toString(dList));

        //e
        int[] eList = new int[10];
        for (int i = 1; i <= 10; i++) {
            eList[i-1] = i*i;
        }
        System.out.println(Arrays.toString(eList));

        //f
        int[] fList = new int[10];
        for (int i = 1; i < 10; i+= 2) {
            fList[i] = 1;
        }
        System.out.println(Arrays.toString(fList));

        //g
        int[] gList = new int[10];
        for (int i = 0; i < 10; i++) {
            gList[i] = (i < 5) ? i : i-5;
        }
        System.out.println(Arrays.toString(gList));

        //h
        int[] hList = new int[10];
        for (int i = 1; i <= 10; i++) {
            hList[i] = (i%2 == 0) ? hList[i-1]+3 : hList[i-1]+1;
        }
        System.out.println(Arrays.toString(hList));
    }
}
