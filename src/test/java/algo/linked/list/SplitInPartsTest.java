package algo.linked.list;

import static org.testng.Assert.assertTrue;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SplitInPartsTest {

	SplitInParts service = new SplitInParts();

	@Test
	public void emptyTest() {
		Assert.assertEquals(service.splitListIntoParts(null, 1), new ListNode[] { null });
	}

	@Test
	public void testOnePart() {
		ListNode list = createList(1, 2, 3, 4);
		assertTrue(Arrays.equals(service.splitListIntoParts(list, 1), new ListNode[] { list }));
	}

	@Test
	public void testForEqualParts() {
		ListNode list = createList(1, 2, 3, 4);
		assertTrue(Arrays.equals(service.splitListIntoParts(list, 2),
				new ListNode[] { createList(1, 2), createList(3, 4) }));
	}

	@Test
	public void testForUnequalParts() {
		ListNode list = createList(1, 2, 3, 4);
		assertTrue(Arrays.equals(service.splitListIntoParts(list, 3),
				new ListNode[] { createList(1, 2), createList(3), createList(4) }));
	}
	
	@Test
	public void testForPartsEqualToSize() {
		ListNode list = createList(1, 2, 3, 4);
		assertTrue(Arrays.equals(service.splitListIntoParts(list, 4),
				new ListNode[] { createList(1), createList(2), createList(3), createList(4) }));
	}
	
	
	@Test
	public void testForPartsGreaterThanSize() {
		ListNode list = createList(1, 2, 3, 4);
		assertTrue(Arrays.equals(service.splitListIntoParts(list, 5),
				new ListNode[] { createList(1), createList(2), createList(3), createList(4), null }));
	}
	
	private ListNode createList(int... values) {
		ListNode head = new ListNode(values[0]);
		ListNode prev = head;
		for (int i = 1; i < values.length; i++) {
			ListNode node = new ListNode(values[i]);
			prev.next = node;
			prev = node;
		}
		return head;
	}

}
