package algo.stack.easy;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import algo.stack.easy.impl.rad.RemoveAdjacentDuplicatesImpl;
import algo.stack.easy.impl.rad.TwoPointers;

public class RemoveAdjacentDuplicatesTest {
	
	RemoveAdjacentDuplicates rad;
	
	public RemoveAdjacentDuplicatesTest(RemoveAdjacentDuplicates rad) {
		this.rad = rad;
	}

	@Factory
	private static Object[] factory() {
		return new Object[] {
			new RemoveAdjacentDuplicatesTest(new RemoveAdjacentDuplicatesImpl()),
			new RemoveAdjacentDuplicatesTest(new TwoPointers())
		};
	}
	
	@DataProvider
	private static Object[][] data(){
		return new Object[][] {
			{"","","emptyString"},
			{"aa","",""},
			{"abba","",""},
			{"abbc","ac",""}
		};
	}
	
	@Test(dataProvider = "data")
	public void test(String input,String expected,String message) {
		String result = rad.removeDuplicates(input);
		assertEquals(result, expected, message);
	}
}
