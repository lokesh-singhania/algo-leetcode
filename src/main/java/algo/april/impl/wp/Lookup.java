package algo.april.impl.wp;

import algo.annotations.Remarks;
import algo.april.WordPattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Remarks(optimizations = {"Set of character instead of set of string","Array of boolean of 26 length instead of set of character"})
public class Lookup implements WordPattern {
    @Override
    public boolean wordPattern(String pattern, String s) {
        if(s.isEmpty() && pattern.isEmpty()){
            return true;
        }
        Map<Character, String> wordsByChars = new HashMap<>();
        Set<String> encounteredWords = new HashSet<>();

        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        int length=words.length;
        for(int i=0;i<length;i++){
            String word=words[i];
            char character=pattern.charAt(i);
            if (wordsByChars.containsKey(character)){
                if(!wordsByChars.get(character).equals(word)){
                    return false;
                }
            }else{
                if(encounteredWords.contains(word)){
                    return false;
                }
                encounteredWords.add(word);
                wordsByChars.put(character,word);
            }
        }
        return true;
    }
}
