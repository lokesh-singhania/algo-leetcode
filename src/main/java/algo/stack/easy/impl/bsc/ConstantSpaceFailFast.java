package algo.stack.easy.impl.bsc;

import algo.stack.easy.BackspaceStringCompare;

public class ConstantSpaceFailFast implements BackspaceStringCompare {

	private static final int INVALID = -1;
	private static final char BACKSPACE = '#';

	@Override
	public boolean backspaceCompare(String a, String b) {
		int i = a.length();
		int j = b.length();
		while (true) {
			i = nextValidCharIndex(i, a);
			j = nextValidCharIndex(j, b);
			if (isValid(i) && isValid(j)) {
				if (a.charAt(i) != b.charAt(j)) {
					return false;
				}
			} else {
				return !(isValid(i) ^ isValid(j));
			}
		}
	}

	private boolean isValid(int i) {
		return i > INVALID;
	}

	private int nextValidCharIndex(int start, String a) {
		if (start <= 0)
			return INVALID;

		int i = start - 1;
		int backSpaceCount = 0;
		do {
			char c = a.charAt(i);
			if (isBackspace(c)) {
				backSpaceCount++;
			} else {
				if (backSpaceCount == 0) {
					return i;
				} else {
					// ignore character and decrement count
					backSpaceCount--;
				}
			}
			i--;
		} while (i >= 0);
		return INVALID;
	}

	private boolean isBackspace(char c) {
		return c == BACKSPACE;
	}

}
