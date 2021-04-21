package algo.april.impl.wp;

import algo.annotations.Optimization;
import algo.april.WordPattern;

import java.util.HashMap;
import java.util.Map;

@Optimization(value = Lookup.class,notes = "26 length array instead of hashset")
public class OptimisedLookup implements WordPattern {
    @Override
    public boolean wordPattern(String pattern, String s) {
        if(pattern.isEmpty() && s.isEmpty()){
            return true;
        }
        boolean[] encounteredChars=new boolean[26];
        Map<String,Character> wordsAndChars=new HashMap<>();
        String[] words = s.split(" ");
        int length=pattern.length();
        if(words.length!=length) return false;
        for(int i=0;i<length;i++){
            String word=words[i];
            char c=pattern.charAt(i);
            if(wordsAndChars.containsKey(word)){
                if(wordsAndChars.get(word)!=c){
                    return false;
                }
            }else{
                if(encounteredChars[c-'a']){
                    return false;
                }
                encounteredChars[c-'a']=true;
                wordsAndChars.put(word,c);
            }
        }
        return true;
    }
}
