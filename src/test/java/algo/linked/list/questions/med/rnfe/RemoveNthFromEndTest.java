package algo.linked.list.questions.med.rnfe;

import static algo.linked.list.util.ListUtil.createList;
import static algo.linked.list.util.ListUtil.equalValueList;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.medium.rnfe.RemoveNthFromEnd;
import algo.linked.list.questions.medium.rnfe.sol.RecursiveElegant;

public class RemoveNthFromEndTest {
	RemoveNthFromEnd sol = new RecursiveElegant();

	@Test
	public void nullCase() {
		assertNull(sol.removeNthFromEnd(null, 0));
	}

	@Test
	public void singleNode() {
		test(createList(1), 1, null);
	}

	public class LongerList {

		@Test
		public void middle() {
			test(createList(1,2,3,4,5), 4, createList(1,3,4,5));
		}

		@Test
		public void lastNode() {
			test(createList(1,2,3,4,5), 1, createList(1,2,3,4));
		}

		@Test
		public void firstNode() {
			test(createList(1,2,3,4,5), 5, createList(2,3,4,5));
		}
	}

	private void test(ListNode input, int n, ListNode output) {
		ListNode listAfterRemoval = sol.removeNthFromEnd(input, n);
		assertTrue(equalValueList(listAfterRemoval,output));
	}

}
