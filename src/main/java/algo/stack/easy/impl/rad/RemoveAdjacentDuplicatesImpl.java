package algo.stack.easy.impl.rad;

import algo.stack.easy.RemoveAdjacentDuplicates;

public class RemoveAdjacentDuplicatesImpl implements RemoveAdjacentDuplicates{

	@Override
	public String removeDuplicates(String s) {
		StringBuilder sb=new StringBuilder();
		//Different ways to iterate through string
		for(char c:s.toCharArray()) {
			int lastIndex = sb.length()-1;
			if(lastIndex>-1 && c==sb.charAt(lastIndex)) {
				sb.deleteCharAt(lastIndex);
			}else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
