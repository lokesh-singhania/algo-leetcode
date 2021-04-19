package algo.april.impl.ftz;

import algo.april.FactorialTrailingZeroes;

import static com.google.common.math.IntMath.factorial;

//1. Would result in overflow for numbers>12 for int data type
public class BruteForce implements FactorialTrailingZeroes {
    @Override
    public int trailingZeroes(int number) {
        int factorial=factorial(number);
        return numberOfTrailingZeroes(factorial);
    }

    private int numberOfTrailingZeroes(int n) {
        int zeroes=0;
        while(n%10==0){
            zeroes++;
            n/=10;
        }
        return zeroes;
    }
}
