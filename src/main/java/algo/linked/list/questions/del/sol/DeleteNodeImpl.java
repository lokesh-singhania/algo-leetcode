package algo.linked.list.questions.del.sol;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.del.DeleteNode;

public class DeleteNodeImpl implements DeleteNode{

	@Override
	public void deleteNode(ListNode node) {
		if(node==null || node.next==null) return;
		node.val=node.next.val;
		node.next=node.next.next;
	}

}
