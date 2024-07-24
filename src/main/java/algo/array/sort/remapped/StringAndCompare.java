package algo.array.sort.remapped;

import algo.array.SortJumbled;

import java.util.Arrays;

public class StringAndCompare implements SortJumbled {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .sorted((a,b)->compare(a,b,mapping))
                .mapToInt(Integer::intValue)
                .toArray();
    }

    int nonZeroIndex(String s,int[] mapping){
        int i=0;
        while(i<s.length() && digit(mapping,s,i)==0){
            i++;
        }
        return i;
    }

    int compare(int a,int b,int[] mapping){
        String s = String.valueOf(a);//0
        String t = String.valueOf(b);//1
        int i=nonZeroIndex(s,mapping);//0
        int j=nonZeroIndex(t,mapping);//1

        if(s.length()-i!=t.length()-j){
            return s.length()-i-t.length()+j;
        }
        for(;i<s.length();i++,j++){
            int d1 = digit(mapping,s,i);
            int d2 = digit(mapping, t, j);
            if(d1==d2){
                continue;
            }
            return d1-d2;
        }
        return 0;
    }

    int digit(int[] mapping,String s,int i){
        return mapping[s.charAt(i)-'0'];
    }
}
