package algo.array.sort.remapped;

import java.util.Arrays;
import java.util.Comparator;


public class Convert extends NumberConversion {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.comparing(n->convert(n,mapping)))
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
