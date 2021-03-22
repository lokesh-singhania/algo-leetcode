package algo.stack.medium;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import algo.stack.medium.impl.ReversePolishNotationImpl;

public class ReversePolishNotationTest {
	ReversePolishNotation reversePolish= new ReversePolishNotationImpl();

	@DataProvider
	private Object[][] data() {
		return new Object[][] {
				{ new String[] {}, 0, "empty" },
				{ new String[] { "2" }, 2, "singleElement" },
				{ new String[] { "2", "1", "+" }, 3, "oneOperation" },
				{ new String[] { "2", "1", "3", "+", "*" }, 8, "twoSuccessiveOperations" },
				{ new String[] { "2", "4", "-", "5", "*" }, -10, "twoNonSuccessiveOperations" }
		};
	}

	@Test(dataProvider = "data")
	public void test(String[] tokens, int expectedResult, String message) {
		assertEquals(reversePolish.evaluate(tokens), expectedResult, message);
	}
}
