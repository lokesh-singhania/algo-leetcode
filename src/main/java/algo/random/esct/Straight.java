package algo.random.esct;

import static algo.annotations.ComplexityValue.LINEAR;

import algo.annotations.Complexity;
import algo.random.ExcelSheetColumnTitle;

@Complexity(time=LINEAR,space = LINEAR)
public class Straight implements ExcelSheetColumnTitle {

	@Override
	public String convertToTitle(int columnNumber) {
		int n = columnNumber;
		StringBuilder reversedResult = new StringBuilder();
		while (n > 0) {
			n--;
			reversedResult.append(toChar(n % 26));
			n /= 26;
		}
		return reversedResult.reverse().toString();
	}

	private char toChar(int i) {
		return (char) (i + 'A');
	}
}
