package algo.april.impl.hw;

import algo.april.HammingWeight;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class MaskingStream implements HammingWeight {

    private static final IntPredicate NON_ZERO = a->a!=0;

    @Override
    public int hammingWeight(int n) {
        return (int) IntStream.iterate(1, a -> a << 1)
                .takeWhile(NON_ZERO)
                .map(a -> a & n)
                .filter(NON_ZERO)
                .count();
    }
}
