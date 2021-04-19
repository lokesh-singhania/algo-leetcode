package algo.april.impl.is;

import algo.annotations.Best;
import algo.april.IsomorphicStrings;
//Reason of i+1
@Best
public class Concise implements IsomorphicStrings {
    @Override
    public boolean isIsomorphic(String a, String b) {
        int[] ma = new int[256];
        int[] mb = new int[256];
        for (int i = 0; i < a.length(); i++) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);
            if (ma[ca] == mb[cb]) {
                ma[ca] = i+1;
                mb[cb] = i+1;
                continue;
            }
            return false;
        }
        return true;
    }
}
