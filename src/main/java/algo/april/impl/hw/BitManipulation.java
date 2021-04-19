package algo.april.impl.hw;

import algo.april.HammingWeight;

import java.util.stream.IntStream;

public class BitManipulation implements HammingWeight {
    @Override
    public int hammingWeight(int n) {
        return (int)IntStream.iterate(n,t->t&(t-1))
                .takeWhile(t->t!=0)
                .count();
    }
}
