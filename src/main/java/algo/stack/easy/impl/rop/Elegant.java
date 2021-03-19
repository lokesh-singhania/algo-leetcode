package algo.stack.easy.impl.rop;

import algo.stack.easy.RemoveOutermostParentheses;

public class Elegant implements RemoveOutermostParentheses{

	@Override
	public String removeOutermostParentheses(String s) {
		int opened=0;
		StringBuilder result=new StringBuilder();
		for(char c:s.toCharArray()) {
			if((c=='('&&opened++>0 )||(c==')' &&opened-->1) ) {
				result.append(c);
			}
		}
		return result.toString();
	}

}
