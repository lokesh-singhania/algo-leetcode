package algo.stack.medium.impl.rdl;

import com.google.common.base.Strings;

import algo.stack.medium.RemoveDuplicateLetters;

public class RemoveDuplicateLettersImpl implements RemoveDuplicateLetters {

	private static final char SMALLCASE_A = 'a';
	protected static final int NUMBER_OF_ALPHABETS = 26;

	@Override
	public String removeDuplicate(String input) {
		if (Strings.isNullOrEmpty(input)) {
			return "";
		}

		boolean[] presentCharacters = getPresentCharacters(input);
		return buildString(presentCharacters);
	}

	protected String buildString(boolean[] presentCharacters) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < NUMBER_OF_ALPHABETS; i++) {
			if (presentCharacters[i]) {
				result.append(toChar(i));
			}
		}
		return result.toString();
	}

	protected boolean[] getPresentCharacters(String input) {
		boolean[] presentCharacters = new boolean[NUMBER_OF_ALPHABETS];
		// Do this via stream - T1
		for (char c : input.toCharArray()) {
			presentCharacters[toInt(c)] = true;
		}
		return presentCharacters;
	}

	protected char toChar(int i) {
		return (char) (SMALLCASE_A + i);
	}

	protected int toInt(char c) {
		return c - SMALLCASE_A;
	}

}
