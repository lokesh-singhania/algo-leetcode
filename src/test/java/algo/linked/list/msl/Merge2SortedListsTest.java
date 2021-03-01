package algo.linked.list.msl;

import static algo.linked.list.util.ListUtil.createList;
import static algo.linked.list.util.ListUtil.equalValueList;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.easy.msl.Merge2SortedLists;

public abstract class Merge2SortedListsTest {

	Merge2SortedLists sol;

	public Merge2SortedListsTest(Merge2SortedLists sol) {
		this.sol = sol;
	}

	@Test
	public void withCommon() {
		ListNode l1 = createList(1, 2, 3);
		ListNode l2 = createList(1, 4, 5);
		ListNode expected = createList(1, 1, 2, 3, 4, 5);
		test(l1, l2, expected);
	}

	private void test(ListNode l1, ListNode l2, ListNode expected) {
		ListNode output = sol.mergeTwoLists(l1, l2);
		assertTrue(equalValueList(output, expected));
	}
	
	@Test
	public void bothNull() {
		test(null,null,null);
	}
	
	@Test
	public void oneNull() {
		test(null,createList(1,2),createList(1,2));
	}
	
	@Test
	public void differentLengthWithCommon() {
		test(createList(1,2,3),createList(1,12,45,67),createList(1,1,2,3,12,45,67));
	}
	
	@Test
	public void differentLengthNoCommon() {
		test(createList(1,2,3), createList(34,56),createList(1,2,3,34,56));
	}
}
