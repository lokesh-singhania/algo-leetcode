package algo.linked.list.questions.llc.sol;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.easy.llc.LinkedListCycle;
import algo.linked.list.questions.easy.llc.sol.TwoPointers;
import algo.linked.list.util.ListUtil;

public class LinkedListCycleTest {

	LinkedListCycle impl;
	
	public LinkedListCycleTest(LinkedListCycle impl) {
		this.impl = impl;
	}

	@Test
	public void testNull() {
		test(null,false);
	}

	@Test
	public void testSingleNode() {
		test(new ListNode(1),false);
	}

	@Test
	public void testStraightList() {
		test(ListUtil.createList(1,2,3,4,5,6,5),false);
	}

	@Test
	public void testWithCycle() {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		
		one.next=two;
		two.next= three;
		three.next=two;
		test(one,true);
	}

	private void test(ListNode head, boolean expected) {
		boolean output = impl.hasCycle(head);
		assertEquals(output, expected);
	}

}