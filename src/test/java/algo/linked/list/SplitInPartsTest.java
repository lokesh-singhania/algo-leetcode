package algo.linked.list;

import static org.testng.Assert.assertTrue;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.medium.sip.SplitImpl;
import algo.linked.list.util.ListUtil;

@Ignore
public class SplitInPartsTest {

	SplitImpl service = new SplitImpl();

	@Test
	public void emptyTest() {
		Assert.assertEquals(service.split(null, 1), new ListNode[] { null });
	}

	@Test
	public void testOnePart() {
		ListNode list = ListUtil.createList(1, 2, 3, 4);
		assertTrue(Arrays.equals(service.split(list, 1), new ListNode[] { list }));
	}

	@Test
	public void testForEqualParts() {
		ListNode list = ListUtil.createList(1, 2, 3, 4);
		assertTrue(Arrays.equals(service.split(list, 2),
				new ListNode[] { ListUtil.createList(1, 2), ListUtil.createList(3, 4) }));
	}

	@Test
	public void testForUnequalParts() {
		ListNode list = ListUtil.createList(1, 2, 3, 4);
		assertTrue(Arrays.equals(service.split(list, 3),
				new ListNode[] { ListUtil.createList(1, 2), ListUtil.createList(3), ListUtil.createList(4) }));
	}
	
	@Test
	public void testForPartsEqualToSize() {
		ListNode list = ListUtil.createList(1, 2, 3, 4);
		assertTrue(Arrays.equals(service.split(list, 4),
				new ListNode[] { ListUtil.createList(1), ListUtil.createList(2), ListUtil.createList(3), ListUtil.createList(4) }));
	}
	
	
	@Test
	public void testForPartsGreaterThanSize() {
		ListNode list = ListUtil.createList(1, 2, 3, 4);
		assertTrue(Arrays.equals(service.split(list, 5),
				new ListNode[] { ListUtil.createList(1), ListUtil.createList(2), ListUtil.createList(3), ListUtil.createList(4), null }));
	}

}
