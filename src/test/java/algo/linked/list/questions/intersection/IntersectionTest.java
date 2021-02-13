package algo.linked.list.questions.intersection;

import static algo.linked.list.ListUtil.createList;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.intersection.sol.TwoPointers;

public class IntersectionTest {

	Intersection sol = new TwoPointers();

	@Test
	public void bothListsNull() {
		test(null, null, null);
	}

	@Test
	public void oneListNull() {
		test(null, sampleList(), null);
	}

	@Test
	public void noIntersection() {
		ListNode list1 = createList(1, 2, 3, 4);
		ListNode list2 = createList(3, 4, 5);
		ListNode intersectionNode = sol.getIntersectionNode(list1, list2);
		assertNull(intersectionNode);
	}

	private ListNode sampleList() {
		return createList(1, 2, 3, 4);
	}

	@Test
	public void intersection() {
		ListNode head1 = createList(1, 2, 3);
		ListNode head2 = createList(4,5);
		head2.next.next = head1.next;
		test(head1, head2, head1.next);
	}

	private void test(ListNode list1, ListNode list2, ListNode expected) {
		ListNode intersectionNode = sol.getIntersectionNode(list1, list2);
		assertEquals(intersectionNode, expected);
	}

}
