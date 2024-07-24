package algo.string.prefix.score;

import algo.annotations.undesired.TLE;
import algo.string.PrefixScoreSum;

import java.util.HashMap;
import java.util.Map;

@TLE
public class PrefixMap implements PrefixScoreSum {

    @Override
    public int[] sumPrefixScores(String[] words) {
        Map<String,Integer> prefixCount = new HashMap<>();
        for(String word:words){
            StringBuilder sb = new StringBuilder();
            for(char c:word.toCharArray()){
                sb.append(c);
                prefixCount.merge(sb.toString(),1,Integer::sum);
            }
        }


        int[] answer=new int[words.length];
        int ai=0;
        for(String word:words){
            StringBuilder sb = new StringBuilder();
            for(char c:word.toCharArray()){
                sb.append(c);
                answer[ai]+= prefixCount.get(sb.toString());
            }
            ai++;
        }
        return answer;
    }
}
