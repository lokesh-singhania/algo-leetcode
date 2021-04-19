package algo.april.impl.pot;

import algo.april.PowerOfTwo;

public class BitManipulation implements PowerOfTwo {
    @Override
    public boolean isPowerOfTwo(int n) {
        switch (n){
            case Integer.MIN_VALUE:
            case 0:
                return false;
            default:
                return (n&(n-1))==0;
        }
    }
}
