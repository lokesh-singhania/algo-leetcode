package algo.stack.medium;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import algo.stack.medium.impl.bc2.UnoptimisedBadApproach;
import algo.stack.medium.impl.bc2.UsingStack;

public class BasicCalculator2Test {

	private BasicCalculator2 calculator=new UnoptimisedBadApproach();
	
	public BasicCalculator2Test(BasicCalculator2 calculator) {
		this.calculator = calculator;
	}
	
	@Factory
	private static Object[] factory() {
		return new Object[] {
				new BasicCalculator2Test(new UnoptimisedBadApproach()),
				new BasicCalculator2Test(new UsingStack())
		};
	}

	@DataProvider
	private Object[][] data(){
		return new Object[][] {
			{"3",3,"singleDigitNumberWithoutOperator"},
			{"3+2",5,"singleDigitNumbersOneOperation"},
			{"3+2+2",7,"twoOperations"},
			{"3*2+2",8,"twoDifferentOperations"},
			{"3+2*2",7,"multiplicationShouldHappenBeforeAdditionEvenIfItComesLater"},
			{"20-10",10,"twoDigitNumbers"},
			{"200/10+30*2",80,"multipleOperatorsAndVaryingDigits"}
//			{"-3+-5",-8,"supportOfNegativeNumbers"}
		};
	}
	
	@Test(dataProvider = "data")
	public void test(String s, int expectedOutput, String message) {
		assertEquals(calculator.calculate(s), expectedOutput, message);
	}
}
