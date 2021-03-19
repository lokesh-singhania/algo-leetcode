package algo.stack.easy.impl.rop;

import algo.stack.easy.RemoveOutermostParentheses;

public class Optimised implements RemoveOutermostParentheses{

	@Override
	public String removeOutermostParentheses(String s) {
        StringBuilder result=new StringBuilder();
        int count=0;
        int start=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                count++;
            }else{
                count--;
            }
            result.append(c);
            if(count==0 && result.length()>start){
                result.deleteCharAt(start)
                    .deleteCharAt(result.length()-1);
                count=0;
                start=result.length();
            }
        }
        return result.toString();
    }

}
