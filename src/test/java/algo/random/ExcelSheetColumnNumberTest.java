package algo.random;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import algo.random.escn.OneLiner;
import algo.random.escn.Simple;

public class ExcelSheetColumnNumberTest {

	private ExcelSheetColumnNumber service;

	public ExcelSheetColumnNumberTest(ExcelSheetColumnNumber service) {
		this.service = service;
	}

	@Factory
	private static Object[] factory() {
		return new Object[] {
				new ExcelSheetColumnNumberTest(new OneLiner()),
				new ExcelSheetColumnNumberTest(new Simple())
		};
	}

	@DataProvider
	private Object[][] data() {
		return new Object[][] {
				{ "A", 1 },
				{ "AA", 27 },
				{ "ZZ", 26 * 26 + 26 }
		};
	}

	@Test(dataProvider = "data")
	public void test(String columnTitle,int columnNumber) {
		assertEquals(service.convertTitleToNumber(columnTitle), columnNumber);
	}
}
