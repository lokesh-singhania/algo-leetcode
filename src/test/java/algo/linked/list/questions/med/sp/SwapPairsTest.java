package algo.linked.list.questions.med.sp;

import static algo.linked.list.util.ListUtil.createList;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.medium.sp.SwapPairs;
import algo.linked.list.questions.medium.sp.sol.Iterative;
import algo.linked.list.questions.medium.sp.sol.Recursive;
import algo.linked.list.util.ListUtil;

@Test
public class SwapPairsTest {

	SwapPairs sol = new Recursive();

	public void nullCase() {
		assertNull(sol.swapPairs(null));
	}

	public void singleNode() {
		test(createList(1), createList(1));
	}

	public void twoNodes() {
		test(createList(1, 2), createList(2, 1));
	}

	public void oddNodes() {
		test(createList(1, 2, 3, 4, 5), createList(2, 1, 4, 3, 5));
	}

	public void evenNodes() {
		test(createList(1, 2, 3, 4), createList(2, 1, 4, 3));
	}

	private void test(ListNode input, ListNode expected) {
		ListNode output = sol.swapPairs(input);
		assertTrue(ListUtil.equalValueList(output, expected));
	}
}
