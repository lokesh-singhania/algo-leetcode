package algo.stack.easy.impl.rop;

import algo.stack.easy.RemoveOutermostParentheses;

public class RemoveOutermostParenthesesImpl implements RemoveOutermostParentheses {

	@Override
	public String removeOutermostParentheses(String s) {
		int count = 0;
		StringBuilder mainBuilder = new StringBuilder();
		int i = 0;
		StringBuilder localBuilder = new StringBuilder();
		while (i < s.length()) {
			char c = s.charAt(i);
			if (c == '(') {
				count++;
			} else if (c == ')') {
				count--;
			} else {
				throw new RuntimeException("Invalid character: " + c);
			}
			localBuilder.append(c);
			if (count == 0 && localBuilder.length() != 0) {
				localBuilder.deleteCharAt(0)
				.deleteCharAt(localBuilder.length()-1);
				mainBuilder.append(localBuilder);
				localBuilder = new StringBuilder();
			}
			i++;
		}

		return mainBuilder.toString();
	}

}
