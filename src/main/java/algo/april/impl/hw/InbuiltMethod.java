package algo.april.impl.hw;

import algo.april.HammingWeight;

public class InbuiltMethod implements HammingWeight {
    @Override
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
