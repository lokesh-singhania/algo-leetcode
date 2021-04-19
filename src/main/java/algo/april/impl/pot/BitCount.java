package algo.april.impl.pot;

import algo.april.PowerOfTwo;

public class BitCount implements PowerOfTwo {
    @Override
    public boolean isPowerOfTwo(int n) {
        return n>0 && Integer.bitCount(n)==1;
    }
}
