package opgave1;

import java.util.List;

public class Calcutator {

    public int sum(List<Integer> list) {
        return sum(list, 0, list.size() - 1);
    }

    int sum(List<Integer> list, int low, int high) {
        int result = 0;
        if (low == high) result = list.get(low);
        else {
            int mid = (low + high) / 2;
            result += sum(list, low, mid);
            result += sum(list, mid + 1, high);
        }
        return result;
    }
}
