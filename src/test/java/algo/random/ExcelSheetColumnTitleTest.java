package algo.random;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import algo.random.esct.Recursive;
import algo.random.esct.Straight;

public class ExcelSheetColumnTitleTest {
	private ExcelSheetColumnTitle service;
	
	public ExcelSheetColumnTitleTest(ExcelSheetColumnTitle service) {
		this.service = service;
	}

	@Factory
	private static Object[] factory() {
		return new Object[] {
			new ExcelSheetColumnTitleTest(new Straight()),
			new ExcelSheetColumnTitleTest(new Recursive())
		};
	}
	
	@DataProvider
	private Object[][] data(){
		return new Object[][] {
			{1,"A"},
			{26,"Z"},
			{27,"AA"},
			{702,"ZZ"}
		};
	}

	@Test(dataProvider = "data")
	public void test(int input, String expectedOutput) {
		assertEquals(service.convertToTitle(input), expectedOutput);
	}
}
