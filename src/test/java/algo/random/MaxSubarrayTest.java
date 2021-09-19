package algo.random;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import algo.random.msa.BruteForce;
import algo.random.msa.Optimized;

public class MaxSubarrayTest {

	private MaxSubarray ms;
	
	@DataProvider
	private static Object[][] impls(){
		return new Object[][] {
			{new BruteForce()},
			{new Optimized()}
		};
	}

	@DataProvider
	private static Object[][] data() {
		return new Object[][] { { new int[] { 1 }, 1, "single element array" },
			{new int[] {1,2},3,"all positive"},
			{new int[] {-1,2},2,"negative present"} ,
			{new int[] {100,-98,96,-12,30,-45},116,"non greeedy case"}
		};
	}
	
	@Factory(dataProvider = "impls")
	public MaxSubarrayTest(MaxSubarray ms) {
		this.ms = ms;
	}

	@Test(dataProvider = "data")
	public void maxSubArrayTest(int[] array, int expectedSum, String message) {
		assertEquals(ms.maxSubArray(array), expectedSum, message);
	}
}
