package algo.array.sort.remapped;

import java.util.Arrays;
import java.util.Comparator;

public class Pair extends NumberConversion{

    @Override
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[][] sortable = new int[n][2];
        return Arrays.stream(nums)
                .mapToObj(num->new int[]{num,convert(num,mapping)})
                .sorted(Comparator.comparing(t->t[1]))
                .mapToInt(t->t[0])
                .toArray();
    }
}
