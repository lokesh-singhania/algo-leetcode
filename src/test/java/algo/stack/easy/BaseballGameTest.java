package algo.stack.easy;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import algo.stack.easy.impl.BaseballGameImpl;

public class BaseballGameTest {

	BaseballGame game = new BaseballGameImpl();

	@DataProvider()
	public Object[][] data() {
		return new Object[][] {
				{ new String[] {}, 0, "emptyOpsShouldResultInZeroPoints" },
				{ new String[] { "1" }, 1, "singleDigitShouldResultInThatManyPoints" },
				{ new String[] { "23" }, 23, "twoDigitShouldResultInThatManyPoints" },
				{ new String[] { "10", "20" }, 30, "multipleIntegersShouldResultInSumOfThem" },
				{ new String[] {"10","D"}, 30, "dShouldResultInDouble"},
				{new String[] {"10","C"},0,"cAfterOneScoreShouldLeadToZero"},
				{ new String[] {"10","10","+"},40,"+ShouldReturnSum"},
				{ new String[] {"5","10","13","C","D","+"},65,"caseWith+DC"},
				{new String[]{"5","2","C","D","+"},30,"leetcode"}
		};
	}

	@Test(dataProvider = "data")
	private void test(String[] ops, int expectedSum, String message) {
		assertEquals(game.calPoints(ops), expectedSum, message);
	}
}
