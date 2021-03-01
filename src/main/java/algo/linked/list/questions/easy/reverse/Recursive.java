package algo.linked.list.questions.easy.reverse;

import algo.linked.list.pojo.ListNode;

public class Recursive implements Reverse {

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
