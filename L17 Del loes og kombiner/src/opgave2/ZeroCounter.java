package opgave2;

import java.util.ArrayList;
import java.util.List;

public class ZeroCounter {

    public int countZero(List<Integer> list) {
        return countZero(list, 0, list.size() - 1);
    }

    private int countZero(List<Integer> list, int low, int high) {
        if (low == high) {
            if (list.get(low) == 0) return 1;
            else return 0;
        } else {
            int mid = (low + high) / 2;
            int sum1 = countZero(list, low, mid);
            int sum2 = countZero(list, mid + 1, high);
            return sum1 + sum2;
        }
    }
}
