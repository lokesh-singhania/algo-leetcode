package algo.linked.list;

import static org.testng.Assert.assertTrue;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.sip.SplitInParts;

public class SplitInPartsTest {

	SplitInParts service = new SplitInParts();

	@Test
	public void emptyTest() {
		Assert.assertEquals(service.splitListIntoParts(null, 1), new ListNode[] { null });
	}

	@Test
	public void testOnePart() {
		ListNode list = ListUtil.createList(1, 2, 3, 4);
		assertTrue(Arrays.equals(service.splitListIntoParts(list, 1), new ListNode[] { list }));
	}

	@Test
	public void testForEqualParts() {
		ListNode list = ListUtil.createList(1, 2, 3, 4);
		assertTrue(Arrays.equals(service.splitListIntoParts(list, 2),
				new ListNode[] { ListUtil.createList(1, 2), ListUtil.createList(3, 4) }));
	}

	@Test
	public void testForUnequalParts() {
		ListNode list = ListUtil.createList(1, 2, 3, 4);
		assertTrue(Arrays.equals(service.splitListIntoParts(list, 3),
				new ListNode[] { ListUtil.createList(1, 2), ListUtil.createList(3), ListUtil.createList(4) }));
	}
	
	@Test
	public void testForPartsEqualToSize() {
		ListNode list = ListUtil.createList(1, 2, 3, 4);
		assertTrue(Arrays.equals(service.splitListIntoParts(list, 4),
				new ListNode[] { ListUtil.createList(1), ListUtil.createList(2), ListUtil.createList(3), ListUtil.createList(4) }));
	}
	
	
	@Test
	public void testForPartsGreaterThanSize() {
		ListNode list = ListUtil.createList(1, 2, 3, 4);
		assertTrue(Arrays.equals(service.splitListIntoParts(list, 5),
				new ListNode[] { ListUtil.createList(1), ListUtil.createList(2), ListUtil.createList(3), ListUtil.createList(4), null }));
	}

}
