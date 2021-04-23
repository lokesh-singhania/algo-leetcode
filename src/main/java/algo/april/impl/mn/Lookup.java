package algo.april.impl.mn;

import algo.annotations.ComplexityValue;
import algo.annotations.SpaceComplexity;
import algo.annotations.TimeComplexity;
import algo.april.MissingNumber;


@SpaceComplexity(ComplexityValue.LINEAR)
@TimeComplexity(ComplexityValue.LINEAR)
public class Lookup implements MissingNumber {

    @Override
    public int missingNumber(int[] numbers) {
        boolean[] present=new boolean[numbers.length+1];
        for(int n:numbers){
            present[n]=true;
        }
        for(int i=0;i<present.length;i++){
            if(!present[i]){
                return i;
            }
        }
        return -1;
    }
}
