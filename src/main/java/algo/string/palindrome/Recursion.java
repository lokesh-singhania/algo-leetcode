package algo.string.palindrome;

import java.util.ArrayList;
import java.util.List;

public class Recursion implements PalindromePartitioning{

	@Override
	public List<List<String>> partition(String s) {
        return new PalindromePartitioner(s).possiblePartitions();
    }
    
    class PalindromePartitioner{
        
        private String s;
        private List<List<String>> possiblePartitions;
        private int length;
        
        PalindromePartitioner(String s){
            this.s = s;
            possiblePartitions = new ArrayList<>();
            length = s.length();
            process(new ArrayList<>(), 0);
        }
        
        void process(List<String> partitions, int index ){
            if(index == length){
                possiblePartitions.add(partitions);
                return;
            }
            StringBuilder candidate = new StringBuilder();
            for(int i=index;i<length;i++){
                candidate.append(charAt(i));
                var isPalindrome = isPalindrome(candidate);
                if(!isPalindrome){
                    continue;
                }else{
                    process(add(partitions, candidate.toString()), i+1);
                }
            }
        }
        
        List<String> add(List<String> list, String s){
            var copy = new ArrayList<>(list);
            copy.add(s);
            return copy;
        }
        
        boolean isPalindrome(CharSequence cs){
            int n = cs.length();
            for(int i=0,j=n-1;i<j;i++,j--){
                if(cs.charAt(i)!=cs.charAt(j)){
                    return false;
                }
            }
            return true;
        }
        
        char charAt(int i){
            return s.charAt(i);
        }
        
        
        List<List<String>> possiblePartitions(){
            return possiblePartitions;
        }
    }

}
