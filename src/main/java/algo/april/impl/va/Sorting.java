package algo.april.impl.va;

import algo.annotations.ComplexityValue;
import algo.annotations.SpaceComplexity;
import algo.annotations.TimeComplexity;
import algo.april.ValidAnagram;

import java.util.Arrays;

import static algo.annotations.ComplexityValue.CONSTANT;
import static algo.annotations.ComplexityValue.LINEARITHMIC;

@TimeComplexity(value = LINEARITHMIC, remark = "due to sorting")
@SpaceComplexity(value = CONSTANT, remark = {"quick sort for primitives", "space of char arrays not considered"})
public class Sorting implements ValidAnagram {

    @Override
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }
}
