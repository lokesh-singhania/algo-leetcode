package algo.linked.list.questions.easy.remove.sol;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.easy.remove.RemoveElements;

public class Iterative implements RemoveElements{

	@Override
	public ListNode removeElements(ListNode head, int val) {
		ListNode preHead = new ListNode(0,head);
		ListNode node = preHead;
		while(node.next!=null) {
			if(node.next.val ==val) {
				node.next=node.next.next;
			}else {
				node = node.next;
			}
		}
		return preHead.next;
	}

}
