package algo.stack.easy;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import algo.stack.easy.impl.bsc.LinearSpace;
import algo.util.TestUtil;
import algo.stack.easy.impl.bsc.ConstantSpaceFailFast;

public class BackspaceStringCompareTest {

	BackspaceStringCompare bsc;

	public BackspaceStringCompareTest(BackspaceStringCompare bsc) {
		this.bsc = bsc;
	}

	@Factory
	private static Object[] factory() {
//		return new Object[] {
//				new BackspaceStringCompareTest(new ConstantSpaceFailFast()),
//				new BackspaceStringCompareTest(new LinearSpace())
//		};
		return TestUtil.createFactory(BackspaceStringCompareTest.class, BackspaceStringCompare.class,LinearSpace.class,ConstantSpaceFailFast.class);
	}

	@DataProvider
	private Object[][] data() {
		return new Object[][] {
				{ "", "", true, "emptyStrings" },
				{ "a", "a", true, "singleSameCharacter" },
				{ "b", "a", false, "singleDifferentCharacter" },
				{ "a", "aa", false, "differentLengths" },
				{ "aa", "aaa#", true, "withBackspace" },
				{ "", "b##", true, "backspaceOnEmpty" },
				{ "aa#", "ab#", true, "bothHaveBackspace" },
				{ "ab##c", "fg##c", true, "multipleBackspaceTogether" },
				{ "bxj##tw","bxj###tw", false, "leetcode" }
		};
	}

	@Test(dataProvider = "data")
	public void test(String first, String second, boolean expectedResult, String message) {
		boolean result = bsc.backspaceCompare(first, second);
		assertEquals(result, expectedResult, message);
	}

}
