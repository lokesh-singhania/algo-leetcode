package algo.april.impl.va;

import algo.april.ValidAnagram;

import java.util.Arrays;

public class Array implements ValidAnagram {
    @Override
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        return Arrays.equals(getCharacterFrequencies(s),getCharacterFrequencies(t));
    }

    private int[] getCharacterFrequencies(String s) {
        return s.chars().map(c->c-'a')
                .collect(()->new int[26],(ints, value) -> ints[value]++,(freq1, freq2) -> {
                    for(int i=0;i<freq1.length;i++){
                        freq1[i]+=freq2[i];
                    }
                } );
    }


}
