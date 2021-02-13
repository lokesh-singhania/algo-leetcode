package algo.linked.list.questions.reverse.sol;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.reverse.ReverseLinkedList;

public class Recursive implements ReverseLinkedList {

	@Override
	public ListNode reverse(ListNode head) {

		return reverse(null, head);
	}

	private ListNode reverse(ListNode prev, ListNode curr) {
		if (curr == null)
			return prev;
		ListNode next = curr.next;
		curr.next = prev;
		return reverse(curr, next);
	}

}
