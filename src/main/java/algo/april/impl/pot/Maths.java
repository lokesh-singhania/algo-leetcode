package algo.april.impl.pot;

import algo.april.PowerOfTwo;

public class Maths implements PowerOfTwo {
    @Override
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}
