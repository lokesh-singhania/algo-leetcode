package algo.stack.easy.impl.rad;

import algo.stack.easy.RemoveAdjacentDuplicates;

public class TwoPointers implements RemoveAdjacentDuplicates{

	@Override
	public String removeDuplicates(String s) {
		char[] array = s.toCharArray();
		int i=0;
		for(int j=0;j<s.length();i++,j++) {
			array[i]=array[j];
			if(i>0 && array[i]==array[i-1]) {
				i-=2;
			}
		}
		return new String(array,0,i);
	}

}
