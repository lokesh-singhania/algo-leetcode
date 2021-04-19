package algo.april.impl.va;

import algo.annotations.ComplexityValue;
import algo.annotations.Date;
import algo.annotations.SpaceComplexity;
import algo.annotations.TimeComplexity;
import algo.april.ValidAnagram;
import algo.util.Factory;

import java.util.Arrays;

@Date("April 19, 2021")
@TimeComplexity(value = ComplexityValue.LINEAR, remark = "length of s+length of t+number of characters allowed")
@SpaceComplexity(value = ComplexityValue.CONSTANT, remark = "space of array: will depend on allowed characters")
public class SingleArray implements ValidAnagram {
    @Override
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int length = s.length();

        int[] netFrequency = new int[26];

        for (int i = 0; i < length; i++) {
            netFrequency[toInt(s.charAt(i))]++;
            netFrequency[toInt(t.charAt(i))]--;
        }

        return Arrays.stream(netFrequency)
                .noneMatch(Factory.NON_ZERO);
    }

    private int toInt(char c) {
        return c - 'a';
    }
}
