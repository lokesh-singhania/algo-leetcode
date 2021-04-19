package algo.random.escn;

import algo.random.ExcelSheetColumnNumber;

public class OneLiner implements ExcelSheetColumnNumber {

	@Override
	public int convertTitleToNumber(String s) {
		return s.chars().reduce(0, (r, c) -> r * 26 + (c - 'A' + 1));
	}

}
