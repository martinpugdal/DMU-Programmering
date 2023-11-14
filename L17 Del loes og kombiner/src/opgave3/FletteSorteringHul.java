package opgave3;

import java.util.ArrayList;

public class FletteSorteringHul {

    // den metode der saetter fletningen i gang
    public void fletteSort(ArrayList<Integer> list) {
        mergesort(list, 0, list.size() - 1);
    }

    // den rekursive metode der implementere del-loes og kombiner skabelonen
    private void mergesort(ArrayList<Integer> list, int l, int h) {
        if (l < h) {
            int m = (l + h) / 2;
            mergesort(list, l, m);
            mergesort(list, m + 1, h);
            merge(list, l, m, h);
        }
    }

    // kombiner er realiseret ved fletteskabelonen
    private void merge(ArrayList<Integer> list, int low, int middle, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int i = low;
        int j = middle + 1;

        // kontrol
        while (i <= middle && j <= high) {
            int first = list.get(i);
            int second = list.get(j);

            if (first < second) {
                temp.add(first);
                i++;
            } else {
                temp.add(second);
                j++;
            }
        }

        //overfør resten af venstre side til temp.
        while (i <= middle) {
            temp.add(list.get(i));
            i++;
        }
        //overfør resten af højre side til temp.
        while (j <= high) {
            temp.add(list.get(j));
            j++;
        }

        // overwrite temp med originale liste.
        /*list.clear();
        list.addAll(temp);*/
        for (int k = 0; k < temp.size(); k++) {
            list.set(low + k, temp.get(k));
        }
    }

}
