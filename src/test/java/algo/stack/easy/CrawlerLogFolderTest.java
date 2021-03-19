package algo.stack.easy;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import algo.stack.easy.impl.CrawlerLogFolderImpl;

public class CrawlerLogFolderTest {

	CrawlerLogFolder impl = new CrawlerLogFolderImpl();

	@DataProvider
	private Object[][] data(){
		return new Object[][] {
			{new String[] {"../"},0},
			{new String[] {"./"},0},
			{new String[] {"dk/","../"},0},
			{new String[] {"d1/","d2/"},2},
			{new String[] {"d1/","d2/","../","d3"},2}
		};
	}
	
	
	@Test(dataProvider = "data")
	public void test(String[] logs, int expected) {
		int result = impl.minOperations(logs);
		assertEquals(result, expected);
	}
}
