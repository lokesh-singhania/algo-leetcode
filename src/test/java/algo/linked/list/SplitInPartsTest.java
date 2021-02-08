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
		ListNode list = Util.createList(1, 2, 3, 4);
		assertTrue(Arrays.equals(service.splitListIntoParts(list, 1), new ListNode[] { list }));
	}

	@Test
	public void testForEqualParts() {
		ListNode list = Util.createList(1, 2, 3, 4);
		assertTrue(Arrays.equals(service.splitListIntoParts(list, 2),
				new ListNode[] { Util.createList(1, 2), Util.createList(3, 4) }));
	}

	@Test
	public void testForUnequalParts() {
		ListNode list = Util.createList(1, 2, 3, 4);
		assertTrue(Arrays.equals(service.splitListIntoParts(list, 3),
				new ListNode[] { Util.createList(1, 2), Util.createList(3), Util.createList(4) }));
	}
	
	@Test
	public void testForPartsEqualToSize() {
		ListNode list = Util.createList(1, 2, 3, 4);
		assertTrue(Arrays.equals(service.splitListIntoParts(list, 4),
				new ListNode[] { Util.createList(1), Util.createList(2), Util.createList(3), Util.createList(4) }));
	}
	
	
	@Test
	public void testForPartsGreaterThanSize() {
		ListNode list = Util.createList(1, 2, 3, 4);
		assertTrue(Arrays.equals(service.splitListIntoParts(list, 5),
				new ListNode[] { Util.createList(1), Util.createList(2), Util.createList(3), Util.createList(4), null }));
	}

}
