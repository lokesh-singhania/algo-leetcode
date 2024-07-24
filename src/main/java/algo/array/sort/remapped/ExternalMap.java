package algo.array.sort.remapped;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ExternalMap extends NumberConversion{
    @Override
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer,Integer> values = new HashMap<>();
        for(int num:nums){
            values.put(num,convert(num,mapping));
        }
        return Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.comparing(values::get))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
