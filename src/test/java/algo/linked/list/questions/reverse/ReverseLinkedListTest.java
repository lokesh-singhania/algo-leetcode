package algo.linked.list.questions.reverse;

import static algo.linked.list.ListUtil.createList;
import static algo.linked.list.ListUtil.equalValueList;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.reverse.sol.BetterRecursive;

public class ReverseLinkedListTest {

	ReverseLinkedList sol = new BetterRecursive();
	
	@Test
	public void nullList() {
		test(null,null);
	}
	
	@Test
	public void simple() {
		test(createList(1,2,3,4,5),createList(5,4,3,2,1));
	}
	
	public void test(ListNode input, ListNode expectedOutput) {
		ListNode output = sol.reverse(input);
		assertTrue(equalValueList(expectedOutput, output));
	}
}
