package algo.random.escn;

import algo.random.ExcelSheetColumnNumber;

public class Simple implements ExcelSheetColumnNumber {

	@Override
	public int convertTitleToNumber(String s) {
		int number = 0;
		for (int i = s.length() - 1; i > -1; i--) {
			number = number * 26 + charToInt(s.charAt(i));
		}
		return number;
	}

	private int charToInt(char c) {
		return c - 'A' + 1;
	}

}
