package algo.stack.easy;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import algo.stack.easy.impl.rop.Elegant;
import algo.stack.easy.impl.rop.Optimised;
import algo.stack.easy.impl.rop.RemoveOutermostParenthesesImpl;
import algo.util.TestUtil;

public class RemoveOutermostParenthesesTest {
	
	RemoveOutermostParentheses service;
	
	public RemoveOutermostParenthesesTest(RemoveOutermostParentheses service) {
		this.service = service;
	}

	@Factory
	public static Object[] factory() {
		return TestUtil.createFactory(RemoveOutermostParenthesesTest.class,
				RemoveOutermostParentheses.class,
				RemoveOutermostParenthesesImpl.class,
				Optimised.class,
				Elegant.class);
	}
	
	@DataProvider
	private Object[][] data(){
		return new Object[][] {
			{"","","emptyStringResultsInEmptyString"},
			{"()","","singlePairResultsInEmptyString"},
			{"(())","()","nestedPairResultsInSinglePair"},
			{"()()","","twoSinglePairsResultInEmptyString"},
			{"(()())","()()",""}
		};
	}
	
	@Test(dataProvider="data")
	public void test(String input,String expectedOutput,String message) {
		String output = service.removeOutermostParentheses(input);
		assertEquals(output, expectedOutput, message);
	}
	
}
