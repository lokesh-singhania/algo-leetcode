package algo.linked.list.questions.remove.sol;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.remove.RemoveElements;

public class Recursive implements RemoveElements {

	@Override
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		if (head.val == val) 
			return removeElements(head.next, val);
		
		head.next = removeElements(head.next, val);
		return head;

	}

}
