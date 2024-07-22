package algo.array.sort.people;

import java.util.Arrays;

public class TopDownMergeSort extends MergeSort {
    @Override
    String[] mergeSort(String[] names, int[] heights) {
        int n = names.length;

        sort(names, heights, Arrays.copyOf(names, n), Arrays.copyOf(heights, n), 0, n - 1);
        return names;
    }

    void sort(String[] names, int[] heights, String[] namesAux, int[] heightsAux, int lo, int hi) {
        if (lo == hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(names, heights, namesAux, heightsAux, lo, mid);
        sort(names, heights, namesAux, heightsAux, mid + 1, hi);
        merge(lo, mid, hi, names, namesAux, heights, heightsAux);

        for (int i = lo; i <= hi; i++) {
            names[i] = namesAux[i];
            heights[i] = heightsAux[i];
        }
    }
}
