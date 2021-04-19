package algo.april.impl.pot;

import algo.april.PowerOfTwo;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LookupTable implements PowerOfTwo {

    private static final Set<Integer> POWERS_OF_TWO = IntStream.iterate(1, a->a<Integer.MAX_VALUE/2, a->a*2)
                                                        .collect(HashSet::new,HashSet::add,HashSet::addAll);

    @Override
    public boolean isPowerOfTwo(int n) {
        return POWERS_OF_TWO.contains(n);
    }
}
