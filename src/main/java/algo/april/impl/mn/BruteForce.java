package algo.april.impl.mn;

import algo.annotations.ComplexityValue;
import algo.annotations.SpaceComplexity;
import algo.annotations.TimeComplexity;
import algo.april.MissingNumber;

import java.util.Arrays;

@SpaceComplexity(ComplexityValue.CONSTANT)
@TimeComplexity(ComplexityValue.QUADRATIC)
public class BruteForce implements MissingNumber {

    @Override
    public int missingNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(!isPresent(nums,i)){
                return i;
            }
        }
        return nums.length;
    }

    private boolean isPresent(int[] nums, int candidate){
        for(int number:nums){
            if(candidate==number){
                return true;
            }
        }
        return false;
    }
}
