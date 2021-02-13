package algo.linked.list;

import static algo.linked.list.ListUtil.createList;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import algo.linked.list.pojo.ListNode;

public class ListUtilTest {

	

	public class EqualList {
		@Test
		public void testNulls() {
			test(null, null, true);
		}

		@Test
		public void testSingleNodeEqual() {
			test(new ListNode(1), new ListNode(1), true);
		}

		@Test
		public void testSingleNodeUnequal() {
			test(new ListNode(1), new ListNode(2), false);
		}

		@Test
		public void testDifferentLengthWithCommonPart() {
			test(createList(1, 2, 3), createList(1, 2), false);
		}

		@Test
		public void testDifferentLengthAndNothingCommon() {
			test(createList(1, 2, 3), createList(4, 5, 6, 7), false);
		}

		@Test
		public void testEqualMultipleNodes() {
			test(createList(1, 2, 3, 4), createList(1, 2, 3, 4), true);
		}

	}

	private void test(ListNode head1, ListNode head2, boolean expectedOutput) {
		assertEquals(ListUtil.equalValueList(head1, head2), expectedOutput);
	}
}
