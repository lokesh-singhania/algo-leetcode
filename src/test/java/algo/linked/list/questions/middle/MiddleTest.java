package algo.linked.list.questions.middle;

import static algo.linked.list.util.ListUtil.createList;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.easy.middle.Middle;
import algo.linked.list.questions.easy.middle.sol.TwoPointers;

public class MiddleTest {
	
	Middle sol=new TwoPointers();
	
	@Test
	public void nullList() {
		assertNull(sol.getMiddle(null));
	}
	
	@Test
	public void singleNode() {
		test(new ListNode(1),1);
	}
	
	@Test
	public void twoNodes() {
		test(createList(1,2),2);
	}
	
	@Test
	public void oddNodes() {
		test(createList(1,2,3,4,5),3);
	}
	
	@Test
	public void evenNodes() {
		test(createList(1,2,3,4,5,6),4);
	}

	void test(ListNode input, int middleValue) {
		ListNode middle = sol.getMiddle(input);
		assertEquals(middle.val, middleValue);
	}
}
