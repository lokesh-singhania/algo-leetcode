package algo.random;

import static algo.util.Factory.EMPTY_ARRAY;
import static algo.util.ArrayUtil.array;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import algo.random.mcs.Simple;

public class MostCompetitiveSubsequenceTest {
	private MostCompetitiveSubsequence service=new Simple();
	
	@DataProvider
	private Object[][] data(){
		return new Object[][] {
			// Lower boundary cases
			{EMPTY_ARRAY,0,EMPTY_ARRAY,"empty"},
			{array(1),1,array(1),"singleElement"},
			{array(1),0,EMPTY_ARRAY,"zeroSubsequenceLength"},
			
			{array(4,1,2,3),1,array(1),"singleSubsequenceLength"},
			{array(1,2,3),2,array(1,2),"twoLength"},
			{array(6,7,9,23,456),3,array(6,7,9),"mixed digit numbers"},
			{array(10,9, 8, 3 , 2, 5),3,array(3,2,5),"non sorted"}
		};
	}
	
	@Test(dataProvider = "data")
	public void test(int[] input,int lengthOfSubsequence,int[] expectedOutput, String message) {
		int[] output = service.mostCompetitive(input, lengthOfSubsequence);
		assertEquals(output, expectedOutput,message);
	}
}
