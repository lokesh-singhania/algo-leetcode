package algo.april.impl.is;

import algo.april.IsomorphicStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LookupTables implements IsomorphicStrings {
    @Override
    public boolean isIsomorphic(String a, String b) {
        Map<Character,Character> mapping=new HashMap<>();
        Set<Character> encountered=new HashSet<>();

        int length=a.length();
        for(int i=0;i<length;i++){
            char aChar=a.charAt(i);
            char bChar=b.charAt(i);
            if(mapping.containsKey(aChar)){
                if(mapping.get(aChar)!=bChar){
                    return false;
                }
            }else{
                if(encountered.contains(bChar)){
                    return  false;
                }
                encountered.add(bChar);
                mapping.put(aChar,bChar);
            }
        }
        return true;
    }
}
