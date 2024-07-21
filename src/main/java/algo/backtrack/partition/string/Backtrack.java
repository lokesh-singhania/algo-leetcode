package algo.backtrack.partition.string;

import algo.backtrack.PartitionString;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Backtrack implements PartitionString {
    private NavigableSet<String> powersOfFive;
    private String s;

    Backtrack(){
        powersOfFive = new TreeSet<>(Comparator.comparing(String::length).reversed());
        int num=1;
        String numString=Integer.toBinaryString(num);
        while(numString.length()<=15){
            powersOfFive.add(numString);
            num*=5;
            numString = Integer.toBinaryString(num);
        }
    }


    public int minimumBeautifulSubstrings(String s) {
        this.s=s;
        return backtrack(0,0);
    }

    private int backtrack(int i,int count){
        int n = s.length();
        if(n==i){
            return count;
        }
        for(var candidate:powersOfFive.tailSet(s.substring(i))){
            int nextIndex = i+candidate.length();
            if(nextIndex<n && s.charAt(nextIndex)=='0'){
                continue;
            }
            if(!s.substring(i,nextIndex).equals(candidate)){
                continue;
            }
            int val = backtrack(nextIndex,count+1);
            if(val>0){
                return val;
            }
        }
        return -1;
    }
}
