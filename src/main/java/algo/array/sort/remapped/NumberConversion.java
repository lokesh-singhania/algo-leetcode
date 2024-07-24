package algo.array.sort.remapped;

import algo.array.SortJumbled;

public abstract class NumberConversion implements SortJumbled {
    int convert(int n, int[] mapping) {
        if (n == 0) {
            return mapping[0];
        }
        int num = 0;
        while (n > 0) {
            int d = n % 10;
            num = num * 10 + mapping[d];
            n /= 10;
        }
        return num;
    }
}
