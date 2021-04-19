package algo.april.impl.hw;

import algo.april.HammingWeight;

import java.util.stream.IntStream;

public class Masking implements HammingWeight {
    @Override
    public int hammingWeight(int n) {
        int weight=0;
        for(int mask=1;mask!=0;mask<<=1){
            if((mask&n)==mask){
                weight++;
            }
        }

        return weight;
    }
}
