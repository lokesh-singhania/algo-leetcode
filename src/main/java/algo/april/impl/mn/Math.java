package algo.april.impl.mn;

import algo.annotations.ComplexityValue;
import algo.annotations.Remarks;
import algo.annotations.SpaceComplexity;
import algo.annotations.TimeComplexity;
import algo.april.MissingNumber;

import java.util.Arrays;

@Remarks("Overflow possible")
@TimeComplexity(ComplexityValue.LINEAR)
@SpaceComplexity(ComplexityValue.CONSTANT)
public class Math implements MissingNumber {

    @Override
    public int missingNumber(int[] nums) {
        int sum= Arrays.stream(nums)
                .sum();
        return firstNSum(nums.length) - sum;
    }

    private int firstNSum(int n) {
        return n*(n+1)/2;
    }
}
