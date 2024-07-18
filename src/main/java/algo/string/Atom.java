package algo.string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Atom {
    public String countOfAtoms(String formula) {
        return new AtomCounter(formula).compute();
    }

    static class AtomCounter{
        String s;
        int i = 0;
        int n;
        AtomCounter(String s){
            this.s=s;
            n = s.length();
        }

        String compute(){
            var atomFreq = evaluateBracket();
            System.out.println(atomFreq);
            var sortedAtoms = new ArrayList<>(atomFreq.keySet());
            sortedAtoms.sort(Comparator.naturalOrder());

            StringBuilder sb = new StringBuilder();
            for(String atom:sortedAtoms){
                sb.append(atom);
                int f = atomFreq.get(atom);
                if(f>1){
                    sb.append(f);
                }
            }
            return sb.toString();
        }

        Map<String,Integer> evaluateBracket(){
            Map<String,Integer> group = new HashMap<>();
            while(i<s.length() && s.charAt(i)!=')'){
                if(s.charAt(i)=='('){
                    i++;
                    var innerGroup = evaluateBracket();
                    innerGroup.forEach((ik,iv)->group.merge(ik,iv,Integer::sum));
                }else{
                    var name = getName();
                    var freq = getFreq();
                    group.merge(name,freq,Integer::sum);
                }
            }
            var groupFreq = getFreq();
            group.replaceAll((k,v)->groupFreq*v);
            return group;
        }

        int getFreq(){
            int count = 0;
            while(i<n && Character.isDigit(s.charAt(i))){
                count = 10*count + (s.charAt(i)-'0');
                i++;
            }
            return Math.max(count,1);
        }

        String getName(){
            var name = new StringBuilder();
            name.append(s.charAt(i++));
            while(i<n && Character.isLowerCase(s.charAt(i))){
                name.append(s.charAt(i));
                i++;
            }
            return name.toString();
        }
    }
}
