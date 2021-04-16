package algo.random.esct;

import algo.annotations.ComplexityValue;
import algo.annotations.SpaceComplexity;
import algo.annotations.TimeComplexity;
import algo.random.ExcelSheetColumnTitle;

@TimeComplexity(ComplexityValue.LINEAR)
@SpaceComplexity(value = ComplexityValue.QUADRATIC, remark = "Because of string concatenation")
public class Recursive implements ExcelSheetColumnTitle {

	@Override
	public String convertToTitle(int columnNumber) {
		return columnNumber == 0
				? ""
				: convertToTitle(--columnNumber / 26) + (char) (columnNumber % 26 + 'A');
	}

}
