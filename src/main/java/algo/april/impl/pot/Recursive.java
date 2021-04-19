package algo.april.impl.pot;

import algo.april.PowerOfTwo;

public class Recursive implements PowerOfTwo {
    @Override
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n==1 || (n%2==0 && isPowerOfTwo(n/2)));
    }
}
