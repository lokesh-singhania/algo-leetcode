package algo.stack.easy;

import static algo.stack.easy.BuildArrayWithStack.POP;
import static algo.stack.easy.BuildArrayWithStack.PUSH;
import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import algo.stack.easy.impl.baws.BuildArrayImpl;
import algo.stack.easy.impl.baws.Simpler;

public class BuildArrayWithStackTest {

	BuildArrayWithStack baws;
	
	public BuildArrayWithStackTest(BuildArrayWithStack baws) {
		this.baws = baws;
	}

	@Factory
	private static Object[] factory() {
		return new Object[] {
			new BuildArrayWithStackTest(new BuildArrayImpl()),
			new BuildArrayWithStackTest(new Simpler())
		};
	}

	@DataProvider
	private Object[][] data() {
		return new Object[][] {
				{ new int[] {}, 1, Collections.emptyList(), "empty" },
				{ new int[] { 1 }, 1, Arrays.asList(PUSH), "simpleOneElement" },
				{ new int[] { 1, 2, 3 }, 3, Arrays.asList(PUSH, PUSH, PUSH), "simpleMultipleElements" },
				{new int[] {1,3},3,Arrays.asList(PUSH,PUSH,POP,PUSH),"multipleElementsWithPop"},
				{new int[] {2,4},6,Arrays.asList(PUSH,POP,PUSH,PUSH,POP,PUSH),"nonOneFirstElement"}
				
		};
	}

	@Test(dataProvider = "data")
	public void test(int[] target, int n, List<String> expected, String message) {
		List<String> result = baws.buildArray(target, n);
		assertEquals(result, expected, message);
	}
}
