package algo.linked.list.questions.easy.reverse;

import algo.linked.list.pojo.ListNode;

public class Iterative implements Reverse {

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
