package algo.linked.list.questions.easy.reverse;

import algo.linked.list.pojo.ListNode;

public class BetterRecursive implements Reverse {

	@Override
	public ListNode reverse(ListNode node) {
		if (node == null || node.next == null) {
			return node;
		}
		ListNode newHead = reverse(node.next);
		node.next.next = node;
		node.next = null;
		return newHead;
	}

}
