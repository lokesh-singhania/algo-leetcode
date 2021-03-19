package algo.stack.medium;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import algo.stack.medium.impl.SimplifyPathImpl;

public class SimplifyPathTest {

	private SimplifyPath sol;
	
	public SimplifyPathTest(SimplifyPath sol) {
		this.sol = sol;
	}
	
	@Factory
	private static Object[] factory() {
		return new Object[] {
			new SimplifyPathTest(new SimplifyPathImpl())	
		};
	}

	@DataProvider
	private Object[][] data(){
		return new Object[][] {
			{"/home/","/home","removalOfTrailingSlash"},
			{"/../","/","parentOfRoot"},
			{"/a/b/../","/a","downThenUp"},
			{"/a/b/../c/","/a/c","downThenUpThenDown"}
		};
	}
	
	
	@Test(dataProvider = "data")
	public void test(String absolutePath,String expectedPath, String message) {
		String output = sol.simplifyPath(absolutePath);
		assertEquals(output, expectedPath, message);
	}
}
