package algo.april.impl.ftz;

import algo.april.FactorialTrailingZeroes;

public class Recursive implements FactorialTrailingZeroes {
    @Override
    public int trailingZeroes(int number) {
        return number==0?0:(number/=5)+trailingZeroes(number);
    }
}
