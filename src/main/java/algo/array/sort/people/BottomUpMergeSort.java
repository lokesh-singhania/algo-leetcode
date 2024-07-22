package algo.array.sort.people;

import algo.annotations.ComplexityValue;
import algo.annotations.SpaceComplexity;
import algo.annotations.TimeComplexity;

import java.util.Arrays;

@SpaceComplexity(ComplexityValue.LINEAR)
@TimeComplexity(ComplexityValue.LINEARITHMIC)
public class BottomUpMergeSort extends MergeSort{

    @Override
    String[] mergeSort(String[] names, int[] heights){
        int n = names.length;

        int[] heightsAux= Arrays.copyOf(heights,n);
        String[] namesAux = Arrays.copyOf(names,n);

        for(int size=1;size<n;size<<=1){

            for(int lo = 0;lo<n;lo+=2*size){
                int mid = lo+size-1;
                int hi = Math.min(n,lo+2*size)-1;
                merge(lo, mid, hi, names, namesAux, heights, heightsAux);
            }

            // swap auxes
            int[] t1 = heightsAux;
            heightsAux = heights;
            heights = t1;

            String[] t2 = names;
            names = namesAux;
            namesAux = t2;
        }
        return names;
    }

}
