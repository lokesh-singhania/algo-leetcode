package algo.april.impl.ftz;

import algo.april.FactorialTrailingZeroes;

public class Elegant implements FactorialTrailingZeroes {
    @Override
    public int trailingZeroes(int number) {
        int count=0;
        while(number>0){
            number=number/5;
            count+=number;
        }
        return count;
    }
}
