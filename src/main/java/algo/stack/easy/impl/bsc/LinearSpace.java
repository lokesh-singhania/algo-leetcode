package algo.stack.easy.impl.bsc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import algo.stack.easy.BackspaceStringCompare;

public class LinearSpace implements BackspaceStringCompare{

	@Override
	public boolean backspaceCompare(String a, String b) {
		return Arrays.equals(getValidChars(a),getValidChars(b));
 	}

	private Character[] getValidChars(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		for(char c:s.toCharArray()) {
			if(c=='#') {
				if(!stack.isEmpty()) {
					stack.pop();
				}
			}else {
				stack.push(c);
			}
		}
		return stack.toArray(new Character[stack.size()]);
	}

}
