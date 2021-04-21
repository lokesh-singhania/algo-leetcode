package algo.april.impl.rsq;

import algo.april.RangeSumQuery;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Naive implements RangeSumQuery {

    private int[] numbers;

    public Naive(int[] nums){
        numbers= Arrays.copyOf(nums,nums.length);
    }

    @Override
    public int sumRange(int left, int right) {
        return IntStream.rangeClosed(left,right)
                .map(i->numbers[i])
                .sum();
    }
}
