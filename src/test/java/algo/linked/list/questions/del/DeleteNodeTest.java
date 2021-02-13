package algo.linked.list.questions.del;

import static algo.linked.list.ListUtil.createList;
import static algo.linked.list.ListUtil.equalValueList;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import algo.linked.list.ListUtil;
import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.del.sol.DeleteNodeImpl;

public class DeleteNodeTest {
	DeleteNode sol=new DeleteNodeImpl();
	
	@Test
	public void sampleCase() {
		ListNode initialList = createList(1, 2, 3, 4);
		ListNode listAfterDeletion = createList(1,3,4);
		ListNode nodeToDelete = initialList.next;
		test(initialList, listAfterDeletion, nodeToDelete);
	}

	@Test
	public void nullCase() {
		test(null,null,null);
	}
	
	@Test
	public void nullNode() {
		test(createList(1,2,3),createList(1,2,3),null);
	}
	
	
	
	private void test(ListNode initialList, ListNode listAfterDeletion, ListNode nodeToDelete) {
		ListNode list = initialList;
		sol.deleteNode(nodeToDelete);
		assertTrue(equalValueList(listAfterDeletion, list));
	}
	
	
}
