package algo.linked.list.questions.binary;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.easy.binary.ConvertBinaryNumberToInteger;
import algo.linked.list.questions.easy.binary.sol.BitShift;
import algo.linked.list.questions.easy.binary.sol.Maths;
import algo.linked.list.util.ListUtil;

public class ConvertBinaryNumberToIntegerTest {

	ConvertBinaryNumberToInteger impl = new BitShift();
	
	@Test
	public void nullList() {
		test(null,0);
	}
	
	@Test
	public void zero() {
		test(new ListNode(0),0);
	}
	
	@Test
	public void longerNumber() {
		test(ListUtil.createList(1,1,0,0,1),25);
	}
	
	void test(ListNode input, int expectedValue) {
		int output = impl.getDecimalValue(input);
		assertEquals(output, expectedValue);
	}

}
