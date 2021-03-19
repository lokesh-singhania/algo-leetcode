package algo.linked.list.questions.remove;

import static algo.linked.list.util.ListUtil.createList;
import static algo.linked.list.util.ListUtil.equalValueList;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.easy.remove.RemoveElements;
import algo.linked.list.questions.easy.remove.sol.Recursive;

public class RemoveElementsTest {

	RemoveElements sol= new Recursive();

	@Test
	public void elementNotPresent() {
		test(createList(1, 2, 5), 3, createList(1, 2, 5));
	}

	@Test
	public void elementPresentOnce() {
		test(createList(1, 2, 3), 1, createList(2, 3));
	}

	@Test
	public void elementPresentMultiple() {
		test(createList(1, 2, 3, 1, 2), 1, createList(2, 3, 2));
	}

	@Test
	public void elementAtEnd() {
		test(createList(1, 2, 3, 4), 4, createList(1, 2, 3));
	}

	@Test
	public void elementInMiddle() {
		test(createList(1, 3, 5, 5), 3, createList(1, 5, 5));
	}

	@Test
	public void elementAtStart() {
		test(createList(1, 2, 45), 1, createList(2, 45));
	}

	void test(ListNode input, int val, ListNode expectedOutput) {
		ListNode output = sol.removeElements(input, val);
		assertTrue(equalValueList(output, expectedOutput));
	}
}
