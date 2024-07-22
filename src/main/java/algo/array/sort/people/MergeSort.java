package algo.array.sort.people;

import algo.array.SortPeople;

public abstract class MergeSort implements SortPeople {

    public final String[] sortPeople(String[] names, int[] heights) {
        return mergeSort(names,heights);
    }

    abstract String[] mergeSort(String[] a, int[] b);

    protected void merge(int lo, int mid, int hi, String[] names, String[] namesAux, int[] heights, int[] heightsAux) {
        for(int i = lo, j = mid +1, k = lo; k<= hi; k++){
            boolean takeFirst = (j> hi) || ((i<= mid) &&  (heights[i]>= heights[j]));
            if(takeFirst){
                heightsAux[k] = heights[i];
                namesAux[k] = names[i];
                i++;
            }else{
                heightsAux[k]= heights[j];
                namesAux[k] = names[j];
                j++;
            }
        }
    }
}
