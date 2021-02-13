package algo.linked.list.questions.reverse.sol;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.reverse.ReverseLinkedList;

public class Iterative implements ReverseLinkedList {

	@Override
	public ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode node = head;
		while (node != null) {
			ListNode buffer = node.next;
			node.next = prev;
			prev = node;
			node = buffer;
		}
		return prev;
	}

}
